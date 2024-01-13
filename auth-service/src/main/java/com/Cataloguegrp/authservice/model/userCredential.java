package com.Cataloguegrp.authservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@Data
public class userCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String email;
    private String password;
    private String contact;
    private String gender;
    private String dob;
    private String created_at;
    private int addressId;
    private String role;

}
