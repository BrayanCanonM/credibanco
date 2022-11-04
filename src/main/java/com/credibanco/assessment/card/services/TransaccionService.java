package com.credibanco.assessment.card.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.DAO.TarjetaDAO;
import com.credibanco.assessment.card.DAO.TransaccionDAO;
import com.credibanco.assessment.card.models.Estado;
import com.credibanco.assessment.card.models.EstadoTransaccion;
import com.credibanco.assessment.card.models.TarjetaModel;
import com.credibanco.assessment.card.models.TransaccionModel;

@Service
public class TransaccionService 
{
	@Autowired
	TransaccionDAO transaccionDAO;
	
	@Autowired
	TarjetaDAO tarjetaDAO;
	
	public static final String SUCCESS = "00, Compra Exitosa";
	public static final String FAILED = "01, Tarjeta no existe";
	public static final String NO_EXISTE = "02, Tarjeta no Enrolada";
	
	
	

	public ArrayList<TransaccionModel> getTransaccion()
	{
		return (ArrayList<TransaccionModel>)transaccionDAO.findAll();
	}
	
	public String saveTransaccion(TransaccionModel transaccion) 
	{
		try {
			
		
		ArrayList<TarjetaModel> tarjetas = tarjetaDAO.findByNumeroTarjeta(transaccion.getPan());
		String rta = "";
		
		if(tarjetas!=null) 
		{
			rta = transaccion.getPan();
			TarjetaModel tarjeta = tarjetas.get(0);
			
			if(!tarjeta.getEstado().equals(Estado.ENROLADA.name())) 
			{
				transaccion.setEstadoCompra(EstadoTransaccion.NO_APROBADA.name());
				rta = rta+NO_EXISTE+", "+transaccion.getEstadoCompra()+", "+transaccion.getNumReferencia();
			}else {
				transaccion.setEstadoCompra(EstadoTransaccion.APROBADA.name());
				rta =rta+SUCCESS+", "+transaccion.getEstadoCompra()+", "+transaccion.getNumReferencia();
			}
		}else {
			transaccion.setEstadoCompra(EstadoTransaccion.NO_APROBADA.name());
			rta = rta+FAILED+", "+transaccion.getEstadoCompra()+", "+transaccion.getNumReferencia();
		}
		
		LocalDateTime date = LocalDateTime.now();
		transaccion.setFecha(date);
		
		transaccionDAO.save(transaccion);
		
		return rta;
		}
		catch(Exception ex) {
			return "ERROR: "+ ex ;
		}
	}
	
	
	/**public void anularCompra(TransaccionModel transaccion) 
	{
		transaccionDAO.findById(transaccion.id)
	}**/
}
