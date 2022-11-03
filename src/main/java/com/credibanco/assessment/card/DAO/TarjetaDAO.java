package com.credibanco.assessment.card.DAO;

import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.models.TarjetaModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface TarjetaDAO extends CrudRepository<TarjetaModel, Integer>
{
	public abstract ArrayList<TarjetaModel> findByNumeroTarjeta(String numeroTarjeta);
}
