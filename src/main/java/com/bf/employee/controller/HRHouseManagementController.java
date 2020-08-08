package com.bf.employee.controller;

import com.bf.employee.entity.HRFacilityResponse;
import com.bf.employee.entity.HRHouseDetailResponse;
import com.bf.employee.service.serviceImpl.HRHouseManagementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/8
 */

@RestController
//@RequestMapping("hr")
public class HRHouseManagementController {
    @Resource
    private HRHouseManagementService service;

    /**
    * @description: view all houses
    * @param: []
    * @return: java.util.List<com.bf.employee.entity.HRHouseDetailResponse>
    * @date: 2020/8/8
    */
    @RequestMapping("/viewAllHouses")
    List<HRHouseDetailResponse> viewAllHouses() {
        return service.viewAllHouses();
    }

    /**
    * @description: view one specific house by houseID
    * @param: [hid]
    * @return: com.bf.employee.entity.HRFacilityResponse
    * @date: 2020/8/8
    */
    @RequestMapping("/viewHouseDetail")
    HRFacilityResponse viewDetailByHouseId(@RequestParam("hid") Integer hid) {
        return service.viewDetailByHouseId(hid);
    }
}
