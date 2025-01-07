package com.jsp.bank_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bank_management_system.dto.Card;
import com.jsp.bank_management_system.repo.CardRepo;

@Repository
public class CardDao {
	@Autowired
	CardRepo cardRepo;

	public Card saveCard(Card card) {
		return cardRepo.save(card);
	}

	public Card fetchCardById(int cardId) {
		Optional<Card> optional = cardRepo.findById(cardId);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public List<Card> fetchAllCard() {
		return cardRepo.findAll();
	}

	public Card updateCardById(int oldCardId, Card newCard) {
		Optional<Card> optional = cardRepo.findById(oldCardId);
		if (optional.isPresent()) {
			newCard.setCardId(oldCardId);
			Card card = cardRepo.save(newCard);
			return card;
		}
		return null;
	}

	public Card deleteCardById(int cardId) {
		Optional<Card> optional = cardRepo.findById(cardId);
		if (optional.isPresent()) {
			Card card = fetchCardById(cardId);
			cardRepo.delete(card);
			return card;
		}
		return null;
	}

}
