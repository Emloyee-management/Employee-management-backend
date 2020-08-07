package com.bf.employee.constant;


import org.springframework.util.ClassUtils;

public interface Constant {
    String JWT_TOKEN_COOKIE_NAME = "JWT-TOKEN";
    String SIGNING_KEY = "signingKey";
    String CLASS_PATH = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static";
}
