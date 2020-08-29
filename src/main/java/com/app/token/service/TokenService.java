package com.app.token.service;

import com.app.token.model.Token;

import java.util.List;
import java.util.Optional;

public interface TokenService {
    void create(String tokenname);
    void create(String tokenname, String username);
    void delete(String tokenname);
    boolean exists(String tokenname);
    boolean exists(String tokenname, String username);
    Token find(String tokenname);
    Token find(String tokenname, String username);
    List<Token> findAll();
    void addUser(String username);
    void deleteUser(String username);

}
