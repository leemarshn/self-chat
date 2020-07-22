package com.lenhac.talk.repositories;

import com.lenhac.talk.model.Role;
import com.lenhac.talk.model.User;

public interface UserService {
     void save(User user);
     void saveRole(Role role);
    User findByEmail(String email);

}
