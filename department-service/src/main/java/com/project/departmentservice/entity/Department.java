package com.project.departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity   // it species this class has an jpa entity 
@Table(name="department")//if we dont use table annotation  ,JPA will create table by using class name.

public class Department {
   
    
     @Id // to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// this  is for primary key generation strategy 
    /* Auto,sequence,identity,table->
    among this identity internally  uses  auto increament features to  increament the primary key  */
   
    private Long id;

    
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
