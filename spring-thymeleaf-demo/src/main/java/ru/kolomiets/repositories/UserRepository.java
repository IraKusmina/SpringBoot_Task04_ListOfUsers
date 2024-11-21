package ru.kolomiets.repositories;

import org.springframework.stereotype.Component;
import ru.kolomiets.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserRepository {
    private Map<Long, User> allUsers = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    public List<User> findAll(){
        return new ArrayList<>(allUsers.values());
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(counter.incrementAndGet());
        }
        allUsers.put(user.getId(), user);
        return user;
    }
}
