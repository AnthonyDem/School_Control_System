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
 
import school_control.beans.Student;
import school_control.utils.DBUtils;
import school_control.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createStudent" })
public class CreateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateStudentServlet() {
        super();
    }
 
    // Отобразить страницу создания продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createStudentView.jsp");
        dispatcher.forward(request, response);
    }
 
    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String avgMarkStr = (String) request.getParameter("avgMark");
        String parent = (String) request.getParameter("parent");
        float avgMark = 0;
        int id = 0;
        try {
            avgMark = Float.parseFloat(avgMarkStr);
            id = Integer.parseInt(idStr);
            
        } catch (Exception e) {
        }
        Student student = new Student(id,name,avgMark, parent);
        
 
        String errorString = null;
        
        String regex = "\\w+";
        
        if (name == null || !name.matches(regex)) {
        	errorString = "Your name invalid";
        }
       
       
 
        if (errorString == null) {
            try {
                DBUtils.insertStudent(conn, student);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("student", student);
 
        // Если имеется ошибка forward (перенаправления) к странице 'edit'.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createStudentView.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/studentList");
        }
    }
 
}
