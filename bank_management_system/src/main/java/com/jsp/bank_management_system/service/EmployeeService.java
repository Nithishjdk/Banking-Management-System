package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.EmployeeDao;
import com.jsp.bank_management_system.dto.Employee;
import com.jsp.bank_management_system.exception.EmployeeIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	@Autowired
	ResponseStructureList<Employee> responseStructureList;

	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		responseStructure.setMessage("successfully employee inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return responseStructure;
	}

	public ResponseStructure<Employee> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("successfully employee fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return responseStructure;
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseStructureList<Employee> fetchAllEmployee() {
		responseStructureList.setMessage("successfully employee fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(employeeDao.fetchAllEmployee());
		return responseStructureList;
	}

	public ResponseStructure<Employee> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		Employee employee = employeeDao.fetchEmployeeById(oldEmployeeId);
		if (employee != null) {
			responseStructure.setMessage("successfully employee updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
			return responseStructure;
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseStructure<Employee> deleteEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("successfully employee deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return responseStructure;
		} else {
			throw new EmployeeIdNotFound();
		}
	}
}
