package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongDalImpl implements SongDal {
    private MongoTemplate mongoTemplate;

    @Autowired
    public SongDalImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Song> getAllSongs() {
        return mongoTemplate.findAll(Song.class);
    }

    @Override
    public List<Song> getAllSongsOfPlaylist(String playlistId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("playlistId").is(playlistId));
        return mongoTemplate.find(query, Song.class);
    }

    @Override
    public Song getSongById(String songId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(songId));
        return mongoTemplate.findOne(query, Song.class);
    }

    @Override
    public void saveSong(Song song) {
        mongoTemplate.save(song);
    }

    @Override
    public void deleteSong(String songId) {
        mongoTemplate.remove(getSongById(songId));
    }
}
