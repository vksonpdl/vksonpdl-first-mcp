package vksonpdl.firstmcp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;


@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping("/health")
    public Map<String, String> getHealth() {
        return getResponseMap("NO");

    }

    @GetMapping("/health-with-token")
    public Map<String, String> getHealthWithToken() {
        return getResponseMap("YES");
    }

    private Map<String, String> getResponseMap(String withToken){
        return Map.of(
                "STATUS", "OK",
                "CURRENT_DATETIME", LocalDateTime.now(ZoneId.of("Asia/Kolkata")) + " IST",
                "WITH_TOKEN",withToken
        );
    }
}
