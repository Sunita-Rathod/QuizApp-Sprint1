package com.qna.app.service;
import com.qna.app.dao.UserDao;
import com.qna.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
    @Autowired
    private UserDao userDao;

    

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userDao.findById(id);
    }

    public User createUser(User user) {
        // Perform validation or business logic if needed
        return userDao.save(user);
    }

    public User updateUser(int id, User updatedUser) {
        // Check if the user with the given ID exists
        if (userDao.existsById(id)) {
            updatedUser.setId(id);
            return userDao.save(updatedUser);
        } else {
            // Handle the case where the user with the given ID does not exist
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
    }

    public void deleteUser(int id) {
    	userDao.deleteById(id);
    }

    // Add additional service methods as needed
}
