package Student_Records.Student_Records.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Student_Records.Student_Records.Entity.Student_Entity;
import Student_Records.Student_Records.Repository.Student_Repository;

@Service
public class Student_service {

	@Autowired
	Student_Repository repo;
	
	public Student_Entity SaveStudent(Student_Entity entity) {
		return repo.save(entity);
		
	}
	public List<Student_Entity> getAllStudent(){
		return repo.findAll();
		
	}
	public Student_Entity getStudentbyId(Integer id) {
		return repo.findById(id).orElse(null);
				
	}
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}
	public Student_Entity updateStudent(Integer Id,Student_Entity newData) {
		Student_Entity old=repo.findById(Id).orElse(null);
		if(old!=null) {
			old.setName(newData.getName());
			old.setEmail(newData.getEmail());
			old.setBranch(newData.getBranch());
			return repo.save(old);
		}
		return null;
		
	}
}
