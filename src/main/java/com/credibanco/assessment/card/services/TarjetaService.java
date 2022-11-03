package com.credibanco.assessment.card.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.DAO.TarjetaDAO;
import com.credibanco.assessment.card.models.Estado;
import com.credibanco.assessment.card.models.TarjetaModel;

@Service
public class TarjetaService {
	@Autowired
	TarjetaDAO tarjetaDAO;
	
	public static final String SUCCESS = "00, Éxito";
	public static final String FAILED = "01, Falló";
	
	public ArrayList<TarjetaModel> getTarjetas()
	{
		return (ArrayList<TarjetaModel>)tarjetaDAO.findAll();
	}
	
	public boolean enrolarTarjeta(int id, String numVal) 
	{
		try {
			Optional<TarjetaModel> encontrada = tarjetaDAO.findById(id);
			
			if(encontrada != null) {
				encontrada.get().setEstado(Estado.ENROLADA.name());
				
				if(encontrada.get().getNumValidacion().equals(numVal)) {
					tarjetaDAO.save(encontrada.get());
				}
				
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String saveTarjeta(TarjetaModel tarjeta)
	{
		int val = (int) (Math.random( ) * 101+1);
		tarjeta.setEstado(Estado.CREADA.name());
		String rta = "";
		
		int longTarjeta = tarjeta.getNumeroTarjeta().length();
		int longCedula = tarjeta.getCedula().length();
		int longTel = tarjeta.getTelefono().length();
		
		if(longTarjeta>=16 && longTarjeta <=19
		&& longCedula>=10 && longCedula <=15 && longTel <=10) 
		{	
			tarjeta.setNumValidacion(val+"");
			tarjetaDAO.save(tarjeta);
			rta = SUCCESS +", "+val;
		}
		else
		{
			rta = FAILED +", "+val;
		}
		rta = rta+darTarjetaEnmascarada(tarjeta.getNumeroTarjeta());
		
		return rta;
	}
	
	public String darTarjetaEnmascarada(String numTarjeta) 
	{
		String rta = "";
		
		for (int i = 0; i < numTarjeta.length(); i++) 
		{
			if(i<6 || i>numTarjeta.length()-5)
			{
				rta = rta+numTarjeta.charAt(i);
			}else {
				rta = rta+"*";
			}
		}
		
		return rta;
	}
	
	public Optional<TarjetaModel> getTarjetaByID(int id){
		return tarjetaDAO.findById(id);
	}
	
	public boolean deleteTarjeta(int id, String numVal) {
		try {
			
			Optional<TarjetaModel> encontrada = tarjetaDAO.findById(id);
			if(encontrada.get().getNumValidacion().equals(numVal)) {
				tarjetaDAO.deleteById(id);
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
