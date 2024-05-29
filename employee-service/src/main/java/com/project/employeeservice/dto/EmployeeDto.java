package com.project.employeeservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Schema( //// swagger rest api annotation
        description="Employee  model information"
)
public class EmployeeDto

{
    private Long id;

    @Schema( //// swagger rest api annotation
            description=" Employee FirstName"
    )
    private String firstName;

    @Schema( //// swagger rest api annotation
            description="Employee LastName"
    )
    private String lastName;

    @Schema( //// swagger rest api annotation
            description=" Employee  Email"
    )
    private String email;

    @Schema( //// swagger rest api annotation
            description=" Employee  DepartmentCode"
    )
    private String departmentCode;

    @Schema( //// swagger rest api annotation
            description="Employee  organizationCode"
    )
    private String organizationCode;

}
