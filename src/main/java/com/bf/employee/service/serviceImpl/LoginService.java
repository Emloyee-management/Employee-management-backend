package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.LoginDao;
import com.bf.employee.entity.LoginResponse;
import com.bf.employee.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 */

@Service
public class LoginService {
    /**
    * @description:
    * @param: [username]
    * @return: java.lang.String
    * @date: 2020/8/2
    */


    private LoginDao dao;

    @Resource
    public void setDao(LoginDao dao) {
        this.dao = dao;
    }

    public String findPasswordByUsername(String username) {
        return dao.findPasswordByUsername(username);
    }

    public Object findUserByUsername(String username) {
        return dao.findUserByUsername(username);
    }
}
