package org.example.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {

    private final List<User> userList = new ArrayList<>();
    private static final UserRepository userRepository = new UserRepository();

    public Optional<User> findById(String id){
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void save(String id){
        User user = new User(id,UserState.MAIN);
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isEmpty()){
            userList.add(user);
        }
    }

    public static UserRepository getInstance(){
        return userRepository;
    }


}
