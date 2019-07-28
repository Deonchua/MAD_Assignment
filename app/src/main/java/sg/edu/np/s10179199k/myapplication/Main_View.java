package sg.edu.np.s10179199k.myapplication;

import android.support.v7.app.AppCompatActivity;

public class Main_View extends AppCompatActivity {
   /* RecycleAdapter adapter;
    ArrayList<ToDo> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__view);

        *//*Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*//*

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(Main_View.this,ToDo.class);
                Main_View.this.startActivity(newIntent);
            }
        });

        todoList = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.myRecycleView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new RecycleAdapter();
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            ToDo todo = (ToDo)extras.get("todo");
            if (todo != null) {
                EditText nameEdtText = (EditText)findViewById(R.id.editText6);
                EditText messageEditText = (EditText)findViewById(R.id.editText8);
                DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

                nameEdtText.setText(todo.getName());
                messageEditText.setText(todo.getMessage());

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                try {
                    Date date = format.parse(todo.getDate());
                    datePicker.updateDate(date.getYear(), date.getMonth(), date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        database.getReference("todoList").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        todoList.clear();

                        Log.w("TodoApp", "getUser:onCancelled " + dataSnapshot.toString());
                        Log.w("TodoApp", "count = " + String.valueOf(dataSnapshot.getChildrenCount()) + " values " + dataSnapshot.getKey());
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            ToDo todo = data.getValue(ToDo.class);
                            todoList.add(todo);
                        }

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("TodoApp", "getUser:onCancelled", databaseError.toException());
                    }
                });
    }

    private class RecycleAdapter extends RecyclerView.Adapter {


        @Override
        public int getItemCount() {
            return todoList.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_to_do_list, parent, false);
            SimpleItemViewHolder pvh = new SimpleItemViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            SimpleItemViewHolder viewHolder = (SimpleItemViewHolder) holder;
            viewHolder.position = position;
            ToDo todo = todoList.get(position);
            ((SimpleItemViewHolder) holder).title.setText(todo.getName());
        }

        public final  class SimpleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView title;
            public int position;
            public SimpleItemViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                //title = (TextView) itemView.findViewById(R.id.myRecycleView);
            }

            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(Main_View.this,ToDo.class);
                newIntent.putExtra("todo", todoList.get(position));
                Main_View.this.startActivity(newIntent);

            }
        }

    }*/
}
