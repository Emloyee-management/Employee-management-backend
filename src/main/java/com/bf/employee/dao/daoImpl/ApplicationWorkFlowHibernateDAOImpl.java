package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.dao.ApplicationWorkFlowDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.ApplicationWorkFlow;
import com.bf.employee.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ApplicationWorkFlowHibernateDAOImpl extends AbstractHibernateDAO implements ApplicationWorkFlowDAO {

    public ApplicationWorkFlowHibernateDAOImpl() {
        setClazz(ApplicationWorkFlow.class);
    }
    /*
     * Override method from ApplicationWorkFlowDAO.
     * Register ApplicationWorkFlow to the DB
     */
    @Resource
    private SessionFactory sf;
    @Override
    public int registerApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow) {
        try {
            getCurrentSession().persist(applicationWorkFlow);
        }
        catch (HibernateException e) {
            sf.openSession().persist(applicationWorkFlow);
        }
        return applicationWorkFlow.getId();
    }
}
