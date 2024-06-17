package com.example.springbootut.springbootut.service;

import com.example.springbootut.springbootut.entity.Department;
import com.example.springbootut.springbootut.repo.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptRepo deptRepo;
    @Override
    public Department save(Department department) {

        return deptRepo.save(department);
    }
    @Override
    public List<Department> getAll() {
        return deptRepo.findAll();
    }

    @Override
    public Department findById(Long id) {
        return deptRepo.findById(id).get();
    }

    @Override
    public boolean delById(Long id) {
        try {
            deptRepo.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("error:"+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Department updateById(Long id, Department updatedDepartment) {
        try {
            Department department = deptRepo.findById(id).get();
            if (department == null) {
                return null;
            }
            if (updatedDepartment.getName() != null && !updatedDepartment.getName().trim().isEmpty()) {
                department.setName(updatedDepartment.getName());
            }
            if (updatedDepartment.getAddr() != null && !updatedDepartment.getAddr().trim().isEmpty()) {
                department.setAddr(updatedDepartment.getAddr());
            }
            if (updatedDepartment.getCode() != null && !updatedDepartment.getCode().trim().isEmpty()) {
                department.setCode(updatedDepartment.getCode());
            }
            return deptRepo.save(department);
        }
        catch (Exception e) {
            System.out.println("Error message "+e.getMessage());
        }
        return null;
    }

    @Override
    public Department getByName(String name) {
        try{
            return deptRepo.findByName(name);
        }
        catch (Exception e) {
            System.out.println("Error message "+e.getMessage());
        }
        return null;
    }
}
