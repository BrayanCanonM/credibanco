package com.credibanco.assessment.card.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.models.TarjetaModel;
import com.credibanco.assessment.card.services.TarjetaService;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController 
{
	
	@Autowired
	TarjetaService tarjetaService;
	
	@GetMapping()
	public ArrayList<TarjetaModel> getTarjetas(){
		return tarjetaService.getTarjetas();
	}
	
	@PostMapping()
	public TarjetaModel saveTarjeta(@RequestBody TarjetaModel tarjeta) {
		return this.tarjetaService.saveTarjeta(tarjeta);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<TarjetaModel> getTarjetaByID(@PathVariable("id") int id){
		return this.tarjetaService.getTarjetaByID(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteTarjeta(@PathVariable("id") int id) {
		boolean result = this.tarjetaService.deleteTarjeta(id);
		String rta = "";
		if(result) {
			rta = "Se eliminó correctamente la tarjeta " + id;
		}else {
			rta = "No se pudo completar la operación de eliminar la tarjeta "+id;
		}
		
		return rta;
	}
	
}
