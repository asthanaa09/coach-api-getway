package com.getway.core.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getway.core.model.Institution;

@Repository
public interface InstitutionRepository extends MongoRepository<Institution, Long> {

}
