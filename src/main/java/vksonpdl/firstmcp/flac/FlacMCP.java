package vksonpdl.firstmcp.flac;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;
import vksonpdl.firstmcp.flac.model.AlbumModel;
import vksonpdl.firstmcp.flac.model.TrackModel;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class FlacMCP {

    private final FlacService flacService;

    @McpTool(
            name = "get-album-list",
            description = "This API returns All the Distinct Available Album Names along with the Corresponding Album Id"
    )
    public List<AlbumModel> getAlbumList() {
        return flacService.getAlbums();
    }

    @McpTool(
            name = "get-songs-by-album-id",
            description = "This API returns All the Available songs Based on the Album Id"
    )
    public Map<String, List<TrackModel>> getSongsByAlbumId(@McpToolParam(description = "The Album Name") Integer albumId) {
        return flacService.getSongsByAlbumId(albumId);
    }


    @McpTool(
            name = "get-all-songs",
            description = "This API returns All the Available songs"
    )
    public Map<String, List<TrackModel>> getAllSongs() {
       return flacService.getAllSongs();
    }

}
