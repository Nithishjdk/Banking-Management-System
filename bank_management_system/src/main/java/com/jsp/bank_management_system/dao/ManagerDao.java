package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Manager;
import com.jsp.bank_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerbyId(int managerId) {
		Optional<Manager> manager = managerRepo.findById(managerId);
		if (manager.isEmpty()) {
			return null;
		}
		return manager.get();
	}

	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}

	public Manager updateManagerbyId(int oldManagerId, Manager newManager) {
		Optional<Manager> optional = managerRepo.findById(oldManagerId);
		if (optional.isPresent()) {
			newManager.setManagerId(oldManagerId);
			Manager manager = saveManager(newManager);
			return manager;
		}
		return null;
	}

	public Manager deleteManagerById(int managerId) {
		Optional<Manager> optional = managerRepo.findById(managerId);
		if (optional.isPresent()) {
			Manager manager = fetchManagerbyId(managerId);
			managerRepo.delete(manager);
			return manager;
		}
		return null;
	}
}
