package ir.farabi.android.firstmvp.presenter.task;

import ir.farabi.android.firstmvp.api.RequestAuth;
import ir.farabi.android.firstmvp.api.ResponseAuth;

/**
 * Created by amin on 12/3/17.
 */

public class AuthTask extends Task<ResponseAuth, RequestAuth> {

    @Override
    public ResponseAuth onTask(RequestAuth request) {
        // todo : we can send requests to server here
        // todo : we will get ResponseAuth object from server
        if (request.getName().equals("hadi") && request.getPassword().equals("123456")) {
            return new ResponseAuth(null, null, true);
        } else {
            return new ResponseAuth(null, null, false);
        }
    }
}
