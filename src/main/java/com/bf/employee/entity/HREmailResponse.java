package com.bf.employee.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HREmailResponse {
    String recipientEmail;
    String msg;

}
