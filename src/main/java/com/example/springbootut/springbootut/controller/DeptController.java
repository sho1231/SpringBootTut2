package com.example.springbootut.springbootut.controller;

import com.example.springbootut.springbootut.entity.Department;
import com.example.springbootut.springbootut.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptServiceImpl;
    @PostMapping("/save")
    public Department save(@RequestBody Department department) {
        return deptServiceImpl.save(department);
    }
    @GetMapping("/getAll")
    public List<Department> getAllDepartments() {
        return deptServiceImpl.getAll();
    }
    @GetMapping("/getById/{id}")
    public Department getById(@PathVariable Long id) {
        return deptServiceImpl.findById(id);
    }
    @DeleteMapping("/deleteById/{id}")
    public boolean delDeptById (@PathVariable Long id) {
        return deptServiceImpl.delById(id);

    }
    @PutMapping("/updateById/{id}")
    public Department updateById(@PathVariable Long id, @RequestBody Department department) {
        return deptServiceImpl.updateById(id,department);
    }

    @GetMapping("/fetchByName/{name}")
    public Department fetchByName(@PathVariable String name) {
        return deptServiceImpl.getByName(name);
    }

}
