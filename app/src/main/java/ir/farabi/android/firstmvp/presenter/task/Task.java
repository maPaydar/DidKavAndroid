package ir.farabi.android.firstmvp.presenter.task;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amin on 12/3/17.
 */

public abstract class Task<R, T> {

    public abstract R onTask(T object);

    public Observable<R> doTask(final T object) {
        Observable<R> observable = Observable.create(new ObservableOnSubscribe<R>() {
            @Override
            public void subscribe(ObservableEmitter<R> e) throws Exception {
                try {
                    R r = onTask(object);
                    e.onNext(r);
                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
