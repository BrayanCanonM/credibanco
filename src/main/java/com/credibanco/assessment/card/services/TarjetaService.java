package com.credibanco.assessment.card.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.DAO.TarjetaDAO;
import com.credibanco.assessment.card.models.TarjetaModel;

@Service
public class TarjetaService {
	@Autowired
	TarjetaDAO tarjetaDAO;
	
	
	public ArrayList<TarjetaModel> getTarjetas()
	{
		return (ArrayList<TarjetaModel>)tarjetaDAO.findAll();
	}
	
	public TarjetaModel saveTarjeta(TarjetaModel tarjeta)
	{
		return tarjetaDAO.save(tarjeta);
	}
	
	public Optional<TarjetaModel> getTarjetaByID(int id){
		return tarjetaDAO.findById(id);
	}
	
	public boolean deleteTarjeta(int id) {
		try {
			tarjetaDAO.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
