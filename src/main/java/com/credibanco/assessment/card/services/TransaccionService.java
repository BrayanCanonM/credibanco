package com.credibanco.assessment.card.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.DAO.TarjetaDAO;
import com.credibanco.assessment.card.DAO.TransaccionDAO;
import com.credibanco.assessment.card.models.TarjetaModel;
import com.credibanco.assessment.card.models.TransaccionModel;

@Service
public class TransaccionService 
{
	@Autowired
	TransaccionDAO transaccionDAO;
	
	@Autowired
	TarjetaDAO tarjetaDAO;
	
	
	public void crearTransaccion(TransaccionModel transaccion) 
	{
		ArrayList<TarjetaModel> tarjetas = tarjetaDAO.findByNumeroTarjeta(transaccion.getPAN());
		
		if(tarjetas!=null) 
		{
			TarjetaModel tarjeta = tarjetas.get(0);
		}
	}
}
