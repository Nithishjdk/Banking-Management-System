package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Address;
import com.jsp.bank_management_system.dto.Branch;
import com.jsp.bank_management_system.dto.Customer;
import com.jsp.bank_management_system.dto.Employee;
import com.jsp.bank_management_system.dto.Manager;
import com.jsp.bank_management_system.repo.BranchRepo;
import com.jsp.bank_management_system.repo.CustomerRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isEmpty()) {
			return null;
		}
		return branch.get();
	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		Optional<Branch> optional = branchRepo.findById(oldBranchId);
		if (optional.isPresent()) {
			newBranch.setBranchId(oldBranchId);
			Branch branch = branchRepo.save(newBranch);
			return branch;
		}
		return null;
	}

	public Branch deleteBranchById(int branchId) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		if (optional.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			branchRepo.delete(branch);
			return branch;
		}
		return null;
	}

	public Branch addExistingAddressToExistingBranch(int branchId, int addressId) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		if (optional.isEmpty()) {
			Branch branch = fetchBranchById(branchId);
			Address address = addressDao.fetchAddressById(addressId);
			branch.setAddress(address);
			return saveBranch(branch);
		}
		return null;
	}

	public Branch addExistingManagerToExistingBranch(int branchId, int managerId) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		if (optional.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			Manager manager = managerDao.fetchManagerbyId(managerId);
			branch.setManager(manager);
			return saveBranch(branch);
		}
		return null;
	}

	public Branch addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		if (optional.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			Employee employee = employeeDao.fetchEmployeeById(employeeId);
			List<Employee> list = branch.getEmployees();
			list.add(employee);
			return saveBranch(branch);
		}
		return null;
	}

	public Branch addNewEmployeeToExistingBranch(int branchId, Employee newEmployee) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		if (optional.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			List<Employee> list = branch.getEmployees();
			list.add(newEmployee);
			return saveBranch(branch);
		}
		return null;
	}

	public Branch addExistingCustomerToExistingBranch(int customerId, int branchId) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		Optional<Customer> optional1 = customerRepo.findById(customerId);
		if (optional.isPresent() && optional1.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			Customer customer = customerDao.fetchCustomerById(customerId);
			List<Customer> list = branch.getCustomers();
			list.add(customer);
			return saveBranch(branch);
		}
		return null;
	}

	public Branch addNewCustomerToExistingBranch(int branchId, Customer newCustomer) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		if (optional.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			List<Customer> list = branch.getCustomers();
			list.add(newCustomer);
			return saveBranch(branch);
		}
		return null;
	}
}
