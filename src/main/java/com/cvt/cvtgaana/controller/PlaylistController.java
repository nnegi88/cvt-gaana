package com.cvt.cvtgaana.controller;

import com.cvt.cvtgaana.model.Playlist;
import com.cvt.cvtgaana.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Playlist> getAllPlaylist(){
        return playlistService.getAllPlaylist();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public List<Playlist> getAllPlaylistOfUser(@PathVariable String userId){
        return playlistService.getAllPlaylistOfUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{playlistId}")
    public Playlist getPlaylistById(@PathVariable String playlistId){
        return playlistService.getPlaylistById(playlistId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<Object> savePlaylist(@Valid @RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(playlist.getPlaylistId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{playlistId}")
    public void deletePlaylist(@PathVariable String playlistId){
        playlistService.deletePlaylist(playlistId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{playlistId}")
    public void updatePlaylist(@PathVariable String playlistId, @Valid @RequestBody Playlist playlist){
        playlistService.updatePlaylistById(playlistId, playlist);
    }
}
