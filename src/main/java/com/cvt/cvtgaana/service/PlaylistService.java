package com.cvt.cvtgaana.service;

import com.cvt.cvtgaana.dal.PlaylistDal;
import com.cvt.cvtgaana.model.Playlist;
import com.cvt.cvtgaana.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistDal playlistDal;

    public List<Playlist> getAllPlaylist() { return playlistDal.getAllPlaylist(); }

    public List<Playlist> getAllPlaylistOfUser(String userId){
        return playlistDal.getAllPlaylistOfUser(userId);
    }

    public Playlist getPlaylistById(String playlistId){
        return playlistDal.getPlaylistById(playlistId);
    }

    public void savePlaylist(Playlist playlist){
        playlistDal.savePlaylist(playlist);
    }

    public void deletePlaylist(String playlistId){
        playlistDal.deletePlaylist(playlistId);
    }
}
