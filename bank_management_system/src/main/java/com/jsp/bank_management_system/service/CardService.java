package com.jsp.bank_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bank_management_system.dao.CardDao;
import com.jsp.bank_management_system.dto.Card;
import com.jsp.bank_management_system.exception.CardIdNotFound;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

@Service
public class CardService {
	@Autowired
	CardDao cardDao;
	@Autowired
	ResponseStructure<Card> responseStructure;
	@Autowired
	ResponseStructureList<Card> responseStructureList;

	public ResponseStructure<Card> saveCard(Card card) {
		responseStructure.setMessage("successfully card inserted");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(cardDao.saveCard(card));
		return responseStructure;
	}

	public ResponseStructure<Card> fetchCardById(int cardId) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("successfully card fetched");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(cardDao.fetchCardById(cardId));
			return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
	}

	public ResponseStructureList<Card> fetchAllCard() {
		responseStructureList.setMessage("successfully card fetched");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(cardDao.fetchAllCard());
		return responseStructureList;
	}

	public ResponseStructure<Card> updateCardById(int oldCardId, Card newCard) {
		Card card = cardDao.fetchCardById(oldCardId);
		if (card != null) {
			responseStructure.setMessage("successfully card updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(cardDao.updateCardById(oldCardId, newCard));
			return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
	}

	public ResponseStructure<Card> deleteCardById(int cardId) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("successfully card deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(cardDao.deleteCardById(cardId));
			return responseStructure;
		} else {
			throw new CardIdNotFound();
		}
	}

}
