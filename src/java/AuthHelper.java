
 
public class AuthHelper {
  public static boolean isAllowedP(String username, String password) {
    return username.contentEquals("piroska") && password.contentEquals("123456");
  }
  public static boolean isAllowedF(String username, String password) {
    return username.contentEquals("farkas") && password.contentEquals("1234567");
  }
}