package Entity;

public class HR  extends User {
    
        public HR() {
        }
    
        public HR(String name, String email, String password, String role) {
            super(name, email, password, role);
        }
    
        @Override
        public String toString() {
            return "HR{" + super.toString() + '}';
        }
    
}
