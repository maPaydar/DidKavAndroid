package ir.farabi.android.firstmvp.presenter;


public interface ILogInPresenter {

    void doAuth(String username, String password);
    void onCancel();
}
