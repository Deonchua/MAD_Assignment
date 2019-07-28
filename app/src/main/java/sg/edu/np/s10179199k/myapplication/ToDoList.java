package sg.edu.np.s10179199k.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ToDoList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTodo();
            }
        });


    }
    void saveTodo() {
        // first section
        // get the data to save in our firebase db
        EditText nameEdtText = (EditText) findViewById(R.id.editText6);
        EditText messageEditText = (EditText) findViewById(R.id.editText8);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        Date date = new Date();
        date.setMonth(datePicker.getMonth());
        date.setYear(datePicker.getYear());
        date.setDate(datePicker.getDayOfMonth());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String dateString = format.format(date);
        //make the modal object and convert it into hasmap


        //second section
        //save it to the firebase db
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String key = database.getReference("todoList").push().getKey();

        ToDo todo = new ToDo();
        todo.setName(nameEdtText.getText().toString());
        todo.setMessage(messageEditText.getText().toString());
        todo.setDate(dateString);

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, todo.toFirebaseObject());
        database.getReference("todoList").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    finish();
                }
            }
        });*/
    }
}
