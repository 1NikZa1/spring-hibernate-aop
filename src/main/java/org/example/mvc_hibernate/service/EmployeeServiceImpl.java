package org.example.mvc_hibernate.service;

import org.example.mvc_hibernate.dao.BaseDAO;
import org.example.mvc_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements BaseService<Employee> {

    @Autowired
    private BaseDAO<Employee> baseDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return baseDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        baseDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return baseDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        baseDAO.deleteEmployee(id);
    }
}
