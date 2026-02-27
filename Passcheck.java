
import java.util.regex.*;
public class Passcheck {
    public static boolean checkPassword(String password) 
    {
        String rules = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S$).{8,20}$";
        Pattern pattern = Pattern.compile(rules);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(checkPassword("weak"));
        System.out.println(checkPassword("DD")); 
    }
}