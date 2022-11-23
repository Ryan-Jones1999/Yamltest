package com.kainos.ea.service;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.model.JobRole;

import java.util.List;

public class EmployeeService {

    public com.kainos.ea.dao.EmployeeDao EmployeeDao;

    public EmployeeService(EmployeeDao dao){
        this.EmployeeDao = dao;
    }

    public List<JobRole> viewJobRoles()   {
        return EmployeeDao.getjobroles();
    }

    public JobRole getSpecificationJob(String name)   {
        return EmployeeDao.getSpec(name);
    }

}