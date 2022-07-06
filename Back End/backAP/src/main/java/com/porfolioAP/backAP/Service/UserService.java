package com.porfolioAP.backAP.Service;

import com.porfolioAP.backAP.Entity.User;
import com.porfolioAP.backAP.Interface.UserIService;
import com.porfolioAP.backAP.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserIService {
    @Autowired UserRepo userRepo;

    @Override
    public List<User> getUser() {
        List<User> user = userRepo.findAll();
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User findUser(Long id) {
        User user = userRepo.findById(id).orElse(null);
        return user;
    }
}
