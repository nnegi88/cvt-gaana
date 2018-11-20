package com.cvt.cvtgaana.controller;

import com.cvt.cvtgaana.model.Playlist;
import com.cvt.cvtgaana.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @RequestMapping(method = RequestMethod.GET, value = "/playlists")
    public List<Playlist> getAllPlaylist(){
        return playlistService.getAllPlaylist();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlists/users/{userId}")
    public List<Playlist> getAllPlaylistOfUser(@PathVariable String userId){
        return playlistService.getAllPlaylistOfUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlists/{playlistId}")
    public Playlist getPlaylistById(@PathVariable String playlistId){
        return playlistService.getPlaylistById(playlistId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/playlists")
    public void savePlaylist(@RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/playlists/{playlistId}")
    public void deletePlaylist(@PathVariable String playlistId){
        playlistService.deletePlaylist(playlistId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/playlists")
    public void updatePlaylist(@RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
    }
}
