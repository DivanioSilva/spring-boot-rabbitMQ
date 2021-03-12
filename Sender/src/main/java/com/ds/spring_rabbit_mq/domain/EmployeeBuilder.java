package com.ds.spring_rabbit_mq.domain;

public class EmployeeBuilder {
    private String name;
    private String id;

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public Employee build() {
        return new Employee(name, id);
    }
}