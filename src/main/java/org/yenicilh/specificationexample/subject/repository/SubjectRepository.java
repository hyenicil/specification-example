package org.yenicilh.specificationexample.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yenicilh.specificationexample.subject.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
