package vksonpdl_first_mcp.flac;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlacFileInfo {

    private String fileName;
    private String album;
    private String title;
    private String language;
    private String titleSort;
    private String year;
    private String exception;
    private Boolean deleted;
    private Boolean duplicate;
}