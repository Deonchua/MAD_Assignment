package sg.edu.np.s10179199k.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mainapi extends AppCompatActivity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainapi);

        click = (Button) findViewById(R.id.button);

        data = (TextView) findViewById(R.id.textView12);

        click.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getdata process = new getdata();

                process.execute();



            }
        });




    }
}
