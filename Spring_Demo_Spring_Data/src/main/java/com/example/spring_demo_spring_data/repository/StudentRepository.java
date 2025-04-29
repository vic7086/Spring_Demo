package com.example.spring_demo_spring_data.repository;

import com.example.spring_demo_spring_data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // 可以添加自定义查询方法
    Student findByEmail(String email);
} 