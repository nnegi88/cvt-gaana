package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistDalImpl implements PlaylistDal {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PlaylistDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return mongoTemplate.findAll(Playlist.class);
    }

    @Override
    public List<Playlist> getAllPlaylistOfUser(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.find(query, Playlist.class);
    }

    @Override
    public Playlist getPlaylistById(String playlistId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(playlistId));
        return mongoTemplate.findOne(query, Playlist.class);
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        mongoTemplate.save(playlist);
    }

    @Override
    public void deletePlaylist(String playlistId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(playlistId));
        Playlist playlist = mongoTemplate.findOne(query, Playlist.class);
        mongoTemplate.remove(playlist);
    }
}
