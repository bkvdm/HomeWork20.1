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
                "employee/newEmployee?surname=Петров&name=Пётр&fatherName=Петрович";
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
    public int sampleDepartmentNumberAndIndexSalaryAndSalaryParameter(int sampleDepartmentNumber, int sampleIndexSalary, int sampleSalaryParameter) {
        employeeWithMaxSalary(sampleDepartmentNumber, employeeDataArchive());
        employeeWithMinSalary(sampleDepartmentNumber, employeeDataArchive());
        sumSalary(sampleDepartmentNumber, employeeDataArchive());
        salaryIndexation(sampleIndexSalary, sampleDepartmentNumber, employeeDataArchive());
        salarySamplingParameter(sampleSalaryParameter, employeeDataArchive());
        return sampleDepartmentNumber;
    }

//    @Override
//    public int sampleIndexSalary(int sampleIndexSalary) {
//
//        return sampleIndexSalary;
//    }

    public void employeeWithMaxSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
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
        System.out.println("maxSalary = " + maxSalary + " " + employeeDataArchive.get(employeeWithMaxSalary).getSurname() + " " + employeeDataArchive.get(employeeWithMaxSalary).getName() + " " + employeeDataArchive.get(employeeWithMaxSalary).getFatherName());
    }

    public void employeeWithMinSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
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
        System.out.println("minSalary = " + minSalary + " " + employeeDataArchive.get(employeeWithMinSalary).getSurname() + " " + employeeDataArchive.get(employeeWithMinSalary).getName() + " " + employeeDataArchive.get(employeeWithMinSalary).getFatherName());
    }

    public void sumSalary(int selectedDepartment, List<Employee> employeeDataArchive) {
        int sumSalary = 0;
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                sumSalary = sumSalary + employeeDataArchive.get(i).getSalary();
                salaryIntroduce++;
            }
            if (i == employeeDataArchive.size() - 1) {
                System.out.println("sumSalary = " + sumSalary);
                if (salaryIntroduce > 0) {
                    System.out.println("sumSalaryAverage = " + sumSalary / salaryIntroduce);
                } else
                    System.out.println("Для расчёта средней зарплаты отдела, нужно наличие хотя бы одного сотрудника в отделе");
            }
        }
    }

    public static void salaryIndexation(int salaryIndexation, int selectedDepartment, List<Employee> employeeDataArchive) {
        System.out.println("Индексация зарплаты на " + salaryIndexation + " процентов:");
        int salaryIntroduce = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getDepartment() == selectedDepartment) {
                salaryIntroduce++;
                employeeDataArchive.get(i).setSalary(employeeDataArchive.get(i).getSalary() + employeeDataArchive.get(i).getSalary() * salaryIndexation / 100);
                System.out.println(employeeDataArchive.get(i).getSurname() + " " + employeeDataArchive.get(i).getName() + " " + employeeDataArchive.get(i).getFatherName() + ", зарплата: " + employeeDataArchive.get(i).getSalary() + " персональный номер: " + employeeDataArchive.get(i).getPersonalNumber());
            } else if (salaryIntroduce == 0 && i == employeeDataArchive.size() - 1)
                System.out.println("Нет сотрудников в отделе, " + selectedDepartment + " чтобы можно было проиндексировать их зарплату");
        }
    }

    public static void salarySamplingParameter(int salarySamplingParameter, List<Employee> employeeDataArchive) {
        int signArchiveSize = 0;
        for (int i = 0; i < employeeDataArchive.size(); i++) {
            if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                signArchiveSize++;
            }
        }
        if (signArchiveSize == employeeDataArchive.size()) {
            int countyIndexMax = 0;
            List<Object> salarySamplingParameterMax = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() >= salarySamplingParameter) {
                    countyIndexMax++;
                    salarySamplingParameterMax.add(employeeDataArchive.get(i));
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.size(); i++) {
                System.out.println("salarySamplingParameterMax[i] = " + salarySamplingParameterMax.get(i));
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
            System.out.println("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.size(); i++) {
                System.out.println("salarySamplingParameterMin[i] = " + salarySamplingParameterMin.get(i));
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
            System.out.println("Информация о сотрудниках с зарплатой, больше или равной " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMax.size(); i++) {
                System.out.println("salarySamplingParameterMax[i] = " + salarySamplingParameterMax.get(i));
            }
            int countyIndexMin = 0;
            List<Object> salarySamplingParameterMin = new ArrayList<>(Arrays.asList());
            for (int i = 0; i < employeeDataArchive.size(); i++) {
                if (employeeDataArchive.get(i).getSalary() < salarySamplingParameter) {
                    countyIndexMin++;
                    salarySamplingParameterMin.add(employeeDataArchive.get(i));
                }
            }
            System.out.println("Информация о сотрудниках с зарплатой, меньше " + salarySamplingParameter + ":");
            for (int i = 0; i < salarySamplingParameterMin.size(); i++) {
                System.out.println("salarySamplingParameterMin[i] = " + salarySamplingParameterMin.get(i));
            }
        }
    }
}
