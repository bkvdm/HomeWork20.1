package tel.bvm.homeWork20SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tel.bvm.homeWork20SpringBoot.service.api.EmployeeInfo;

public class ControllerEmployee {

    public final EmployeeInfo employeeInfo;

    public ControllerEmployee(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    @GetMapping(path = "/newEmployee")
    public String enterNewEmployee(@RequestParam(surname = "surname", required = false) String surname, @RequestParam(name = "name", required = false) String name, @RequestParam(fatherName = "fatherName", required = false) String fatherName) {
        return employeeInfo.enterNewEmployee(surname, name, fatherName);
    }
}
