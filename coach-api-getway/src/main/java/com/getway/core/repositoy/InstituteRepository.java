package com.getway.core.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getway.core.model.Institute;

@Repository
public interface InstituteRepository extends MongoRepository<Institute, Long> {

}
