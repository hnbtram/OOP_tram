public class TestUser {
    public static void test() {
        User user = new User("Tram", "baotram123", "baotram@example.com");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Email: " + user.getEmail());
    }
}