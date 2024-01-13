package com.Cataloguegrp.authservice.service;
import com.Cataloguegrp.authservice.model.userCredential;
import com.Cataloguegrp.authservice.repository.userCredentialRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class authService {
    @Autowired
    private userCredentialRepo repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private jwtService service;
    public String saveUser(userCredential credential)
    {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username)
    {
        return service.generateToken(username);
    }
    public void validateToken(String username)
    {
         service.validateToken(username);
    }
}
