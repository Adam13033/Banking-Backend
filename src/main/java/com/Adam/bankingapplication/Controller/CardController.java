package com.Adam.bankingapplication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

	@GetMapping("/myCards")
	public String getMyCards() {
		return "You have no cards!";
	}
}
