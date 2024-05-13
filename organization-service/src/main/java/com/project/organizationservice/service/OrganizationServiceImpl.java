package com.project.organizationservice.service;

import com.project.organizationservice.dto.OrganizationDto;
import com.project.organizationservice.entity.Organization;
import com.project.organizationservice.mapper.AutoOrganizationMapper;
import com.project.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

// 3) mapstruct library
        // convert DEPARTMENT DTO to JPA entity object
        Organization organization= AutoOrganizationMapper.MAPPER.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        // convert jpa entity into deptDto

        OrganizationDto savedOrganizationDto = AutoOrganizationMapper.MAPPER.mapToOrganizationDto(savedOrganization);

        return savedOrganizationDto;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        // organization JPA instance
        Organization organization= organizationRepository.findByOrganizationCode(organizationCode);

        // convert to organization dto
         return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(organization);


    }

}

