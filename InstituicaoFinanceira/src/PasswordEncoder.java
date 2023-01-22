import java.io.IOException;
import java.util.Base64;

public class PasswordEncoder {
    public PasswordEncoder() {  }

    public String Base64ToString(String str) throws IOException {
        return Base64.getDecoder().decode(str).toString();
    }

    public String stringToBase64(String bt) {
        String returnString = Base64.getEncoder().encodeToString(bt.getBytes());
        return returnString;
    }

}
