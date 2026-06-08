package HomeWork24.task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/age")
public class AgeServlet extends HttpServlet {
    private static final int ADULT_AGE = 18;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");

        String ageParameter = request.getParameter("age");
        if (ageParameter == null || ageParameter.isBlank()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Pass age parameter, for example: /age?age=18");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageParameter);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Age must be a number");
            return;
        }

        if (age < 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Age cannot be negative");
            return;
        }

        if (age >= ADULT_AGE) {
            response.getWriter().println("Adult");
        } else {
            response.getWriter().println("Minor");
        }
    }
}
