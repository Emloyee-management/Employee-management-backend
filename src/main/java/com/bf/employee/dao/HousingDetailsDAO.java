package com.bf.employee.dao;

import com.bf.employee.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HousingDetailsDAO {
    House findHouseIDFromPersonID(int personID);
    HouseEmployeeResponse getEmployeeByHouseID(House h);
    House getHouseById(Integer id);
    FacilityReportResponse getFacilityReportDetail(House h);
}
