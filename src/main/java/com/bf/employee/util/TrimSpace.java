package com.bf.employee.util;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/4
 */
public class TrimSpace {
    public String Trim(String s) {
        String res = new String();
        res = s.replace("%20", " ");
        return res;
    }
}
