package Student_Records.Student_Records.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Student_Records.Student_Records.Entity.Student_Entity;

@Repository
public interface Student_Repository extends JpaRepository<Student_Entity, Integer>{

	//Student_Entity save(Student_Entity entity);

	
	
}
