package com.bf.employee.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bf.employee.entity.LoginResponse;
import com.bf.employee.entity.User;
import com.bf.employee.security.util.CookieUtil;
import com.bf.employee.security.util.JwtUtil;
import com.bf.employee.service.LoginService;

import com.bf.employee.service.PersonService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: Relevant methods for user Info Page
 * @author: Zishan
 */

@RestController
public class UserInfoController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    @Resource
    private PersonService service;
    @Resource
    private HttpServletRequest request;


    @RequestMapping("/personInfo")
    public Object getUserInfo() {
        Integer personId = Integer.parseInt(request.getParameter("personId"));
        return service.getPersonalInfo(personId);
    }

}
