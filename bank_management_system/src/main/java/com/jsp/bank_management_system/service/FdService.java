package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.FdDao;
import com.jsp.bank_management_system.dto.Fd;
import com.jsp.bank_management_system.exception.FdIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class FdService {
	@Autowired
	FdDao fdDao;
	@Autowired
	ResponseStructure<Fd> responseStructure;
	@Autowired
	ResponseStructureList<Fd> responseStructureList;

	public ResponseStructure<Fd> saveFd(Fd fd) {
		responseStructure.setMessage("successfully Fd inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(fdDao.saveFd(fd));
		return responseStructure;
	}

	public ResponseStructure<Fd> fetchFdById(int fdId) {
		Fd fd = fdDao.fetchFdById(fdId);
		if (fd != null) {
			responseStructure.setMessage("successfully Fd fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(fdDao.fetchFdById(fdId));
			return responseStructure;
		} else {
			throw new FdIdNotFound();
		}
	}

	public ResponseStructureList<Fd> fetchAllFd() {
		responseStructureList.setMessage("successfully Fd fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(fdDao.fetchAllFd());
		return responseStructureList;
	}

	public ResponseStructure<Fd> updateFdById(int oldFdId, Fd newFd) {
		Fd fd = fdDao.fetchFdById(oldFdId);
		if (fd != null) {
			responseStructure.setMessage("successfully Fd updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(fdDao.updateFdById(oldFdId, newFd));
			return responseStructure;
		} else {
			throw new FdIdNotFound();
		}
	}

	public ResponseStructure<Fd> deleteFdById(int fdId) {
		Fd fd = fdDao.fetchFdById(fdId);
		if (fd != null) {
			responseStructure.setMessage("successfully Fd deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(fdDao.deleteFdById(fdId));
			return responseStructure;
		} else {
			throw new FdIdNotFound();
		}
	}

}
