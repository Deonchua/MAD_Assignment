package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNewUser = findViewById(R.id.textView4);

        tvNewUser.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(MainActivity.this,CreateNewUser.class);
                startActivity(intent);
                return false;
            }
        });

    }

    public void onLoginClick(View v) {
        EditText userName = findViewById(R.id.etUsername);
        EditText passWord = findViewById(R.id.etPassword);

        String userNameInput = userName.getText().toString();
        String passwordInput = passWord.getText().toString();

/*        Account lgd = new Account(userNameInput, passwordInput);

        if (db.findAccount(userNameInput, passwordInput, lgd)) {
            Intent mainPage = new Intent(getBaseContext(), ToDoList.class);
            startActivity(mainPage);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid Username or password", Toast.LENGTH_SHORT).show();
            userName.getText().clear();
            passWord.getText().clear();
        }*/

}}
