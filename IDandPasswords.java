import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> loggininfo = new HashMap<String, String>();

    IDandPasswords() {
        loggininfo.put("your", "Name");
        loggininfo.put("ABC", "123");
        loggininfo.put("Username", "Password");

    }
    protected HashMap<String, String> getLoginInfo(){
        return loggininfo;
    }
}
