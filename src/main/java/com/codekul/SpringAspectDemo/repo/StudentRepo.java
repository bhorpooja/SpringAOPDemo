package com.codekul.SpringAspectDemo.repo;

import com.codekul.SpringAspectDemo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pooja on 12/12/17.
 */
public interface StudentRepo extends MongoRepository<Student,String> {

    Student findByName(String name);

}
