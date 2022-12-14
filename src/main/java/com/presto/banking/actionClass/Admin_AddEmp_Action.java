package com.presto.banking.actionClass;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.presto.banking.actionForm.Admin_AddEmp;
import com.presto.banking.actionForm.Emp_Login;
import com.presto.banking.daoImpl.Admin_AddEmp_DaoImpl;

/**
 * @author VS60001724
 * 
 */


public class Admin_AddEmp_Action extends ActionSupport implements ModelDriven<Object> {

	private static final long serialVersionUID = -3593298137246621798L;
	public Emp_Login adds;
	public Admin_AddEmp add = new Admin_AddEmp() ;
	public Admin_AddEmp_DaoImpl xyz = new Admin_AddEmp_DaoImpl();

	/**
	 * @return Admin add Employee
	 */
	public String addEmp() {

		xyz.addEmp(add);
		return SUCCESS;
	}

	/**
	 * @return Admin add empolyee
	 */
	public String addEmps() {

		xyz.addEmps(adds);
		addActionMessage("Done");
		return SUCCESS;
	}

	public Emp_Login getAdds() {
		return adds;
	}

	public void setAdds(Emp_Login adds) {
		this.adds = adds;
	}

	public Admin_AddEmp getAdd() {
		return add;
	}

	public void setAdd(Admin_AddEmp add) {
		this.add = add;
	}

	public Admin_AddEmp_DaoImpl getXyz() {
		return xyz;
	}

	public void setXyz(Admin_AddEmp_DaoImpl xyz) {
		this.xyz = xyz;
	}

	public Object getModel() {
			return add;
	}

}
