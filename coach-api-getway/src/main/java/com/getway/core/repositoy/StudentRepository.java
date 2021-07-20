package com.getway.core.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getway.core.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

}
