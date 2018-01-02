package ir.farabi.android.firstmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.farabi.android.firstmvp.model.Greeting;
import ir.farabi.android.firstmvp.model.repository.GreetingService;

public class MainActivity extends AppCompatActivity {

    private TextView greetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetTextView = findViewById(R.id.greet_text);

        GreetingService greetingService = new GreetingService();
        greetingService.read().subscribeWith(new Observer<List<Greeting>>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<Greeting> greetings) {
                greetTextView.setText(greetings.get(0).toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Finish greeting.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
