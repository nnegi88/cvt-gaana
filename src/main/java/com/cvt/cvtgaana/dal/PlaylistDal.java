package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.Playlist;

import java.util.List;

public interface PlaylistDal {
    List<Playlist> getAllPlaylist();
    List<Playlist> getAllPlaylistOfUser(String userId);
    Playlist getPlaylistById(String playlistId);
    void updatePlaylistById(String playlistId, Playlist playlist);
    void savePlaylist(Playlist playlist);
    void deletePlaylist(String playlistId);
}
