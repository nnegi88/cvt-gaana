package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.User;
import com.cvt.cvtgaana.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDalImpl implements UserDal {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        if (user==null) throw new UserNotFoundException(userId);
        return user;
    }

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void updateUserById(String userId, User user) {
        User updatedUser = getUserById(userId);
        updatedUser = user;
        mongoTemplate.save(updatedUser);
    }

    @Override
    public void deleteUser(String userId) throws UserNotFoundException{
        mongoTemplate.remove(getUserById(userId));
    }
}
