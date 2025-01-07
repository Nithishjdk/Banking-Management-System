package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.ManagerDao;
import com.jsp.bank_management_system.dto.Manager;
import com.jsp.bank_management_system.exception.ManagerIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;

	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setMessage("successfully Manager inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}

	public ResponseStructure<Manager> fetchManagerbyId(int managerId) {
		Manager manager = managerDao.fetchManagerbyId(managerId);
		if (manager != null) {
			responseStructure.setMessage("successfully Manager fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(managerDao.fetchManagerbyId(managerId));
			return responseStructure;
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseStructureList<Manager> fetchAllManager() {
		responseStructureList.setMessage("successfully Manager fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(managerDao.fetchAllManager());
		return responseStructureList;
	}

	public ResponseStructure<Manager> updateManagerbyId(int oldManagerId, Manager newManager) {
		Manager manager = managerDao.fetchManagerbyId(oldManagerId);
		if (manager != null) {
			responseStructure.setMessage("successfully Manager updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(managerDao.updateManagerbyId(oldManagerId, newManager));
			return responseStructure;
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseStructure<Manager> deleteManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerbyId(managerId);
		if (manager != null) {
			responseStructure.setMessage("successfully Manager deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(managerDao.deleteManagerById(managerId));
			return responseStructure;
		} else {
			throw new ManagerIdNotFound();
		}
	}
}
