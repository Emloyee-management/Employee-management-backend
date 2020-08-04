package com.bf.employee.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bf.employee.entity.LoginResponse;
import com.bf.employee.entity.User;
import com.bf.employee.security.util.CookieUtil;
import com.bf.employee.security.util.JwtUtil;
import com.bf.employee.service.LoginService;

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
 * @description: Relevant methods for user login
 * @author: Yang Yuan
 */

@RestController
public class LoginController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    @Resource
    private LoginService service;
    @Resource
    private HttpServletRequest request;


    /**
    * @description: If the password in database matches the one in request, then generate a token and return it.
     * Otherwise, return a null user object.
    * @param: []
    * @return: java.util.List<java.lang.Object>
    * @date: 2020/8/3
    */
    @RequestMapping("/login")
    public Object login() {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pwd = service.findPasswordByUsername(username);
        if(password.equals(pwd))
        {
            LoginResponse user = (LoginResponse) service.findUserByUsername(username);
            String token = JwtUtil.generateToken(signingKey, username);
            user.setToken(token);
            return user;
        }
        else {
            return new LoginResponse();
        }
    }

}
