package ir.farabi.android.firstmvp.model.repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by amin on 12/5/17.
 */

public interface CrudService<R> {

    Observable<Boolean> create(R... r);

    Observable<List<R>> read();

    Observable<Boolean> update(R... r);

    Observable<Boolean> delete(R... r);

}
