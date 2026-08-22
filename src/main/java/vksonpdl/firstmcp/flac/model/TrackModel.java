package vksonpdl.firstmcp.flac.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackModel {

    private Integer trackId;
    private String title;
    private String fileName;
    private String yearReleased;
}
