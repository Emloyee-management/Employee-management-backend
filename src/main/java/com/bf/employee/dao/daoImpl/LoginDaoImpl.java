package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.LoginDao;
import com.bf.employee.entity.LoginResponse;
import com.bf.employee.entity.User;
import com.bf.employee.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 */

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {
    @Resource
    private SessionFactory sf;

    @Override
    public String findPasswordByUsername(String username) {
        Session session = sf.getCurrentSession();
        String hql = "select u.password from User u where u.userName = :name";
        Query query = session.createQuery(hql, String.class)
                .setParameter("name", username);
        if(query.getResultList().size() == 0)
            return null;
        List<String> res = new ArrayList<>();
        for(Object i : query.getResultList())
            res.add((String)i);
        return res.get(0);
    }

    @Override
    public Object findUserByUsername(String username) {
        Session session = sf.getCurrentSession();
        String hql = "select u, ur.roleId from User u, UserRole ur " +
                "where u.personId = ur.userId " +
                "and u.userName = :name";
        List<Object> list = session.createQuery(hql)
                .setParameter("name", username)
                .list();
        Object[] obj = (Object[])list.get(0);
//        System.out.println(obj[0]+","+obj[1]);
        LoginResponse temp = new LoginResponse();
        User user = (User)obj[0];
        Integer roleId = (Integer) obj[1];
        temp.setId(user.getId());
        temp.setEmail(user.getEmail());
        temp.setCreateDate(user.getCreateDate());
        temp.setModificationDate(user.getModificationDate());
        temp.setPassword(user.getPassword());
        temp.setRoleId(roleId);
        temp.setPersonId(user.getPersonId());
        return temp;
    }
}
