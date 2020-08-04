package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.VisaStatusDAO;
import com.bf.employee.entity.VisaStatus;
import com.bf.employee.service.VisaStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisaStatusServiceImpl implements VisaStatusService {

    @Resource
    VisaStatusDAO visaStatusDAO;

    @Override
    public VisaStatus getVisaStatus(int employeeVisaStatusId) {
        return visaStatusDAO.getVisaInfo(employeeVisaStatusId);
    }
}
