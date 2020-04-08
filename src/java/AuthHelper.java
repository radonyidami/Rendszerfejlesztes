


 
public class AuthHelper {
  public static boolean isAllowedP(String username, String password) {
    return username.contentEquals("admin") && password.contentEquals("123456");
  }
}