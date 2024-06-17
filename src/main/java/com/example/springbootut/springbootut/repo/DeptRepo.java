package com.example.springbootut.springbootut.repo;

import com.example.springbootut.springbootut.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository<Department,Long> {
    //case sensitive
    public Department findByName (String name);
    //Non case sensitive
    public Department findByNameIgnoreCase (String name);

}
