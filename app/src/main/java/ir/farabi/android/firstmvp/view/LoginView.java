package ir.farabi.android.firstmvp.view;

public interface LoginView {

    void onAuthStart();
    void onAuthFinished();
    void onAuthError(String throwable);
    void onAuthSuccess();
}
