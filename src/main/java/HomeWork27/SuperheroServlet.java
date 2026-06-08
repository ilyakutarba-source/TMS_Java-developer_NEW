package HomeWork27;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/superhero")
public class SuperheroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("""
                <!doctype html>
                <html lang="ru">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Супергерой</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body class="bg-light">
                <nav class="navbar navbar-dark bg-primary mb-4">
                    <div class="container">
                        <span class="navbar-brand mb-0 h1">Мой супергерой</span>
                    </div>
                </nav>

                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-8">
                            <div class="card shadow-sm">
                                <div class="card-header bg-danger text-white">
                                    Человек-паук
                                </div>
                                <div class="card-body">
                                    <h1 class="card-title">Питер Паркер</h1>
                                    <p class="card-text">
                                        Человек-паук - это обычный парень, который получил суперспособности
                                        после укуса паука. Он помогает людям, ловит преступников и старается
                                        не забывать про учебу и обычную жизнь.
                                    </p>

                                    <h4>Способности</h4>
                                    <ul class="list-group mb-3">
                                        <li class="list-group-item">Лазает по стенам</li>
                                        <li class="list-group-item">Быстро реагирует на опасность</li>
                                        <li class="list-group-item">Использует паутину</li>
                                    </ul>

                                    <div class="alert alert-warning">
                                        Главная идея героя: с большой силой приходит большая ответственность.
                                    </div>

                                    <button class="btn btn-primary">Мне нравится этот герой</button>
                                </div>
                                <div class="card-footer text-muted">
                                    Страница сделана с Bootstrap
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                </body>
                </html>
                """);
    }
}