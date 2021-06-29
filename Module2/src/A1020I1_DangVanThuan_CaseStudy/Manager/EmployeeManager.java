package A1020I1_DangVanThuan_CaseStudy.Manager;

import A1020I1_DangVanThuan_CaseStudy.Commons.FileUtils;
import A1020I1_DangVanThuan_CaseStudy.Models.Employee;
import A1020I1_DangVanThuan_CaseStudy.Models.FilingCabinets;

import java.util.*;

import static A1020I1_DangVanThuan_CaseStudy.Controllers.MainController.displayMainMenu;

public class EmployeeManager {
    private static Scanner input = new Scanner(System.in);
    public static final String COMMA = ",";
    public static List<Employee> listEmployee = new ArrayList<>();
    public static final String FILE_NAME_EMPLOYEE = "src\\A1020I1_DangVanThuan_CaseStudy\\Data\\Employee.csv";

    public static void showInformationOfEmployee() {
        boolean check = true;
        do {
            System.out.println("--------Menu Employee--------");
            System.out.println("1. Add Employee" + "\n"
                    + "2. Show Information Employee " + "\n"
                    + "3. Filing Cabinets of Employee" + "\n"
                    + "4. Exit" + "\n" +
                    "------------------------");
            int choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    Employee employee = new Employee();
                    addEmployee(employee);
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    searchFillingCabinetsEmp();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không tìm thấy chức năng");
            }
        } while (!check);
    }

    public static void addEmployee(Employee employee) {
        String idEmp;
        String nameEmp;
        String dobEmp;
        String addressEmp;
        String idCardEmp;
        String numberPhoneEmp;
        String emailEmp;
        String levelEmp;
        String positionEmp;
        String salaryEmp;

        System.out.println("Input Id Employee: ");
        idEmp = input.nextLine();
        employee.setIdEmp(idEmp);
        System.out.println("Input Name Employee: ");
        nameEmp = input.nextLine();
        employee.setNameEmp(nameEmp);
        System.out.println("Input Day of Birth Employee: ");
        dobEmp = input.nextLine();
        employee.setDofEmp(dobEmp);
        System.out.println("Input Address Employee: ");
        addressEmp = input.nextLine();
        employee.setAddressEmp(addressEmp);
        System.out.println("Input ID Card Number Employee: ");
        idCardEmp = input.nextLine();
        employee.setIdCardEmp(idCardEmp);
        System.out.println("Input Number Phone Employee :");
        numberPhoneEmp = input.nextLine();
        employee.setNumberPhoneEmp(numberPhoneEmp);
        System.out.println("Input Email Employee :");
        emailEmp = input.nextLine();
        employee.setEmailEmp(emailEmp);
        System.out.println("Input Level Employee :");
        levelEmp = input.nextLine();
        employee.setLevelEmp(levelEmp);
        System.out.println("Input Position Employee :");
        positionEmp = input.nextLine();
        employee.setPositonEmp(positionEmp);
        System.out.println("Input Salary Employee :");
        salaryEmp = input.nextLine();
        employee.setSalaryEmp(salaryEmp);

        listEmployee.add(employee);
        String line;
        line = employee.getIdEmp() + COMMA + employee.getNameEmp() + COMMA + employee.getDofEmp() + COMMA + employee.getAddressEmp()
                + COMMA + employee.getIdCardEmp() + COMMA + employee.getNumberPhoneEmp() + COMMA + employee.getEmailEmp()
                + COMMA + employee.getLevelEmp() + COMMA + employee.getPositonEmp() + COMMA + employee.getSalaryEmp();
        FileUtils.writeFile(FILE_NAME_EMPLOYEE, line);
    }

    public static void showEmployee() {
        List<Employee> listEmp = FileUtils.getFileCSVToListEmployee();
        Map<String, Employee> mapEmp = new TreeMap<>();
        for (int i = 0; i < listEmp.size(); i++) {
            mapEmp.put(listEmp.get(i).getIdEmp(), listEmp.get(i));
        }
        for (Map.Entry<String, Employee> entry : mapEmp.entrySet()) {
            System.out.println("Employee's id: " + entry.getKey() + "\n" + entry.getValue());
        }
    }

    public static void searchFillingCabinetsEmp() {
        List<Employee> listEmp = FileUtils.getFileCSVToListEmployee();
        FilingCabinets profile = new FilingCabinets();
        for (Employee emp : listEmp) {
            profile.add(emp);
        }
        System.out.println("Enter name employee");
        String name = input.nextLine();
        Employee employee = profile.search(name);
        if (profile.search(name) == null) {
            System.out.println("Can't found profile of: " + name);
        } else {
            System.out.println(employee);
        }
    }
}

