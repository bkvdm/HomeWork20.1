package tel.bvm.homeWork20SpringBoot.service.impl;

public class Employee {

    private String surname;
    private final String name;
    private final String fatherName;
    private int department;
    private int salary;
    private final int personalNumber;

    private static Integer personalNumberGenerate = 1;

    public Employee(String surname, String name, String fatherName, int department, int salary) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.department = department;
        this.salary = salary;
        this.personalNumber = personalNumberGenerate++;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public static Integer getPersonalNumberGenerate() {
        return personalNumberGenerate;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", personalNumber=" + personalNumber +
                '}';
    }
}

