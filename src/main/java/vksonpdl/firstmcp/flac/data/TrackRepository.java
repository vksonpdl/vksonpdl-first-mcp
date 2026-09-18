package vksonpdl.firstmcp.flac.data;


import org.springframework.data.jpa.repository.JpaRepository;
import vksonpdl.firstmcp.flac.data.entity.TrackEntity;

public interface TrackRepository extends JpaRepository<TrackEntity, Integer>{
}
