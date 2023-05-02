package com.presto.banking.dao;


import com.presto.banking.actionForm.Emp_AddTrans;
import java.util.List;


public interface ContactDao {
    public Emp_AddTrans add(Emp_AddTrans contact);

    public Emp_AddTrans delete(Long id);

    public List<Emp_AddTrans> list();
}

