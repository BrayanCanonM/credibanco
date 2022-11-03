package com.credibanco.assessment.card.DAO;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.card.models.TransaccionModel;

public interface TransaccionDAO extends CrudRepository<TransaccionModel, Integer>
{

}
