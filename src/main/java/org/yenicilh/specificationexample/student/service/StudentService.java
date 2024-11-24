package org.yenicilh.specificationexample.student.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.yenicilh.specificationexample.student.entity.Student;
import org.yenicilh.specificationexample.student.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getNameForStudent(String name) {
       return studentRepository.findByName(name);
    }

    public List<Student> getNameForSubject(String name) {
        return studentRepository.findBySubjectsName(name);
    }

    public List<Student> findAll(Specification specification) {
        return studentRepository.findAll(specification);
    }
}
