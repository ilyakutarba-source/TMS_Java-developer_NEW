/**
 * @author Ilya
 * @date 12.06.2026
 */
package HomeWork28;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/save-request")
public class SaveRequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");

        // проверка на null
        if (name == null || name.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || message == null || message.trim().isEmpty()) {
            req.setAttribute("errorMsg", "Все поля обязательны для заполнения!");
            req.getRequestDispatcher("/save-request.jsp").forward(req, resp);
            return;
        }
        name = name.trim();
        email = email.trim();
        message = message.trim();


        HttpSession session = req.getSession();
        session.setAttribute("savedName", name);
        session.setAttribute("savedEmail", email);
        session.setAttribute("savedMessage", message);

        resp.sendRedirect(req.getContextPath() + "/request-success.jsp");
    }
}
