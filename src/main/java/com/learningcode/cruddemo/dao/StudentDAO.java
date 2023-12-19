/**
 * Student Database Access Object
 */

package com.learningcode.cruddemo.dao;

import com.learningcode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    // Update Object method
    void update(Student theStudent);

    boolean delete(Integer id);

    int deleteAll();
}
