package com.cvt.cvtgaana.model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document("song")
public class Song {
    @Id private String songId;
    @Size(min = 2, message = "Song name should have atleast two characters") private String songName;
    @NotNull(message = "Song path cannot be empty") private String songPath;
    @NotNull(message = "Date should be mentioned") private String dateAdded;
    @NotNull(message = "Song must be of some playlist") private String playlistId;

    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongPath() {
        return songPath;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getPlaylistId() {
        return playlistId;
    }
}
