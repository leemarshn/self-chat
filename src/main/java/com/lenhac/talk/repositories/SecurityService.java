package com.lenhac.talk.repositories;


public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
