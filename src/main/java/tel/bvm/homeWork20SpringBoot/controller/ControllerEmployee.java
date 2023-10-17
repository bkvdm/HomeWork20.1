package tel.bvm.homeWork20SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tel.bvm.homeWork20SpringBoot.service.api.EmployeeInfo;
import tel.bvm.homeWork20SpringBoot.service.impl.Employee;

@RestController
public class ControllerEmployee {

    public final EmployeeInfo employeeInfo;

    public ControllerEmployee(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public int departmentNumberGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 1;
        int departmentNumberGenerator = random.nextInt(5) + minimumScore;
        return departmentNumberGenerator;
    }

    public int salaryValueGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 100_000;
        int salaryValueGenerator = random.nextInt(300_000) + minimumScore;
        return salaryValueGenerator;
    }

    @GetMapping()
    public String greating() {
        return employeeInfo.greeting();
    }

    @GetMapping(path = "employee/newEmployee")
    public String enterNewEmployee(@RequestParam(value = "surname", required = false) String surname,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "fatherName", required = false) String fatherName) {
        int departmentNumber = departmentNumberGenerator();
        int salaryValue = salaryValueGenerator();
        Employee employee = new Employee(surname, name, fatherName, departmentNumber, salaryValue);
        employeeInfo.enterNewEmployee(employee);
        return "Информация о сотруднике " + surname + " " + name + " " + fatherName + ", введена успешно. " + "Далее нужно: " +
                "ввести номер отдела (от 1 - 5), по которому нужно сделать выборку, процент индексации заработной платы и размер зарплаты относительно которой, нужно сделать сортировку, например: "
                + "http://localhost:8080/employee/sample?departmentNumber=1&indexSalary=20&salaryParameter=150000";
    }

    @GetMapping(path = "employee/print")
    public StringBuilder archiveToPrint() {
        return employeeInfo.print();
    }

    @GetMapping(path = "employee/sample")
    public String sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(@RequestParam(value = "departmentNumber", required = false) int sampleDepartmentNumber,
                                                                         @RequestParam(value = "indexSalary", required = false) int sampleIndexSalary,
                                                                         @RequestParam(value = "salaryParameter", required = false) int sampleSalaryParameter) {
        return employeeInfo.sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(sampleDepartmentNumber, sampleIndexSalary, sampleSalaryParameter);
    }
}
