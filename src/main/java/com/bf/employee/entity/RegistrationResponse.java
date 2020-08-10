package com.bf.employee.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
public class RegistrationResponse {
    private int userId;
    private int personId;
    private int employeeId;
    private int applicationWorkFlowId;

    @Tolerate
    public RegistrationResponse(){
    }

}
