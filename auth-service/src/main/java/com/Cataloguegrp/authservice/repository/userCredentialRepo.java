package com.Cataloguegrp.authservice.repository;

import com.Cataloguegrp.authservice.model.userCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userCredentialRepo extends JpaRepository<userCredential,Integer> {
    Optional<userCredential> findByName(String username);
}
