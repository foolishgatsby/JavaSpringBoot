package com.learningcode.cruddemo.dao;

import com.learningcode.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method (for Create Object)
    @Override
    @Transactional
    public void save(Student theStudent) {
        // save the student to database
        entityManager.persist(theStudent);
    }

    // implement findById method (for Read Object)
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // implement findAll method (query Object)
    @Override
    public List<Student> findAll() {

        // create query
        // remember query String is field of JPA entity (lastName: attribute of Student class)
        // order by lastName to sort ascending by the Last Name (A-Z)
        // dsc is to sort descending
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData",
                Student.class);

        // set query parameters
        theQuery.setParameter("theData", lastName);

        // return query results
        return theQuery.getResultList();
    }

    // implement update method (update Object)
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    // implement delete method (delete Object)
    @Override
    @Transactional
    public boolean delete(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        if(theStudent != null) {
            entityManager.remove(theStudent);
            return true;
        }
        return false;
    }

    // delete all student
    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
