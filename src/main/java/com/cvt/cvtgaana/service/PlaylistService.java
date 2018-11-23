package com.cvt.cvtgaana.service;

import com.cvt.cvtgaana.dal.PlaylistDal;
import com.cvt.cvtgaana.model.Playlist;
import com.cvt.cvtgaana.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getAllPlaylist();
    List<Playlist> getAllPlaylistOfUser(String userId);
    Playlist getPlaylistById(String playlistId);
    void savePlaylist(Playlist playlist);
    void updatePlaylistById(String playlistId, Playlist playlist);
    void deletePlaylist(String playlistId);
}
