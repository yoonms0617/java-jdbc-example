package model;

public class Employee {

    private Long id;

    private String name;

    private String job;

    private String salary;

    public Employee(Long id, String name, String job, String salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + job + " " + salary;
    }

}
