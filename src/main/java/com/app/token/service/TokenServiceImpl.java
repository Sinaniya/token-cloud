package com.app.token.service;

import com.app.token.model.Token;
import com.app.token.repository.TokenRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository repository;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public void create(String tokenname) {
        Optional<Token> token = repository.findByTokenname(tokenname);
        if (token.isPresent()) {
            throw new RuntimeException();
        }
        Token newToken = new Token();
        newToken.setTokenname(tokenname);
        newToken.setUsername("not specified");
        repository.save(newToken);
    }


    @Override
    public void create(String tokenname, String username) {
        Optional<Token> token = repository.findByTokenname(tokenname);
        if (token.isPresent()) {
            throw new RuntimeException();
        }
        Token newToken = new Token();
        newToken.setTokenname(tokenname);
        newToken.setUsername(username);
        repository.save(newToken);
    }

    @Override
    public void delete(String tokenname) {
        Token token = repository.findByTokenname(tokenname).orElseThrow(RuntimeException::new);
        repository.delete(token);
    }

    @Override
    public boolean exists(String tokenname) {
        return repository.existsByTokenname(tokenname);
    }

    @Override
    public boolean exists(String tokenname, String username) {
        return repository.existsByTokennameAndUsername(tokenname, username);
    }

    @Override
    public Token find(String tokenname) {
        Token token = repository.findByTokenname(tokenname).orElseThrow(RuntimeException::new);
        return token;
    }

    @Override
    public Token find(String tokenname, String username) {
        Token token = repository.findByTokennameAndUsername(tokenname, username).orElseThrow(RuntimeException::new);
        return token;
    }

    @Override
    public List<Token> findAll() {
        return repository.findAll();
    }

    @Override
    public void addUser(String username) {

    }

//    @Override
//    public void addUser(String tokenname, String username){
//       Token token = repository.findByTokenname(tokenname).orElseThrow(RuntimeException::new);
//       token.setUsername(username);
//       //restTemplate.getForObject("http://user-service/api/v1/users")
//    }


    @Override
    public void deleteUser(String username) {
        //Token token=repository.findByTokennameAndUsername()Username(username).orElseThrow(RuntimeException::new);
        //   token.setUsername("deleted");
    }


}
