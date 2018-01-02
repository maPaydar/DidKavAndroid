package ir.farabi.android.firstmvp.presenter.implement;

import ir.farabi.android.firstmvp.presenter.IMainPresenter;
import ir.farabi.android.firstmvp.view.MainView;

/**
 * Created by amin on 11/11/17.
 */

public class MainPresenter implements IMainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }


}
