package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.dao.ApplicationWorkFlowDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.ApplicationWorkFlow;
import com.bf.employee.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationWorkFlowHibernateDAOImpl extends AbstractHibernateDAO implements ApplicationWorkFlowDAO {

    public ApplicationWorkFlowHibernateDAOImpl() {
        setClazz(ApplicationWorkFlow.class);
    }
    /*
     * Override method from ApplicationWorkFlowDAO.
     * Register ApplicationWorkFlow to the DB
     */
    @Override
    public int registerApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow) {
        getCurrentSession().persist(applicationWorkFlow);
        return applicationWorkFlow.getId();
    }
}
