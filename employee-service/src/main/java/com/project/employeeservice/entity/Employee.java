package com.project.employeeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity  // it specifies this class has jpa entity
@Table(name="employees") //if we dont use table annotation  ,JPA will create table by using class name.
public class Employee {

    @Id // to configure primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// this  is for primary key generation strategy
    /* Auto,sequence,identity,table->
    among this identity internally  uses  auto increament features to  increament the primary key  */

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private String organizationCode;

}
