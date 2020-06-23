package school_control.servlet;

import java.io.IOException;


import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import school_control.beans.Teacher;
import school_control.utils.DBUtils;
import school_control.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/register" })
public class CreateTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateTeacherServlet() {
        super();
    }
 
    // Отобразить страницу создания продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createTeacherView.jsp");
        dispatcher.forward(request, response);
    }
 
    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String name = (String) request.getParameter("userName");
        String password = (String) request.getParameter("password");
        String workexpStr = (String) request.getParameter("workExp");
        float work_exp = 0;
        
        try {
            work_exp = Float.parseFloat(workexpStr);
            
        } catch (Exception e) {
        }
        Teacher teacher = new Teacher(name, password, work_exp);
        
 
        String errorString = null;
        
        String regex = "\\w+";
        
        if (name == null || !name.matches(regex)) {
        	errorString = "Your name invalid";
        }
       
       
 
        if (errorString == null) {
            try {
                DBUtils.insertTeacher(conn, teacher);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("teacher", teacher);
 
        // Если имеется ошибка forward (перенаправления) к странице 'edit'.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createTeacherView.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
 
}