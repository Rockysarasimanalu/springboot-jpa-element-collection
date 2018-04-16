/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author roky.manalu
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 100)
    private String name;
    
    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;
    
    @ElementCollection                              // to declare element collection mapping
    @CollectionTable(name = "user_phone_numbers",joinColumns = @JoinColumn(name = "user_id"))   //CollectionTable digunakan sebagai table yang menyimpan kolom kolom dan yang berelasi
    @Column(name = "phone_number")
    private Set<String> phoneNumbers = new HashSet<>();
    
    
    @ElementCollection
    @CollectionTable(name = "user_position",joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "position")
    private Set<String> position = new HashSet<>();
    
    
    @ElementCollection(fetch = FetchType.LAZY)      // to declare element collection mapping
    @CollectionTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
    
    @AttributeOverrides({
        @AttributeOverride(name = "addressLine1",column = @Column(name = "house_number")),
        @AttributeOverride(name = "addressLine2",column = @Column(name = "street"))
    })
    
    private Set<Address> addresses = new HashSet<>();
    
    
    public User(){
    
    }
    public User(String name, String email, Set<String> phoneNumbers,Set<String> position, Set<Address> addresses) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
        this.position = position;
    }

    
}
