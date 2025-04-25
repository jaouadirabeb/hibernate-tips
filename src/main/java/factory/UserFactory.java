package factory;

public class UserFactory {
    public static User createUser(String name, String email) {
        return new User(name, email);
    }
}
