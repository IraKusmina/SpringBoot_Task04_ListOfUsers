package ru.kolomiets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kolomiets.models.User;
import ru.kolomiets.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public void saveUser(User user){
        repository.save(user);
    }
}
