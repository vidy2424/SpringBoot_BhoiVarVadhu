package com.springboot.bhoivarvadhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bhoivarvadhu.dao.SignupDAO;
import com.springboot.bhoivarvadhu.dto.Info;
import com.springboot.bhoivarvadhu.repository.JwtTokenRepository;
 
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class StudentController {

  
	@Autowired
	private SignupDAO signupDAO;

	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	
	
	//@CrossOrigin(origins = "http://localhost:4200")
 
 
//	@PostMapping(value = "/info")
//	public List<Info> register(@RequestBody Info info) {
//		// System.out.println(user);
//
//		signupDAO.add(info);
//		// System.out.println(info.getPlanName().toString());
//		// System.out.println(info.getInfo().toString());
//
//		signupDAO.get(info.getPlanName());
//		// System.out.println(info.getPlanName().toString());
//		List<Info> sign2 = signupDAO.getAllInfo();
//		// List<SignUpUser> sign15 = signupDAO.loginbyName(signUpUser.getName());
//
//		// List<User> sign1 = new ArrayList<>();
//
//		System.out.println(sign2.toString());
//		return sign2;
//	}
 
	@PostMapping(value = "/info")
	public List<Info> addproduct(@RequestBody Info info) {
		// System.out.println(user);

		signupDAO.add(info);
		// System.out.println(info.getPlanName().toString());
		// System.out.println(info.getInfo().toString());

		// productDAO.get(ourProducts.getProduct_name());
		// System.out.println(info.getPlanName().toString());
		List<Info> sign2 = signupDAO.getAllInfo();
		// List<SignUpUser> sign15 = signupDAO.loginbyName(signUpUser.getName());

		// List<User> sign1 = new ArrayList<>();

		System.out.println(sign2.toString());
		return sign2;
	}
	
	
	
	@RequestMapping(value = "/plan/info")
	public List<Info> getAllInfo() {
  
		List<Info> planinfo = signupDAO.getAllInfo();
		// System.out.println(planinfo.toString());
		System.out.println("this is getmapping");
		return planinfo;
	}

	@RequestMapping(value = "/infos/{id}")
	String showSingleProduct(@RequestBody Info info, @PathVariable int id) {

		System.out.println("this is id");
		// Info info = signupDAO.get(id);
		// System.out.println(info.getId());
		// signupDAO.update(info);

		return "";

	}

	@PutMapping("/infos/{id}")
	public String updateStudent(@RequestBody Info info, @PathVariable int id) {

		//List<Info> information = signupDAO.getbyID(id);

		System.out.println("this is editid");

		info.setId(id);

		signupDAO.update(info);

		 
		return "info";
	}
	
	
	
	
	
	@RequestMapping(value = "/infoDelete/{id}")
	public void deleteStudent(@PathVariable int id) {
		System.out.println("this is deleteid");
		 	signupDAO.delete(id);	 
	}

	/*@DeleteMapping("/infoDelete/{id}")  
	private void deleteBook(@PathVariable int id)   
	{  
		System.out.println("this is deleteid");
		signupDAO.delete(id);  
	}*/
	
	/*
	 * @PostMapping public ResponseEntity<Response> save(@RequestBody Student
	 * student) {//
	 * 
	 * System.out.println("123"); System.out.println("d" + student); return
	 * ResponseEntity.status(HttpSqtatus.OK).body(new
	 * Response(studentService.save(student), new Date())); }
	 * 
	 * @PutMapping public ResponseEntity<Response> update(@RequestBody Student
	 * student) { return ResponseEntity.status(HttpStatus.OK).body(new
	 * Response(studentService.save(student), new Date())); }
	 * 
	 * @DeleteMapping public ResponseEntity<Response> delete(@RequestParam("id") int
	 * id) { studentService.delete(id); return
	 * ResponseEntity.status(HttpStatus.OK).body(new Response(true, new Date())); }
	 */
}
