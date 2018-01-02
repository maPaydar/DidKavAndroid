package ir.farabi.android.firstmvp.api;

import org.json.JSONObject;

/**
 * Created by amin on 11/11/17.
 */

public class ResponseAuth extends JSONObject {

    private String authId;
    private String error;
    private boolean isAuthenticated;

    public ResponseAuth(String authId, String error, boolean isAuthenticated) {
        this.authId = authId;
        this.error = error;
        this.isAuthenticated = isAuthenticated;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public String getAuthId() {
        return authId;
    }

    public String getError() {
        return error;
    }

}
