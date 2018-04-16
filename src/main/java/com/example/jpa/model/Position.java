/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author roky.manalu
 */
@Embeddable
public class Position {
    
    @NotNull
    @Size(max = 100)
    private String position1;
    
    @NotNull
    @Size(max = 100)
    private String position2;
    
    @NotNull
    @Size(max = 100)
    private String salary;
    
    @NotNull
    @Size(max = 100)
    private String department;
    
    public Position(){
    
    }
    
    public Position(String position1, String position2, String salary, String department){
        this.position1 = position1;
        this.position2 = position2;
        this.salary = salary;
        this.department = department;
    }
}