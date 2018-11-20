package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.Song;

import java.util.List;

public interface SongDal {
    List<Song> getAllSongs();
    List<Song> getAllSongsOfPlaylist(String playlistId);
    Song getSongById(String songId);
    void saveSong(Song song);
    void deleteSong(String songId);
}
