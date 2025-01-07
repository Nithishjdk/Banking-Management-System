package com.jsp.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank_management_system.dto.Card;
import com.jsp.bank_management_system.service.CardService;
import com.jsp.bank_management_system.util.ResponseStructure;
import com.jsp.bank_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CardController {
	@Autowired
	CardService cardService;

	@Operation(summary = "Save Card", description = "API is used to save the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveCard")
	public ResponseStructure<Card> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}

	@Operation(summary = "Fetches Card", description = "API is used to fetch the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@GetMapping("/fetchCardById")
	public ResponseStructure<Card> fetchCardById(@RequestParam int cardId) {
		return cardService.fetchCardById(cardId);
	}

	@Operation(summary = "Fetches all Card", description = "API is used to fetch the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@GetMapping("/fetchAllCard")
	public ResponseStructureList<Card> fetchAllCard() {
		return cardService.fetchAllCard();
	}

	@Operation(summary = "updates Card", description = "API is used to updates the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@PutMapping("/updateCardById")
	public ResponseStructure<Card> updateCardById(@RequestParam int oldCardId,@RequestBody Card newCard) {
		return cardService.updateCardById(oldCardId, newCard);
	}

	@Operation(summary = "deletes Card", description = "API is used to deletes the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Card not found for the given id") })
	@DeleteMapping("/deleteCardById")
	public ResponseStructure<Card> deleteCardById(@RequestParam int cardId) {
		return cardService.deleteCardById(cardId);
	}

}
