package manytoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.College;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	 public void saveCollege(College college) {
	        entityTransaction.begin();
	        entityManager.persist(college);
	        entityTransaction.commit();
	    }

	    public void fetchCollege(int id) {
	        College college = entityManager.find(College.class, id);
	        if (college != null) {
	            System.out.println(college);
	        } else {
	            System.out.println("College with given id is not found");
	        }
	    }

	    public void updateCollege(int id, College updatedCollege) {
	        College dbCollege = entityManager.find(College.class, id);
	        if (dbCollege != null) {
	            // Update properties of dbCollege with updatedCollege
	            dbCollege.setName(updatedCollege.getName());
	            dbCollege.setFees(dbCollege.getFees());
	            // Update more properties if needed

	            entityTransaction.begin();
	            entityManager.merge(dbCollege);
	            entityTransaction.commit();
	        } else {
	            System.out.println("College with given id " + id + " is not found");
	        }
	    }
	}