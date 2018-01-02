package ir.farabi.android.firstmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.farabi.android.firstmvp.presenter.ILogInPresenter;
import ir.farabi.android.firstmvp.presenter.implement.LogInPresenter;
import ir.farabi.android.firstmvp.view.LoginView;

public class LogInActivity extends AppCompatActivity implements LoginView {

    private EditText userNameEdit;
    private EditText passwordEdit;
    private Button submitButton;
    private ILogInPresenter logInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);

        logInPresenter = new LogInPresenter(this);

        userNameEdit = findViewById(R.id.username_edit);
        passwordEdit = findViewById(R.id.password_edit);
        submitButton = findViewById(R.id.submit_btn);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                logInPresenter.doAuth(userName, password);
            }
        });
    }


    @Override
    public void onAuthStart() {
        // show progress
        Toast.makeText(this, "onAuthStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthFinished() {
        // hide progress
        Toast.makeText(this, "onAuthFinished", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthError(String throwable) {
        Toast.makeText(this, "onAuthError: " + throwable, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthSuccess() {
//        onAuthFinished();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
