package com.project.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema( //// swagger rest api annotation
        description="Department  model information"
)
@Setter
@Getter
@NoArgsConstructor

@AllArgsConstructor

public class DepartmentDto {
    

    private Long id;
// to describe each field

    @Schema( //// swagger rest api annotation
            description="Department  Name"
    )
    private String departmentName;

    @Schema( //// swagger rest api annotation
            description="Department  Description"
    )
    private String departmentDescription;


    @Schema( //// swagger rest api annotation
            description="Department  code"
    )
    private String departmentCode;


}
