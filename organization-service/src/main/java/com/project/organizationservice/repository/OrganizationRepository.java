package com.project.organizationservice.repository;

import com.project.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository  extends JpaRepository<Organization ,Long> {

    // create query method to fetch data from db  using orgcode

    Organization findByOrganizationCode(String organizationCode);



}
