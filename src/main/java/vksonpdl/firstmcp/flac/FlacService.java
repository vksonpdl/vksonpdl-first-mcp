package vksonpdl.firstmcp.flac;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import vksonpdl.firstmcp.flac.data.AlbumRepository;
import vksonpdl.firstmcp.flac.data.TrackRepository;
import vksonpdl.firstmcp.flac.data.entity.AlbumEntity;
import vksonpdl.firstmcp.flac.data.entity.TrackEntity;
import vksonpdl.firstmcp.flac.model.AlbumModel;
import vksonpdl.firstmcp.flac.model.TrackModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class FlacService {
    private final AlbumRepository albumRepository;
    private final TrackRepository trackRepository;

    public List<AlbumModel> getAlbums() {
        return albumRepository.findAll().parallelStream().map(this::mapToAlbum).toList();
    }

    public Map<String, List<TrackModel>> getAllSongs(){

        Map<String, List<TrackModel>> allTrackMap = new HashMap<>();

        albumRepository.findAll().forEach(albumEntity -> {
            allTrackMap.put(albumEntity.getAlbumName(),
                    albumEntity.getTracks()
                            .stream()
                            .map(this::mapToTrackModel)
                            .toList());

        });

        return allTrackMap;

    }



    public Map<String, List<TrackModel>> getSongsByAlbumId(Integer albumId){
        AlbumEntity albumEntity =  albumRepository.getReferenceById(albumId);
        return Map.of(
                albumEntity.getAlbumName(),
                albumEntity.getTracks()
                        .stream()
                        .map(this::mapToTrackModel)
                        .toList()
        );


    }

    private AlbumModel mapToAlbum(AlbumEntity albumEntity) {
        AlbumModel albumModel = new AlbumModel();
        BeanUtils.copyProperties(albumEntity, albumModel);
        return albumModel;

    }

    private TrackModel mapToTrackModel(TrackEntity trackEntity){
        TrackModel trackModel = new TrackModel();
        BeanUtils.copyProperties(trackEntity, trackModel);
        return trackModel;
    }


}
