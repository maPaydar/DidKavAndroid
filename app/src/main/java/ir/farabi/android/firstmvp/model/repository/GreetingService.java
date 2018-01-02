package ir.farabi.android.firstmvp.model.repository;

import java.util.List;

import io.reactivex.Observable;
import ir.farabi.android.firstmvp.model.Greeting;
import ir.farabi.android.firstmvp.presenter.task.GreetTask;

/**
 * Created by amin on 12/5/17.
 */

public class GreetingService implements CrudService<Greeting> {

    @Override
    public Observable<Boolean> create(Greeting... greeting) {
        return null;
    }

    @Override
    public Observable<List<Greeting>> read() {
        GreetTask greetTask = new GreetTask();
        return greetTask.doTask(null);
    }

    @Override
    public Observable<Boolean> update(Greeting... greeting) {
        return null;
    }

    @Override
    public Observable<Boolean> delete(Greeting... greeting) {
        return null;
    }

}
