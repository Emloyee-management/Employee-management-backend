package com.bf.employee.dao;

import com.bf.employee.entity.HRHouseDetailResponse;

import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/7
 */
public interface HRHouseManagementDao {
    List<HRHouseDetailResponse> viewAllHouses();
    HRHouseDetailResponse viewOneHouseById();


}
