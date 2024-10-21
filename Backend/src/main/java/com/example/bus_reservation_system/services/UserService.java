package com.example.bus_reservation_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bus_reservation_system.entity.User;
import com.example.bus_reservation_system.repositories.UserDao;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User saveUser(@RequestBody User user) {
        return userDao.save(user);
    }

    public Optional<User> getUser(Long id){
        return userDao.findById(id);
    }

    public List<User> getAllUser(){
        return userDao.findAll();
    }

    public ResponseEntity<User> updateUser(@PathVariable  long id, User user) {
        Optional<User> existingUserOpt = userDao.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());

            User updatedUser = userDao.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void delete(long id){
        userDao.deleteById(id);
    }
}

