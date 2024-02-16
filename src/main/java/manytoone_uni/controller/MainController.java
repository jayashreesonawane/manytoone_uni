package manytoone_uni.controller;

import manytoone_uni.dao.CollegeDao;
import manytoone_uni.dao.StudentDao;
import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class MainController {
	
	public static void main(String[] args) {
		
		College college = new College();
		college.setId(101);
		college.setName("PECA");
		college.setFees(80000.0);
		
		CollegeDao collegeDao = new CollegeDao();
//		collegeDao.saveCollege(college);
//		collegeDao.fetchCollege(101);
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Jaysh");
		s1.setPhone(8317252991l);
		s1.setAddress("Pune");
		s1.setCollege(college);
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Jayu");
		s2.setPhone(8317252991l);
		s2.setAddress("Pune");
		s2.setCollege(college);
		
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Jayshri");
		s3.setPhone(8317252991l);
		s3.setAddress("Pune");
		s3.setCollege(college);
		
		StudentDao dao = new StudentDao();
		dao.saveStudent(s1, 101);
//		dao.saveStudent(s2, 101);
//		dao.saveStudent(s3, 101);
//		dao.fetchStudent(1);
//		dao.updateStudent(1, s1);
		//dao.deleteStudent(1);
	}
}
