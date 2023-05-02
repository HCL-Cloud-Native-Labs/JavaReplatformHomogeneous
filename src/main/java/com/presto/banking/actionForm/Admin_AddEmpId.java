package com.presto.banking.actionForm;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Admin_AddEmpId implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String bank_emp_id;

    public Admin_AddEmpId() {
    }

    public Admin_AddEmpId(Long id, String bank_emp_id) {
        this.id = id;
        this.bank_emp_id = bank_emp_id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Id
    @Column(name = "bank_emp_id")
    public String getbank_emp_id() {
        return bank_emp_id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setbank_emp_id(String bank_emp_id) {
        this.bank_emp_id = bank_emp_id;
    }
}

