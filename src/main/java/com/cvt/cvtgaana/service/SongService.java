package com.cvt.cvtgaana.service;

import com.cvt.cvtgaana.dal.SongDal;
import com.cvt.cvtgaana.dal.SongDalImpl;
import com.cvt.cvtgaana.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongDal songDal;

    public List<Song> getAllSongs(){
        return songDal.getAllSongs();
    }

    public List<Song> getAllSongsOfPlaylist(String playlistId){
        return songDal.getAllSongsOfPlaylist(playlistId);
    }

    public Song getSongById(String songId){
        return songDal.getSongById(songId);
    }

    public void saveSong(Song song){
        songDal.saveSong(song);
    }

    public void deleteSong(String songId){
        songDal.deleteSong(songId);
    }
}
