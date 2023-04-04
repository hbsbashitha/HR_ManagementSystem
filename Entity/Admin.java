package Entity;

public class Admin extends User {
    
        public Admin() {
        }
    
        public Admin(String name, String email,String username, String password, String role) {
            super(name, email,username, password, role);
        }
    
        @Override
        public String toString() {
            return "Admin{" + super.toString() + '}';
        }
    
}
