package tel.bvm.homeWork20SpringBoot.service.impl;

import org.springframework.stereotype.Service;
import tel.bvm.homeWork20SpringBoot.service.api.EmployeeInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EmployeeInfoImpl implements EmployeeInfo {

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

    public String greeting() {
        return "Добро пожаловать" + "Для внесения информации о сотрудниках нужно в адресной строке выбрать и ввести фамилие, имя, отчество, например:" +
                "http://localhost:8080/employee/newEmployee?surname=Яковлев&name=Яков&fatherName=Михайлович";
    }

    @Override
    public List<Employee> employeeDataArchive() {
        List<Employee> employeeDataArchive = new ArrayList<>(Arrays.asList(
                new Employee("Иванов", "Иван", "Иванович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Петров", "Пётр", "Петрович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Новая", "Мария", "Олеговна", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Симонов", "Тимофей", "Трифонович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Виноградова", "Анастасия", "Викторовна", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Неизвестный", "Никита", "Константинович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Громыко", "Павел", "Ханович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Ким", "Юрий", "Леонидович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Великий", "Антон", "Александрович", departmentNumberGenerator(), salaryValueGenerator()),
                new Employee("Крымская", "Маргарита", "Вячеславовна", departmentNumberGenerator(), salaryValueGenerator())));

        return employeeDataArchive;
    }

    @Override
    public void enterNewEmployee(Employee employee) {
        employeeDataArchive().add(employee);
    }

    @Override
    public StringBuilder print() {
        return archiveToPrint(employeeDataArchive());
    }

    public StringBuilder archiveToPrint(List<Employee> employeeDataArchive) {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            print.append("employees = ").append(employeeDataArchive.get(i));
        }
        return print;
    }

    @Override
    public String sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(int sampleDepartmentNumber, int sampleIndexSalary, int sampleSalaryParameter) {

//        employeeWithMaxSalary(sampleDepartmentNumber, employeeDataArchive());
//        employeeWithMinSalary(sampleDepartmentNumber, employeeDataArchive());
//        sumSalary(sampleDepartmentNumber, employeeDataArchive());
//        salaryIndexation(sampleIndexSalary, sampleDepartmentNumber, employeeDataArchive());
//        salarySamplingParameter(sampleSalaryParameter, employeeDataArchive());

        String printMaxSalary = employeeWithMaxSalary(sampleDepartmentNumber, employeeDataArchive());
        String printMinSalary = employeeWithMinSalary(sampleDepartmentNumber, employeeDataArchive());
        String printSumSalary = sumSalary(sampleDepartmentNumber, employeeDataArchive());
        String printSalaryIndexation = salaryIndexation(sampleIndexSalary, sampleDepartmentNumber, employeeDataArchive());
        String printSalarySamplingParameter = salarySamplingParameter(sampleSalaryParameter, employeeDataArchive());

        return printMaxSalary + printMinSalary + printSumSalary + printSalaryIndexation + printSalarySamplingParameter;
    }

