package com.lenhac.talk.repositories;

import com.lenhac.talk.model.User;

public interface UserService {
     void save(User user);

    User findByEmail(String email);

}
