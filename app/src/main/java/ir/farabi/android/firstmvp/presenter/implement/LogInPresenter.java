package ir.farabi.android.firstmvp.presenter.implement;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ir.farabi.android.firstmvp.api.RequestAuth;
import ir.farabi.android.firstmvp.api.ResponseAuth;
import ir.farabi.android.firstmvp.presenter.ILogInPresenter;
import ir.farabi.android.firstmvp.presenter.task.AuthTask;
import ir.farabi.android.firstmvp.view.LoginView;

/**
 * Created by amin on 11/11/17.
 */

public class LogInPresenter implements ILogInPresenter {

    private final AuthTask authTask;
    private LoginView view;

    public LogInPresenter(LoginView view) {
        this.view = view;
        this.authTask = new AuthTask();
    }

    @Override
    public void doAuth(String username, String password) {
        view.onAuthStart();
        authTask.doTask(new RequestAuth(username, password)).subscribe(new Observer<ResponseAuth>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ResponseAuth responseAuth) {
                if (responseAuth.isAuthenticated()) {
                    view.onAuthSuccess();
                } else {
                    view.onAuthError(responseAuth.getError());
                }
            }

            @Override
            public void onError(Throwable e) {
                view.onAuthError(e.getMessage());
            }

            @Override
            public void onComplete() {
                view.onAuthFinished();
            }
        });
    }

    @Override
    public void onCancel() {

    }
}
