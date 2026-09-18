package vksonpdl.firstmcp.flac.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumModel {

    private Integer albumId;
    private String language;
    private String albumName;

}
