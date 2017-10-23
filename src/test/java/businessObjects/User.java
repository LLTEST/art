package businessObjects;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Test
public class User {

    private static String h;

    private static String b;

    private static String h4;

    private static String b4;

    @Parameters({ "sUsername1", "sPassword1", "sUsername4", "sPassword4"})
    public User(String sUsername1, String sPassword1, String sUsername4, String sPassword4){
        h=sUsername1;
        b=sPassword1;
        h4=sUsername4;
        b4=sPassword4;
    }

    private final static String USER_1 = h;

    private final static String PASS_1 = b;

    private final static String USER_2="userrtestt2@gmail.com";

    private final static String PASS_2="p9660220_";

    private final static String USER_3="userrtestt3@gmail.com";

    private final static String PASS_3="p9660220_";

    private final static String USER_4=h4;

    private final static String PASS_4=b4;


    public String getUSER1() {
      return USER_1;
    }

    public String getPASS1() {
        return PASS_1;
    }

    public String getUSER4() {
        return USER_4;
    }

    public String getPASS4() {
        return PASS_4;
    }

}

