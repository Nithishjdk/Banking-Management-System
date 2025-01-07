package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Fd;
import com.jsp.bank_management_system.repo.FdRepo;

@Repository
public class FdDao {
	@Autowired
	FdRepo fdRepo;

	public Fd saveFd(Fd fd) {
		return fdRepo.save(fd);
	}

	public Fd fetchFdById(int fdId) {
		Optional<Fd> fd = fdRepo.findById(fdId);
		if (fd.isEmpty()) {
			return null;
		}
		return fd.get();
	}

	public List<Fd> fetchAllFd() {
		return fdRepo.findAll();
	}

	public Fd updateFdById(int oldFdId, Fd newFd) {
		Optional<Fd> optional = fdRepo.findById(oldFdId);
		if (optional.isPresent()) {
			newFd.setFdId(oldFdId);
			Fd fd = fdRepo.save(newFd);
			return fd;
		}
		return null;
	}

	public Fd deleteFdById(int fdId) {
		Optional<Fd> optional = fdRepo.findById(fdId);
		if (optional.isPresent()) {
			Fd fd = fetchFdById(fdId);
			fdRepo.delete(fd);
			return fd;
		}
		return null;
	}
}
