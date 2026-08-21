package vksonpdl_first_mcp.flac.test;

import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;
import vksonpdl_first_mcp.flac.FlacFileInfo;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class FlacTestMCP {

    private final List<FlacFileInfo> flacFileInfoList;

    @McpTool(name = "get-all-songs",description = "This API returns All the Available songs from the FLAC folder")
    public List<FlacFileInfo> getAvailableSongs() {
       return flacFileInfoList;
    }

    @McpTool(name = "get-album-list",description = "This API returns All the Available Album names from the FLAC folder")
    public List<String> getAlbumList(){
        return flacFileInfoList.stream().map(FlacFileInfo::getAlbum).distinct().toList();
    }

    @McpTool(name = "get-songs-by-album",description = "This API returns All the Available songs from the FLAC folder Based on the provided album name")
    public List<FlacFileInfo> getSongsBasedOnAlbum( @McpToolParam(description = "The Album Name") String albumName){
        return flacFileInfoList.stream().filter(flacFileInfo -> flacFileInfo.getAlbum().equalsIgnoreCase(albumName)).toList();
    }

    @McpTool(name = "get-songs-by-album-like",description = "This API returns All the Available songs from the FLAC folder Based on the provided album name - it will match with like")
    public List<FlacFileInfo> getSongsBasedOnAlbumLike( @McpToolParam(description = "The Album Name") String albumName){
        return flacFileInfoList.stream().filter(flacFileInfo -> flacFileInfo.getAlbum().contains(albumName.toUpperCase(Locale.ROOT))).toList();
    }



}
