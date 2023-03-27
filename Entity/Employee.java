package Entity;

public class Employee {

    private String name;
    private String email;
    private String empID;
    private String EPF_ID;
    private String department;
    private String designation;

    public Employee() {
    }

    public Employee(String name, String email, String empID, String EPF_ID, String department, String designation) {
        this.name = name;
        this.email = email;
        this.empID = empID;
        this.EPF_ID = EPF_ID;
        this.department = department;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEPF_ID() {
        return EPF_ID;
    }

    public void setEPF_ID(String EPF_ID) {
        this.EPF_ID = EPF_ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", email=" + email + ", empID=" + empID + ", EPF_ID=" + EPF_ID + ", department=" + department + ", designation=" + designation + '}';
    }
    
}
