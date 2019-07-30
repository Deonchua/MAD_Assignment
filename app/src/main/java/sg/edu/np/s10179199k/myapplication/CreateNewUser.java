package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewUser extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        etUsername = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPass);
    }

    public void onCancel(View v) {
        Intent in = new Intent(CreateNewUser.this, MainActivity.class);
        startActivity(in);
    }

    public void onCreate (View v)
    {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Account registerAcc = new Account(username, password);

        DbHandler dbhandler = new DbHandler(this, null, null, 1);
        dbhandler.addAccount(registerAcc);
        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
    }
}
