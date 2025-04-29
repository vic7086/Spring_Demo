package com.example.spring_demo_spring_data.service;

import com.example.spring_demo_spring_data.entity.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
    Student findByEmail(String email);
} 