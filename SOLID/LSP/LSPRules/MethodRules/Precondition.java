class User {
    public void login(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password too short!");
        }
        System.out.println("User logged in");
    }
}

class AdminUser extends User {
    @Override
    public void login(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Admin password too short!");
        }
        System.out.println("Admin logged in");
    }
}

public class Precondition {
    public static void main(String[] args) {
        User u = new AdminUser();
        u.login("ad"); //  Works (6 chars): AdminUser allows shorter password
    }
}
