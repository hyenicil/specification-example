package org.yenicilh.specificationexample.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.yenicilh.specificationexample.student.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

    Student findByName(String name);

    List<Student> findBySubjectsName(String name);

}
