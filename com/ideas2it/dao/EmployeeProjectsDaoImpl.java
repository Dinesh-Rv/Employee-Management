package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeProjects;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;


public class EmployeeProjectsDaoImpl implements EmployeeProjectsDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public boolean addEmployeeProject(EmployeeProjects record, Employee employee) {
        List<Employee> employees = new ArrayList<Employee>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            employees.add(employee);
            record.setEmployee(employees);
            System.out.println(session.save(record));
            transact.commit();
            return true;
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<EmployeeProjects> getEmployeeProject(String employeeId) {
        List<EmployeeProjects> employeeProject = new ArrayList<EmployeeProjects>();
        Session session = null;
        int recordNumber = 0;
        try {
            session = sessionFactory.openSession();
            Transaction transact = session.beginTransaction();
            Query query = session.createQuery("SELECT EmployeeProjects.projectId, EmployeeProjects.projectName, EmployeeProjects.projectManager, EmployeeProjects.clientName, Employee.employeeId, Employee.employeeName, Employee.employeeRole " +
                    "                   FROM EmployeeProjects" +
                    " LEFT JOIN employee_projects" +
                    "                   ON EmployeeProjects.projectId = employee_projects.project_id" +
                    "                       AND employee_projects.employee_id = :employeeId" +
                    "         LEFT JOIN Employee" +
                    "                   ON employee_projects.employee_id = Employee.employeeId");
            query.setParameter("employeeId", employeeId);
            employeeProject = query.list();
            transact.commit();
        } catch (HibernateException h) {
            System.out.println(h);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return employeeProject;
    }

    @Override
    public boolean updateEmployeeProjects(EmployeeProjects projects) {

        return true;
    }
}
