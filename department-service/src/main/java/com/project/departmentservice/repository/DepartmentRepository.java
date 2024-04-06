 package com.project.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.departmentservice.entity.Department;



//import jakarta.transaction.Transactional;

//to perform crud operations on user 
/*JPA repository is an generic interface  it is from springframework 
we  need to pass two arguments one is type of entity(Department) and type of primary key (Long)*/

//jpa repo will provide all crud methods for users entity
//no need to implement methods for userRepository

/*
*Jpa repo internally extends crud repository interface
*implementation  for crud repo  interface available in  
JpaRepository interface-> SimpleJpaRepository.class -> which implements ->JpaRepositoryImplementation interface->internally extends
JpaRepository interface .

* for Department Repository we no need to specify @Repository annotation because its already defined in  SimpleJpaRepository.class
*for Department  Repository we no need to specify @Transactional annotation because its all the methods  in  SimpleJpaRepository.class are  transactional


*/

public interface DepartmentRepository  extends JpaRepository<Department, Long>
{
// we need to write  spring data custom query method  to retrieve user by  dept code

Department  findByDepartmentCode(String departmentCode);
//it retrieve entity by dept code

}
