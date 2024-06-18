package com.example.springbootut.springbootut.error;

public class DeptNotFoundException extends Exception{

    public DeptNotFoundException(String departmentNotFound) {
        super(departmentNotFound);
    }
}
