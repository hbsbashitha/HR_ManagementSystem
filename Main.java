import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Entity.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
 
public class Main {
 
    static Scanner  scanner = new Scanner(System.in); // Create a Scanner object


    public static void main(String[] args) throws IOException {
        // save();
        login();
        
    }

    public static void login() throws IOException {
    // Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    System.out.println("Enter username :");
    String userName = scanner.nextLine();  // Read user input
   
    System.out.println("Enter password :");
    String password = scanner.nextLine();  // Read user input
    // scanner.close();
    
    String[] data = searchUser(userName,password);
    if(data!=null){
        
        if(data[4].equals("admin")){
            System.out.println("Login Success as Admin");
            AdminTasks();

        }
        else if(data[4].equals("hrAssistant")){
            System.out.println("Login Success as HR Assistant");
        }
        else if(data[4].equals("hrManager")){
            System.out.println("Login Success as HR Manager");
        }
    }else{
        System.out.println("Login Failed");
    }


    }

    //admin tasks implementation
    public static void AdminTasks() throws IOException {
                    
    // Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    System.out.println("Select one of the following options : \n 1. Add HR Manager \n 2. Add HR Assistant ");

    String option = scanner.next();  // Read user input
   
    if(option.equals("1")){
        System.out.println("Enter username :");
        String userName = scanner.next();  // Read user input
        System.out.println("Enter password :");
        String password = scanner.next();  // Read user input
        System.out.println("Enter email :");
        String email = scanner.next();  // Read user input
        System.out.println("Enter name :");
        String name = scanner.next();  // Read user input
        String role = "hrManager";

        saveNewUser(userName,password,email,name,role);
    }
    else if(option.equals("2")){
        System.out.println("Enter username :");
        String userName = scanner.next();  // Read user input
        System.out.println("Enter password :");
        String password = scanner.next();  // Read user input
        System.out.println("Enter email :");
        String email = scanner.next();  // Read user input
        System.out.println("Enter name :");
        String name = scanner.next();  // Read user input
        String role = "hrAssistant";
        saveNewUser(userName,password,email,name,role);
    }
    else{
        System.out.println("Invalid Option");
    }
    scanner.close();

    }




    //used to search user in csv file
    public static String[] searchUser(String uName,String pWord) throws IOException {

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


    //use to save new user in csv file
    public static void saveNewUser(String username,String password,String email,String name,String role) throws IOException {

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setName(name);
    user.setRole(role);



    File csvFile = new File("Data Files/users.csv");
    FileWriter fileWriter = new FileWriter(csvFile,true);
  
    fileWriter.write(user.getUsername() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getName() + "," + user.getRole());
    fileWriter.append("\n");
    
    fileWriter.close();
            
    }
}