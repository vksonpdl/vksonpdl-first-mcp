package vksonpdl_first_mcp.flac.test;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import vksonpdl_first_mcp.flac.FlacFileInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Configuration
@RequiredArgsConstructor
public class ConfigClass {

    @Value("classpath:/static/song-info.json")
    private Resource resource;

    private final ObjectMapper objectMapper;

    @Bean
    public List<FlacFileInfo> flacFileInfoList() throws IOException {
        return objectMapper.readValue(resource.getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });
    }
}
