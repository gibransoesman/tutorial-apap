package apap.tutorial.gopud.service;
import apap.tutorial.gopud.model.UserModel;

public interface UserService {
    UserModel addUser (UserModel user);
    public String encrypt(String password);
    UserModel getUser(String name);
	boolean isMatch(String rawPassword, String encodedPassword);
	void changePassword(UserModel user, String newPassword);
}