package manytoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class StudentDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveStudent(Student student, int cid) {
        College college = entityManager.find(College.class, cid);
        if (college != null) {
            student.setCollege(college);
            entityTransaction.begin();
            entityManager.persist(student);
            entityTransaction.commit();
        } else {
            System.out.println("College with given id is not found");
        }
    }

    public void fetchStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student with given id is not found");
        }
    }

    public void findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        System.out.println(query.getResultList());
    }

    public void updateStudent(int id, Student updatedStudent) {
        Student dbStudent = entityManager.find(Student.class, id);
        if (dbStudent != null) {
            entityTransaction.begin();
            // Update properties of dbStudent with updatedStudent
            dbStudent.setName(updatedStudent.getName());
            dbStudent.setPhone(updatedStudent.getPhone());
            dbStudent.setAddress(updatedStudent.getAddress());
            // Update more properties if needed
            entityTransaction.commit();
        } else {
            System.out.println("Student with given id is not found");
        }
    }

    public void deleteStudent(int id) {
        Student dbStudent = entityManager.find(Student.class, id);
        if (dbStudent != null) {
            entityTransaction.begin();
            entityManager.remove(dbStudent);
            entityTransaction.commit();
        } else {
            System.out.println("Student with given id is not found");
        }
    }
}