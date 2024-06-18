package com.example.springbootut.springbootut.service;

import com.example.springbootut.springbootut.entity.Department;
import com.example.springbootut.springbootut.error.DeptNotFoundException;

import java.util.List;

public interface DeptService {
    Department save(Department department);
    List<Department> getAll();

    Department findById(Long id) throws DeptNotFoundException;
    boolean delById(Long id);
    Department updateById(Long id, Department department);
    Department getByName(String name);
}
