package vksonpdl.firstmcp.flac.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracks")
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Integer trackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private AlbumEntity album;

    @Column(name = "title")
    private String title;

    @Column(name = "title_sort")
    private String titleSort ;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "language")
    private String language;

    @Column(name = "year_released")
    private String yearReleased;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
