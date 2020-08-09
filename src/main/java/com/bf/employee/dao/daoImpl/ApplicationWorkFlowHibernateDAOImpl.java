package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.dao.ApplicationWorkFlowDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.ApplicationWorkFlow;
import com.bf.employee.entity.Employee;
import javafx.application.Application;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    @Override
    public void updateStatus(String type, int employeeId, String changedStatus, String now) {
        String q = "UPDATE ApplicationWorkFlow wf " +
                "SET wf.status = :changedStatus, wf.modificationDate = :now where wf.employeeId= :employeeId and wf.type = :type";
        Query query = getCurrentSession().createQuery(q);
        query.setParameter("changedStatus", changedStatus);
        query.setParameter("employeeId", employeeId);
        query.setParameter("type", type);
        query.setParameter("now", now);

        int count = query.executeUpdate();
        System.out.println(count + " Record(s) Updated.");
    }
}
