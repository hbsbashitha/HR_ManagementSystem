import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Entity.Department;
import Entity.Designation;
import Entity.Employee;
import Entity.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in); // Create a Scanner object

    public static void main(String[] args) throws IOException {
        // save();
        login();

    }

    public static void login() throws IOException {
        // Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Enter username :");
        String userName = scanner.nextLine(); // Read user input

        System.out.println("Enter password :");
        String password = scanner.nextLine(); // Read user input
        // scanner.close();

        String[] data = searchUser(userName, password);
        if (data != null) {

            if (data[4].equals("admin")) {
                System.out.println("Login Success as Admin");
                AdminTasks();

            } else if (data[4].equals("hrAssistant")) {
                System.out.println("Login Success as HR Assistant");
                hrManagerAndAssistantTasks();
            } else if (data[4].equals("hrManager")) {
                System.out.println("Login Success as HR Manager");
                hrManagerAndAssistantTasks();
            }
        } else {
            System.out.println("Login Failed");
        }

    }

    // admin tasks implementation
    public static void AdminTasks() throws IOException {

        // Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Select one of the following options : \n 1. Add HR Manager \n 2. Add HR Assistant ");

        String option = scanner.next(); // Read user input

        if (option.equals("1")) {
            System.out.println("Enter username :");
            String userName = scanner.next(); // Read user input
            System.out.println("Enter password :");
            String password = scanner.next(); // Read user input
            System.out.println("Enter email :");
            String email = scanner.next(); // Read user input
            System.out.println("Enter name :");
            String name = scanner.next(); // Read user input
            String role = "hrManager";

            saveNewUser(userName, password, email, name, role);
        } else if (option.equals("2")) {
            System.out.println("Enter username :");
            String userName = scanner.next(); // Read user input
            System.out.println("Enter password :");
            String password = scanner.next(); // Read user input
            System.out.println("Enter email :");
            String email = scanner.next(); // Read user input
            System.out.println("Enter name :");
            String name = scanner.next(); // Read user input
            String role = "hrAssistant";
            saveNewUser(userName, password, email, name, role);
        } else {
            System.out.println("Invalid Option");
        }
        // scanner.close();
    }

    public static void hrManagerAndAssistantTasks() throws IOException {
        System.out.println(
                "Select one of the following options : \n 1. Add New Department \n 2. Add New Designation \n 3. Add New Employee \n 4. Search employee Details Based on Department \n 5. Search employee Details Based on Designation \n 6. Search employee Details Based on name \n 7. Search employee Details Based on EPF number");

        String option = scanner.next(); // Read user input
        if (option.equals("1")) {
            getDepartmentDetails();

        } else if (option.equals("2")) {
            getDesignationDetails();

        } else if (option.equals("3")) {
            getEmployeeDetails();

        } else if (option.equals("4")) {
            System.out.println("Enter Department Name :");
            String departmentName = scanner.next(); // Read user input
            searchUsersUsingDepartment(departmentName);

        } else if (option.equals("5")) {

            System.out.println("Enter Designation Name :");
            String designationName = scanner.next(); // Read user input
            searchUsersUsingDesignation(designationName);

        } else if (option.equals("6")) {

            System.out.println("Enter Employee Name :");
            String employeeName = scanner.next(); // Read user input
            searchUsersUsingName(employeeName);

        } else if (option.equals("7")) {

            System.out.println("Enter Employee EPF Number :");
            String employeeEPFNumber = scanner.next(); // Read user input
            searchUsersUsingEPF(employeeEPFNumber);

        } else {
            System.out.println("Invalid Option");
        }
    }

    

    // used to search user in csv file
    public static String[] searchUser(String uName, String pWord) throws IOException {

        String filePath = "Data Files/users.csv";
        String username = uName;
        String password = pWord;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                if (cells[0].contains(username) && cells[1].contains(password)) {
                    return cells;
                }
            }

            reader.close();
        }

        return null;
    }



    public static void searchUsersUsingDepartment(String DepartmentName) throws IOException {

        String filePath = "Data Files/employees.csv";
        String department = DepartmentName;


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                if (cells[5].contains(department)) {
                    System.out.println(line);
                }
            }
            // if(line==null){
            //     System.out.println("No employee found in this department");
            // }

            reader.close();
        }

        
    }


    public static void searchUsersUsingDesignation(String Designation) throws IOException {

        String filePath = "Data Files/employees.csv";
        String designation = Designation;


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                if (cells[4].contains(designation)) {
                    System.out.println(line);
                }
            }
            // if(line==null){
            //     System.out.println("No employee found in this department");
            // }

            reader.close();
        }

        
    }



    public static void searchUsersUsingName(String Name) throws IOException {

        String filePath = "Data Files/employees.csv";
        String name= Name;


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                if (cells[0].contains(name)) {
                    System.out.println(line);
                }
            }
            // if(line==null){
            //     System.out.println("No employee found in this department");
            // }

            reader.close();
        }

        
    }

    public static void searchUsersUsingEPF(String EPFnumber) throws IOException {

        String filePath = "Data Files/employees.csv";
        String EPFNumber= EPFnumber;


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                if (cells[3].contains(EPFNumber)) {
                    System.out.println(line);
                }
            }
            // if(line==null){
            //     System.out.println("No employee found in this department");
            // }

            reader.close();
        }

        
    }

    // use to save new user in csv file
    public static void saveNewUser(String username, String password, String email, String name, String role)
            throws IOException {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setRole(role);

        File csvFile = new File("Data Files/users.csv");
        FileWriter fileWriter = new FileWriter(csvFile, true);

        fileWriter.write(user.getUsername() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getName()
                + "," + user.getRole());
        fileWriter.append("\n");

        fileWriter.close();

    }

    public static void saveNewEmployee(String name, String email, String EmpId, String EPFnumber, String designation,
            String department) throws IOException {

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setEmpID(EmpId);
        employee.setEPF_ID(EPFnumber);
        employee.setDesignation(designation);
        employee.setDepartment(department);

        File csvFile = new File("Data Files/employees.csv");
        try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
            fileWriter.write(employee.getName() + "," + employee.getEmail() + "," + employee.getEmpID() + ","
                    + employee.getEPF_ID() + "," + employee.getDesignation() + "," + employee.getDepartment());
            fileWriter.append("\n");
        }

    }


    public static void getEmployeeDetails() throws IOException {
        System.out.println("Enter name :");
        String name = scanner.next(); // Read user input
        System.out.println("Enter email :");
        String email = scanner.next(); // Read user input
        System.out.println("Enter employee ID :");
        String EmpId = scanner.next(); // Read user input
        System.out.println("Enter EPF Number :");
        String EPFnumber = scanner.next(); // Read user input
        System.out.println("Enter Designation :");
        String designation = scanner.next(); // Read user input
        System.out.println("Enter Department :");
        String department = scanner.next(); // Read user input
        saveNewEmployee(name, email, EmpId, EPFnumber, designation, department);

    }

    public static void saveNewDepartment(String departmentName ,String description) throws IOException {

        Department department = new Department();
        department.setName(departmentName);
        department.setDescription(description);

        File csvFile = new File("Data Files/departments.csv");
        try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
            fileWriter.write(department.getName() + "," + department.getDescription());
            fileWriter.append("\n");
        }



    }

    public static void getDepartmentDetails() throws IOException {
        System.out.println("Enter Department Name :");
        String departmentName = scanner.next(); // Read user input
        System.out.println("Enter Description :");
        String description = scanner.next(); // Read user input
        saveNewDepartment(departmentName, description);
    }

    public static void saveNewDesignation(String designationName ,String description) throws IOException {

        Designation designation = new Designation();
        designation.setName(designationName);
        designation.setDescription(description);

        File csvFile = new File("Data Files/designations.csv");
        try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
            fileWriter.write(designation.getName() + "," + designation.getDescription());
            fileWriter.append("\n");
        }



    }

    public static void getDesignationDetails() throws IOException {
        System.out.println("Enter Designation Name :");
        String designationName = scanner.next(); // Read user input
        System.out.println("Enter Description :");
        String description = scanner.next(); // Read user input
        saveNewDesignation(designationName, description);
    }
    

   
}