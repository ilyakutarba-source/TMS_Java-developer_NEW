package HomeWork25;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/verse")
public class VerseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String contextPath = request.getContextPath();
        response.getWriter().println("""
                <!DOCTYPE html>
                <html lang="ru">
                <head>
                    <meta charset="UTF-8">
                    <title>Не позволяй душе лениться</title>
                    <style>
                        body {
                            margin: 0;
                            color: #222;
                            background: #fff;
                            font-family: Georgia, "Times New Roman", serif;
                            font-size: 20px;
                            line-height: 1.15;
                        }

                        .page {
                            width: 366px;
                        }

                        h1 {
                            margin: 4px 4px 18px;
                            font-size: 24px;
                            line-height: 1.15;
                        }

                        hr {
                            height: 1px;
                            margin: 0 0 10px;
                            border: 0;
                            background: #cfcfcf;
                        }

                        img {
                            display: block;
                            width: 284px;
                            height: 188px;
                            margin: 0 0 10px 4px;
                            object-fit: cover;
                        }

                        .verse {
                            margin: 18px 4px;
                            white-space: pre-line;
                        }

                        .author {
                            margin: 20px 4px 0;
                            font-size: 16px;
                        }
                    </style>
                </head>
                <body>
                <main class="page">
                    <h1>Не позволяй душе лениться</h1>
                    <hr>
                    <img src="%s/images/HomeWork25/landscape.png" alt="Дорога в поле">
                    <hr>
                    <div class="verse">Не позволяй душе лениться!
                Чтоб в ступе воду не толочь,
                Душа обязана трудиться
                И день и ночь, и день и ночь!

                Гони её от дома к дому,
                Тащи с этапа на этап,
                По пустырю, по бурелому
                Через сугроб, через ухаб!

                Не разрешай ей спать в постели
                При свете утренней звезды,
                Держи лентяйку в чёрном теле
                И не снимай с неё узды!</div>
                    <hr>
                    <p class="author">В.Заболоцкий</p>
                </main>
                </body>
                </html>
                """.formatted(contextPath));
    }
}