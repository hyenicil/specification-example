package project.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subject.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
