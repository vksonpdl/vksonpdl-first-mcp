/*
package vksonpdl.firstmcp.oauth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
public class OAuthMetadataController {

    @Value("${spring.security.jwt.issuer-uri}")
    private String issuerUri;

    @Value("${spring.security.jwt.authorize-uri}")
    private String authorizeUri;

    @Value("${spring.security.jwt.token-uri}")
    private String tokenUri;

    @Value("${spring.security.jwt.jwks-uri}")
    private String jwksUri;

    @GetMapping("/.well-known/oauth-authorization-server")
    public ResponseEntity<Map<String, Object>> getOAuthMetadata() {
        Map<String, Object> metadata = new HashMap<>();

        // Point Claude directly to your Auth0 Tenant
        metadata.put("issuer", issuerUri);
        metadata.put("authorization_endpoint",authorizeUri);
        metadata.put("token_endpoint", tokenUri);
        metadata.put("jwks_uri", jwksUri);
        metadata.put("response_types_supported", List.of("code"));

        return ResponseEntity.ok(metadata);
    }
}
*/
