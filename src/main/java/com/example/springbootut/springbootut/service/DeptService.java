package com.example.springbootut.springbootut.service;

import com.example.springbootut.springbootut.entity.Department;

import java.util.List;

public interface DeptService {
    Department save(Department department);
    List<Department> getAll();

    Department findById(Long id);
    boolean delById(Long id);
    Department updateById(Long id, Department department);
    Department getByName(String name);
}
