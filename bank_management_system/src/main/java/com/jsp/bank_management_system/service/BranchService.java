package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.AddressDao;
import com.jsp.bank_management_system.dao.BranchDao;
import com.jsp.bank_management_system.dao.CustomerDao;
import com.jsp.bank_management_system.dao.EmployeeDao;
import com.jsp.bank_management_system.dao.ManagerDao;
import com.jsp.bank_management_system.dto.Address;
import com.jsp.bank_management_system.dto.Branch;
import com.jsp.bank_management_system.dto.Customer;
import com.jsp.bank_management_system.dto.Employee;
import com.jsp.bank_management_system.dto.Manager;
import com.jsp.bank_management_system.exception.AddressIdNotFound;
import com.jsp.bank_management_system.exception.BranchIdNotFound;
import com.jsp.bank_management_system.exception.CustomerIdNotFound;
import com.jsp.bank_management_system.exception.EmployeeIdNotFound;
import com.jsp.bank_management_system.exception.ManagerIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setMessage("successfully branch inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully branch fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructureList<Branch> fetchAllBranch() {
		responseStructureList.setMessage("successfully branch fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAllBranch());
		return responseStructureList;
	}

	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setMessage("successfully branch updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully branch deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int branchId, int addressId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch != null && address != null) {
			responseStructure.setMessage("successfully branch ExistingAddressToExistingBranch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
			return responseStructure;
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int branchId, int managerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerbyId(managerId);
		if (branch != null && manager != null) {
			responseStructure.setMessage("successfully branch ExistingManagerToExistingBranch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingManagerToExistingBranch(branchId, managerId));
			return responseStructure;
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (branch != null && employee != null) {
			responseStructure.setMessage("successfully branch ExistingEmployeeToExistingBranch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(employeeId, branchId));
			return responseStructure;
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(int branchId, Employee newEmployee) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully branch NewEmployeeToExistingBranch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(int customerId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(branchId);
		if (branch != null && customer != null) {
			responseStructure.setMessage("successfully branch ExistingCustomerToExistingBranch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(customerId, branchId));
			return responseStructure;
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Branch> addNewCustomerToExistingBranch(int branchId, Customer newCustomer) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully branch NewCustomerToExistingBranch");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, newCustomer));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

}
