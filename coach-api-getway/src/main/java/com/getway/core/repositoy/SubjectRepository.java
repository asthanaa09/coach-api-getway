package com.getway.core.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getway.core.model.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, Long> {

}
