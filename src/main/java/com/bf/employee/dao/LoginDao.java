package com.bf.employee.dao;

import com.bf.employee.entity.LoginResponse;
import com.bf.employee.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: DAO layer for user login to the system by roles
 * @author: Yang Yuan
 */

public interface LoginDao {
    /**
    * @description: Retrieve user's password by username
    * @param: [username]
    * @return: java.lang.String
    * @date: 2020/8/2
    */
    String findPasswordByUsername(String username);

    /**
    * @description: Retrieve user's info by username
    * @param: [username]
    * @return: com.bf.employee.entity.User
    * @date: 2020/8/3
    */
    Object findUserByUsername(String username);

}
