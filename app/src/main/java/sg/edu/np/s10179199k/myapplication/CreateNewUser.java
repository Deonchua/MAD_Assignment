package sg.edu.np.s10179199k.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CreateNewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);
    }

    public void onCancel(View v) {
        Intent in = new Intent(CreateNewUser.this, MainActivity.class);
        startActivity(in);
    }
}
