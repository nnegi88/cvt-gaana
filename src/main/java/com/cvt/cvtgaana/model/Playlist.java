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
@Document("playlist")
public class Playlist {
    @Id private String playlistId;
    @Size(min = 2, message = "Playlist name should have atleast two characters.") private String playlistName;
    @NotNull(message = "Playlist must have description") private String playlistDescription;
    @NotNull(message = "Date cannot be empty") private String dateAdded;
    @NotNull(message = "Playlist must have a song") private String userId;

    public String getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getUserId() {
        return userId;
    }
}
