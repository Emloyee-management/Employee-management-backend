package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.HRHouseManagementDao;
import com.bf.employee.entity.HRFacilityResponse;
import com.bf.employee.entity.HRHouseDetailResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/8
 */

@Service
public class HRHouseManagementService {
    @Resource
    private HRHouseManagementDao dao;

    /**
    * @description: List all houses
    * @param: []
    * @return: java.util.List<com.bf.employee.entity.HRHouseDetailResponse>
    * @date: 2020/8/8
    */
    public List<HRHouseDetailResponse> viewAllHouses() {
        return dao.viewAllHouses();
    }

    /**
    * @description: List the specific house's detail by houseID
    * @param: [hid]
    * @return: com.bf.employee.entity.HRFacilityResponse
    * @date: 2020/8/8
    */
    public HRFacilityResponse viewDetailByHouseId(Integer hid) {
        return dao.viewOneHouseById(hid);
    }
}
