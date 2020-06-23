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
 
@WebServlet(urlPatterns = { "/editStudent" })
public class EditStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditStudentServlet() {
        super();
    }
 
    // Отобразить страницу редактирования продукта.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String name= (String) request.getParameter("name");
 
        Student student = null;
 
        String errorString = null;
 
        try {
           student = DBUtils.findStudent(conn, name);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // Ошибки не имеются.
        // Продукт не существует для редактирования (edit).
        // Redirect
        if (errorString != null && student == null) {
            response.sendRedirect(request.getServletPath() + "/studentList");
            return;
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("student", student);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editStudentView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // После того, как пользователь отредактировал информацию продукта и нажал на Submit.
    // Данный метод будет выполнен.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String avgMarkStr = (String) request.getParameter("avgMark");
        String parent = (String) request.getParameter("parent");
        int id = 0;
        float avgMark = 0;
        try {
            id  = Integer.parseInt(idStr);
            avgMark = Float.parseFloat(avgMarkStr);
        } catch (Exception e) {
        }
        Student student = new Student(id, name, avgMark, parent);
 
        String errorString = null;
 
        try {
            DBUtils.updateStudent(conn, student);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("student", student);
 
        // Если имеется ошибка, forward к странице edit.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editStudentView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect к странице со списком продуктов.
        else {
            response.sendRedirect(request.getContextPath() + "/studentList");
        }
    }
 
}

