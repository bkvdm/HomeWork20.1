package tel.bvm.homeWork20SpringBoot.service.api;

import tel.bvm.homeWork20SpringBoot.service.impl.Employee;

import java.util.List;

public interface EmployeeInfo {
//    String enterNewEmployee(String surname, String name, String fatherName);

    public String greeting();

    List<Employee> employeeDataArchive();

    public void enterNewEmployee(Employee employee);

    public int departmentNumberGenerator();

    public int salaryValueGenerator();

//    int sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(int sampleDepartmentNumber);

//    int sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(int sampleDepartmentNumber, int sampleIndexSalary);

    StringBuilder archiveToPrint(List<Employee> employees);

    StringBuilder print();

    int sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(int sampleDepartmentNumber, int sampleIndexSalary, int sampleSalaryParameter);

//    int sampleIndexSalary(int sampleIndexSalary);

//    public void employeeWithMaxSalary(int selectedDepartment, List<Employee> employeeDataArchive);

//    public void enterNewEmployee(Employee employee);
}