//    @Override
//    public int sampleIndexSalary(int sampleIndexSalary) {
//
//        return sampleIndexSalary;
//    }

    public String employeeWithMaxSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int maxSalary = 0;
        int employeeWithMaxSalary = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                if (employeeDataArchive.get(i).getSalary() > maxSalary) {
                    maxSalary = employeeDataArchive.get(i).getSalary();
                    employeeWithMaxSalary = i;
                }
            }
        }
        return ("maxSalary = " + maxSalary + " " + employeeDataArchive.get(employeeWithMaxSalary).getSurname() + " " + employeeDataArchive.get(employeeWithMaxSalary).getName() + " " + employeeDataArchive.get(employeeWithMaxSalary).getFatherName());
    }

    public String employeeWithMinSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int employeeWithMinSalary = 0;
        int minSalary = 0;
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                if (salaryIntroduce == 1) {
                    minSalary = employeeDataArchive.get(i).getSalary();
                }
            }
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                if (employeeDataArchive.get(i).getSalary() < minSalary) {
                    minSalary = employeeDataArchive.get(i).getSalary();
                }
                employeeWithMinSalary = i;
            }
        }
        return ("minSalary = " + minSalary + " " + employeeDataArchive.get(employeeWithMinSalary).getSurname() + " " + employeeDataArchive.get(employeeWithMinSalary).getName() + " " + employeeDataArchive.get(employeeWithMinSalary).getFatherName());
    }

    public String sumSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int sumSalary = 0;
        int salaryIntroduce = 0;
        String print = "";
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                sumSalary = sumSalary + employeeDataArchive.get(i).getSalary();
                salaryIntroduce++;
            }
            if (i == employeeDataArchive.size() - 1) {
                print = ("sumSalary = " + sumSalary);
                if (salaryIntroduce > 0) {
                    print = ("sumSalaryAverage = " + sumSalary / salaryIntroduce);
                } else
                    print = ("Для расчёта средней зарплаты отдела, нужно наличие хотя бы одного сотрудника в отделе");
            }
        }
        return print;
    }

    public String salaryIndexation(int salaryIndexation, int selectedDepartment, List<Employee> employeeDataArchive) {
        String print = ("Индексация зарплаты на " + salaryIndexation + " процентов:");
        String printIndexationResult = "";
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                employeeDataArchive.get(i).setSalary(employeeDataArchive.get(i).getSalary() + employeeDataArchive.get(i).getSalary() * salaryIndexation / 100);
                printIndexationResult = (employeeDataArchive.get(i).getSurname() + " " + employeeDataArchive.get(i).getName() + " " + employeeDataArchive.get(i).getFatherName() + ", зарплата: " + employeeDataArchive.get(i).getSalary() + " персональный номер: " + employeeDataArchive.get(i).getPersonalNumber());
            } else if (salaryIntroduce == 0 && i == employeeDataArchive.size() - 1)
                printIndexationResult = ("Нет сотрудников в отделе, " + selectedDepartment + " чтобы можно было проиндексировать их зарплату");
        }
        return print + printIndexationResult;
    }

    public String salarySamplingParameter(int salarySamplingParameter, List<Employee> employeeDataArchive) {
        int signArchiveSize = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                signArchiveSize++;
            }
        }
        String printHeadingOne = "";
        String printHeadingTwo = "";
        String printSalarySamplingParameterMax = "";
        String printSalarySamplingParameterMin = "";
        if (signArchiveSize == employeeDataArchive.size()) {
            int countyIndexMax = 0;
            List<Object> salarySamplingParameterMax = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
                    salarySamplingParameterMax.add(employeeDataArchive.get(i));
                }
            }
            printHeadingOne = ("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.size(); i++) {
                printSalarySamplingParameterMax = ("salarySamplingParameterMax[i] = " + salarySamplingParameterMax.get(i));
            }
        } else if (signArchiveSize == 0) {
            int countyIndexMin = 0;
            List<Object> salarySamplingParameterMin = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
                    salarySamplingParameterMin.add(employeeDataArchive.get(i));
                }
            }
            printHeadingTwo = ("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.size(); i++) {
                printSalarySamplingParameterMin = ("salarySamplingParameterMin[i] = " + salarySamplingParameterMin.get(i));
            }
        } else if (signArchiveSize > 0 && signArchiveSize != 10) {
            int countyIndexMax = 0;
            List<Object> salarySamplingParameterMax = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
                    salarySamplingParameterMax.add(employeeDataArchive.get(i));
                }
            }
            printHeadingOne = ("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.size(); i++) {
                printSalarySamplingParameterMax = ("salarySamplingParameterMax[i] = " + salarySamplingParameterMax.get(i));
            }
            int countyIndexMin = 0;
            List<Object> salarySamplingParameterMin = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
                    salarySamplingParameterMin.add(employeeDataArchive.get(i));
                }
            }
            printHeadingTwo = ("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.size(); i++) {
                printSalarySamplingParameterMin = ("salarySamplingParameterMin[i] = " + salarySamplingParameterMin.get(i));
            }
        }
        return printHeadingOne + printSalarySamplingParameterMax + printHeadingTwo + printSalarySamplingParameterMin;
    }
}
