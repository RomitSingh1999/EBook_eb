package com.Cataloguegrp.authservice.controller;

import com.Cataloguegrp.authservice.dto.AuthRequest;
import com.Cataloguegrp.authservice.model.userCredential;
import com.Cataloguegrp.authservice.service.authService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/auth")
public class authController {

    @Autowired
    private authService service;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String registerUser(@RequestBody userCredential user)
    {
        return service.saveUser(user);
    }
    @PostMapping("/token")
    public ArrayList<Object> getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {

            ArrayList<Object> Data=new ArrayList<Object>();
            Data.add(service.generateToken(authRequest.getUsername()));
            Data.add(authenticate.getName());
            return Data;
        } else {
            System.out.println("Exception");
            throw new RuntimeException("invalid access");
        }
    }
    @GetMapping("/currentUser")
    public String currentUser(Authentication authentication) {

        return authentication.getName();
    }

    @PostMapping ("/validate")
    public String validateUser(@RequestParam("token") String token)
    {
         service.validateToken(token);
         return "Valid User";
    }

}
