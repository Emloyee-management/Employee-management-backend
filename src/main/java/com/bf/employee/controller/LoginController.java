package com.bf.employee.controller;

import com.bf.employee.entity.LoginResponse;
import com.bf.employee.security.util.JwtUtil;
import com.bf.employee.service.serviceImpl.LoginService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
            System.out.println(user.toString());
            return user;
        }
        else {
            return new LoginResponse();
        }
    }

}
