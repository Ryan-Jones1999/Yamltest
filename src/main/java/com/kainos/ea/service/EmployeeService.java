package com.kainos.ea.service;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.model.jobrole;

import java.util.List;

public class EmployeeService {

    public com.kainos.ea.dao.EmployeeDao EmployeeDao;

    public EmployeeService(EmployeeDao dao){
        this.EmployeeDao = dao;
    }

    public List<jobrole> viewJobRoles()   {
        return EmployeeDao.getjobroles();
    }



}
