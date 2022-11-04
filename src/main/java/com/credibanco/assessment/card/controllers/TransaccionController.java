package com.credibanco.assessment.card.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.models.TransaccionModel;
import com.credibanco.assessment.card.services.TransaccionService;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
	
	@Autowired
	TransaccionService transaccionService;
	
	
	@GetMapping()
	public ArrayList<TransaccionModel> getTarjetas(){
		return transaccionService.getTransaccion();
	}
	
	@PostMapping()
	public String saveTransaccion(@RequestBody TransaccionModel transaccion) {
		return this.transaccionService.saveTransaccion(transaccion);
	}
}
