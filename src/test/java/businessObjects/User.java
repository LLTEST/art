package businessObjects;

public class User {

    private final String USER_1;

    private final String PASS_1;

    public User (String user, String pass){
        USER_1=user;
        PASS_1=pass;
    }

    public String getUSER1() {
        return USER_1;
    }

    public String getPASS1() {
        return PASS_1;
    }

}

