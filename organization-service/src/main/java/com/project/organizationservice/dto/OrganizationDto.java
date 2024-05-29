package com.project.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema( //// swagger rest api annotation
        description="Organization  model information"
)
public class OrganizationDto {

    private Long id;

    @Schema( //// swagger rest api annotation
            description="OrganizationName"
    )
    private String organizationName;

    @Schema( //// swagger rest api annotation
            description="organizationDescription"
    )
    private String organizationDescription;

    @Schema( //// swagger rest api annotation
            description="OrganizationCode"
    )
    private String organizationCode;

    @Schema( //// swagger rest api annotation
            description="createdDate"
    )
    private LocalDateTime createdDate; // hibernate will automatically add value to this


}
