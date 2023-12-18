/**
 * Student Database Access Object
 */

package com.learningcode.cruddemo.dao;

import com.learningcode.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
