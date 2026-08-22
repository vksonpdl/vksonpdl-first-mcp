package vksonpdl.firstmcp.flac.data;


import org.springframework.data.jpa.repository.JpaRepository;
import vksonpdl.firstmcp.flac.data.entity.AlbumEntity;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer>{
    Optional<AlbumEntity> findByAlbumName(String albumName);
}
