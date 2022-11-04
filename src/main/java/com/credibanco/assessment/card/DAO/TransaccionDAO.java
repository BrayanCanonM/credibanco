package com.credibanco.assessment.card.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import com.credibanco.assessment.card.models.TransaccionModel;

@Repository
public interface TransaccionDAO extends CrudRepository<TransaccionModel, Integer>
{

}
