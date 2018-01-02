package ir.farabi.android.firstmvp.api;

/**
 * Created by amin on 12/3/17.
 */

public class RequestAuth {

    private String name;
    private String password;

    public RequestAuth(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
