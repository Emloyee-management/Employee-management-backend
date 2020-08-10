package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.VisaStatusDAO;
import com.bf.employee.entity.VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VisaStatusService {
    @Autowired
    private VisaStatusDAO visaStatusDAO;

    @Transactional
    public void registerVisaStatus(VisaStatus visaStatus) {
        visaStatusDAO.registerVisaStatus(visaStatus);
    }

    public int isVisaStatusActive(String visaEndDate) throws ParseException {
        String pattern = "MM/dd/yyyy";
        if (new SimpleDateFormat(pattern).parse(visaEndDate).before(new Date())) {
            return 0; //visa is not active
        } else {
            return 1; // visa is active
        }
    }

    public int findIDByUserName(String userName) {
        int id = visaStatusDAO.findByUserName(userName);
        return id;

    }

    public VisaStatus getVisaStatus(int employeeVisaStatusId) {
        return visaStatusDAO.getVisaInfo(employeeVisaStatusId);
    }

    public Boolean updateVisaType(int employeeVisaStatusId, String visaType) {
        return visaStatusDAO.updateVisaType(employeeVisaStatusId, visaType);
    }

    public List<VisaStatus> getAllVisa()
    {
        return visaStatusDAO.getAll();
    }
}
