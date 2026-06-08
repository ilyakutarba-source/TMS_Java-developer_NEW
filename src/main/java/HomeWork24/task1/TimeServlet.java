package HomeWork24.task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class TimeServlet extends HttpServlet {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final Map<String, CityTime> CITY_TIMES = Map.of(
            "/minsk", new CityTime("Minsk", ZoneId.of("Europe/Minsk")),
            "/washington", new CityTime("Washington", ZoneId.of("America/New_York")),
            "/beijing", new CityTime("Beijing", ZoneId.of("Asia/Shanghai"))
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");

        CityTime cityTime = CITY_TIMES.get(request.getServletPath());
        if (cityTime == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown city");
            return;
        }

        String currentTime = LocalDateTime.now(cityTime.zoneId()).format(FORMATTER);
        response.getWriter().printf("Current time in %s: %s%n", cityTime.name(), currentTime);
    }

    private record CityTime(String name, ZoneId zoneId) {
    }
}
