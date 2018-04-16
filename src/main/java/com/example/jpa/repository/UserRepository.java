/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.repository;

import com.example.jpa.model.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roky.manalu
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
