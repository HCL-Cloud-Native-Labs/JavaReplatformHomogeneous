package com.presto.banking.dao;
import java.util.List;

import com.presto.banking.actionForm.Emp_AddTrans;
public interface ContactDao {
    public Emp_AddTrans add(Emp_AddTrans contact);

    public Emp_AddTrans delete(Long id);

    public List<Emp_AddTrans> list();
}