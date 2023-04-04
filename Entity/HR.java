package Entity;

public class HR  extends User {
    
        public HR() {
        }
    
        public HR(String name, String email,String username, String password, String role) {
            super(name, email,username, password, role);
        }
    
        @Override
        public String toString() {
            return "HR{" + super.toString() + '}';
        }
    
}
