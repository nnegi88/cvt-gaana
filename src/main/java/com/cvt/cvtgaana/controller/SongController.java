package com.cvt.cvtgaana.controller;

import com.cvt.cvtgaana.model.Song;
import com.cvt.cvtgaana.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlists/{playlistId}")
    public List<Song> getAllSongsOfPlaylist(@PathVariable String playlistId){
        return songService.getAllSongsOfPlaylist(playlistId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{songId}")
    public Song getSongById(@PathVariable String songId){
        return songService.getSongById(songId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<Object> saveSong(@Valid @RequestBody Song song){
        songService.saveSong(song);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(song.getSongId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{songId}")
    public void updateSong(@PathVariable String songId, @Valid @RequestBody Song song){
        songService.updateSongById(songId, song);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{songId}")
    public void deleteSong(@PathVariable String songId){
        songService.deleteSong(songId);
    }
}
