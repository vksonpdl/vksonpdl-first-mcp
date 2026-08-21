package vksonpdl.firstmcp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.List;
public class OAuthMetadataController {

    @Value("${spring.security.jwt.issuer-uri}")
    private String issuerUri;

    @Value("${spring.security.jwt.resource}")
    private String resource;

    @GetMapping("/.well-known/oauth-protected-resource")
    public Map<String, Object> getProtectedResourceMetadata() {
        return Map.of(
                "resource", resource,
                "authorization_servers", List.of(issuerUri)
        );
    }
}
