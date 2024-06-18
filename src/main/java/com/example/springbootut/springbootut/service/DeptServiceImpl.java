package com.example.springbootut.springbootut.service;

import com.example.springbootut.springbootut.entity.Department;
import com.example.springbootut.springbootut.error.DeptNotFoundException;
import com.example.springbootut.springbootut.repo.DeptRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService{
    private final Logger LOGGER = LoggerFactory.getLogger(DeptServiceImpl.class);
    @Autowired
    private DeptRepo deptRepo;
    @Override
    public Department save(Department department) {

        try{
            return deptRepo.save(department);
        }
        catch (Exception e) {
            LOGGER.debug(e.toString());
        }
        return null;
    }
    @Override
    public List<Department> getAll() {
        return deptRepo.findAll();
    }

    @Override
    public Department findById(Long id) throws DeptNotFoundException {
        Optional<Department> department = deptRepo.findById(id);
        if (department.isEmpty())
            throw new DeptNotFoundException("Department not found");
        return department.get();
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
//        try {
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
//        }
    }

    @Override
    public Department getByName(String name) {
//        try{
            return deptRepo.findByName(name);
//        }
//        catch (Exception e) {
//            System.out.println("Error message "+e.getMessage());
//        }
//        return null;
    }
}
