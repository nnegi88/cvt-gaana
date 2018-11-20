package com.cvt.cvtgaana.controller;

import com.cvt.cvtgaana.model.Song;
import com.cvt.cvtgaana.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongService songService;

    @RequestMapping(method = RequestMethod.GET, value = "/songs")
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/songs/playlists/{playlistId}")
    public List<Song> getAllSongsOfPlaylist(@PathVariable String playlistId){
        return songService.getAllSongsOfPlaylist(playlistId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/songs/{songId}")
    public Song getSongById(@PathVariable String songId){
        return songService.getSongById(songId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/songs")
    public void saveSong(@RequestBody Song song){
        songService.saveSong(song);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/songs")
    public void updateSong(@RequestBody Song song){
        songService.saveSong(song);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/songs/{songId}")
    public void deleteSong(@PathVariable String songId){
        songService.deleteSong(songId);
    }
}
