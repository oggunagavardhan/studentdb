package Student_Records.Student_Records.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Student_Records.Student_Records.Entity.Student_Entity;
import Student_Records.Student_Records.Services.Student_service;

@RestController
@CrossOrigin("https://studentfe-one.vercel.app/")
@RequestMapping("/student")
public class Student_Controller {

	@Autowired
	Student_service serv;
	
	@PostMapping
	public Student_Entity addStudent(@RequestBody Student_Entity entity) {
		return serv.SaveStudent(entity);
		
	}
	@GetMapping
	public List<Student_Entity> getStudent(){
		return serv.getAllStudent();
		
	}
	@GetMapping("/{id}")
	public Student_Entity getOne(@PathVariable Integer id) {
		return serv.getStudentbyId(id);
		
	}
	@PutMapping("/{id}")
	public Student_Entity update(@PathVariable Integer id,@RequestBody Student_Entity entity) {
		return serv.updateStudent(id, entity);
		
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		serv.deleteStudent(id);
		return "Student deleted";
		
	}
}
