package sg.edu.np.s10179199k.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static sg.edu.np.s10179199k.myapplication.inDB.INTENT_TODO_ID;

public class MainItem extends AppCompatActivity {
    //Toolbar item_toolbar;
    RecyclerView rv_item;
    FloatingActionButton fab_item;

    long todoId = -1;
    MainItem activity;
    NewDbHandler dbHandler;

    ItemTouchHelper touchHelper;

    ItemAdapter adapter;

    ArrayList<NewItemToDo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__view);

        setTitle("lifeNote items");

        rv_item = findViewById(R.id.rvmainview);
        fab_item = findViewById(R.id.mvfab);




        todoId = getIntent().getLongExtra(INTENT_TODO_ID, -1);
        activity = this;
        dbHandler = new NewDbHandler(activity);
        rv_item.setLayoutManager(new LinearLayoutManager(activity));

        fab_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(activity);


                dialog.setTitle("Add Event");
                View view = getLayoutInflater().inflate(R.layout.inside_mainboard, null);
                final EditText toDoName = view.findViewById(R.id.etinmain);
                dialog.setView(view);
                dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (toDoName.getText().toString().length() > 0) {
                            NewItemToDo item = new NewItemToDo();
                            item.setItemName(toDoName.getText().toString());
                            item.setToDoId(todoId);
                            item.setCompleted(false);
                            dbHandler.addToDoItem(item);
                            refreshList();
                        }
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
        touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder p1, @NonNull RecyclerView.ViewHolder p2) {

                int sourcePosition = p1.getAdapterPosition();
                int targetPosition = p2.getAdapterPosition();
                Collections.swap(list, sourcePosition, targetPosition);
                adapter.notifyItemMoved(sourcePosition, targetPosition);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }
        });

        touchHelper.attachToRecyclerView(rv_item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        refreshList();
        super.onResume();
    }

    void refreshList() {
        list = dbHandler.getToDoItems(todoId);
        adapter = new ItemAdapter(activity);
        rv_item.setAdapter(adapter);
    }


    void updateItem(final NewItemToDo item) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle("Change Item");
        View view = getLayoutInflater().inflate(R.layout.inside_mainboard, null);
        final EditText toDoName = view.findViewById(R.id.etinmain);
        toDoName.setText(item.getItemName());
        dialog.setView(view);
        dialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (toDoName.getText().toString().length() > 0) {
                    item.setItemName(toDoName.getText().toString());
                    item.setToDoId(todoId);
                    item.setCompleted(false);
                    dbHandler.updateToDoItem(item);
                    refreshList();
                }
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }


    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
        MainItem activity;

        ItemAdapter(MainItem activity) {
            this.activity = activity;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.inside_main_item, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
            holder.itemName.setText(list.get(i).getItemName());
            //holder.itemName.setChecked(list.get(i).isCompleted());
            /*holder.itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.get(i).setCompleted(!list.get(i).isCompleted());
                    activity.dbHandler.updateToDoItem(list.get(i));
                }
            });*/
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(activity);

                    dialog.setMessage("Do you want to delete this item ?");

                    dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int pos) {

                            activity.dbHandler.deleteToDoItem(list.get(i).getId());

                            activity.refreshList();
                        }
                    });
                    dialog.show();
                    dialog.show();
                }
            });

            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.updateItem(list.get(i));
                }
            });


        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView itemName;
            ImageView edit;
            ImageView delete;


            ViewHolder(View v) {
                super(v);
                itemName = v.findViewById(R.id.tvinsidemain);
                edit = v.findViewById(R.id.imageView5);
                delete = v.findViewById(R.id.imageView6);


            }
        }
    }

}
