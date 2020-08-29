package com.app.token.repository;

import com.app.token.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {


    Optional<Token> findByTokenname (String tokenname);
    Optional<Token> findByTokennameAndUsername(String tokenname, String username);
    boolean existsByTokennameAndUsername(String tokenname, String username);
    boolean existsByTokenname(String tokenname);

}
