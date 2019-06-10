package app.Servlets;import app.Entities.User;import app.db.DataBaseHandler;import javax.servlet.RequestDispatcher;import javax.servlet.ServletException;import javax.servlet.http.Cookie;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;import java.sql.SQLException;public class AuthServlet extends HttpServlet {    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        System.out.println("Auth servlet doPost");        DataBaseHandler dataBaseHandler = new DataBaseHandler();        String mail = request.getParameter("mail");        String password = request.getParameter("password");        if(mail == null || mail.equals("") || password == null || password.equals("")){            request.setAttribute("result", "Не заполнены поля");        }        User user = null;        try {            user = dataBaseHandler.getByMail(mail);        } catch (SQLException e) {            request.setAttribute("result", "SQL Exception");        }        if (user != null) {            if (!user.getPassword().equals(password)) {                request.setAttribute("result", "Ошибка при вводе данных");                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/auth.jsp");                requestDispatcher.forward(request, response);            } else {                Cookie cookie = new Cookie("currentUser", user.getMail());                response.addCookie(cookie);                response.sendRedirect("home");            }        } else {            request.setAttribute("result", "Ошибка при вводе данных");            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/auth.jsp");            requestDispatcher.forward(request, response);        }    }    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        System.out.println("Auth servlet doGet");        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/auth.jsp");        requestDispatcher.forward(request,response);    }}