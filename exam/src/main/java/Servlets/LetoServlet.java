package Servlets;import javax.servlet.RequestDispatcher;import javax.servlet.ServletException;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;import java.time.LocalDate;import java.time.LocalDateTime;import java.util.Date;public class LetoServlet extends HttpServlet {    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        String summmer = request.getParameter("summer");        String morning = request.getParameter("morning");        String rightSummmer="no";        String rightMorning="no";        int result = 0;        LocalDateTime date = LocalDateTime.now();        System.out.println(date.getMonthValue());        if(date.getMonthValue() < 9 && date.getMonthValue() > 5)            rightSummmer = "yes";        System.out.println(date.getHour());        if(date.getHour() > 5 && date.getHour() < 12)            rightMorning = "yes";        if(rightMorning.equals(morning))            result += 5;        if(rightSummmer.equals(summmer))            result += 5;        request.setAttribute("result", result);        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/leto.jsp");        requestDispatcher.forward(request, response);    }    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/leto.jsp");        requestDispatcher.forward(request, response);    }}