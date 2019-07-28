package sg.edu.np.s10179199k.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Mainboard extends AppCompatActivity {
    NewDbHandler dbHandler;
    Mainboard activity;
    Toolbar dashboard_toolbar;
    RecyclerView rv_dashboard;
    FloatingActionButton fab_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainboard);

        rv_dashboard = findViewById(R.id.recyclerView);
        fab_dashboard = findViewById(R.id.floatingActionButton);
        setSupportActionBar(dashboard_toolbar);
        setTitle("Dashboard");
        activity = this;
        dbHandler = new NewDbHandler(activity);
        rv_dashboard.setLayoutManager(new LinearLayoutManager(activity));


        fab_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
                dialog.setTitle("Add ToDo");
                View view = getLayoutInflater().inflate(R.layout.inside_mainboard, null);
                final EditText toDoName = view.findViewById(R.id.editText9);
                dialog.setView(view);

                dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (toDoName.getText().toString().length() > 0) {
                            NewToDo toDo = new NewToDo();
                            toDo.setName(toDoName.getText().toString());
                            dbHandler.addToDo(toDo);
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
    }

    @Override
    protected void onResume() {
        refreshList();
        super.onResume();
    }

    public void updateToDo(final NewToDo toDo) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle("Update ToDo");
        View view = getLayoutInflater().inflate(R.layout.inside_mainboard, null);
        final EditText toDoName = view.findViewById(R.id.editText9);
        toDoName.setText(toDo.getName());
        dialog.setView(view);
        dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (toDoName.getText().toString().length() > 0) {
                    toDo.setName(toDoName.getText().toString());
                    dbHandler.updateToDo(toDo);
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

    public void refreshList() {
        rv_dashboard.setAdapter(new DashboardAdapter(activity, dbHandler.getToDos()));
    }

    class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
        ArrayList<NewToDo> list;
        Mainboard activity;

        DashboardAdapter(Mainboard activity, ArrayList<NewToDo> list) {
            this.list = list;
            this.activity = activity;
            Log.d("DashboardAdapter", "DashboardAdapter");
            Log.d("DashboardAdapter", "list : " + list.size());
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.inside_recycler_mainboard, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
            holder.toDoName.setText(list.get(i).getName());

            holder.toDoName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  /*  Intent intent = new Intent(activity, MainItem.class);
                    intent.putExtra(INTENT_TODO_ID, list.get(i).getId());
                    intent.putExtra(INTENT_TODO_NAME, list.get(i).getName());
                    activity.startActivity(intent);*/

                    Toast.makeText(Mainboard.this, holder.toDoName.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            /*holder.menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popup = new PopupMenu(activity, holder.menu);
                    popup.inflate(R.menu.mainboard_menu);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                case R.id.menu_edit: {
                                    activity.updateToDo(list.get(i));
                                    break;
                                }
                                case R.id.menu_delete: {
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
                                    dialog.setTitle("Are you sure");
                                    dialog.setMessage("Do you want to delete this task ?");
                                    dialog.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            activity.dbHandler.deleteToDo(list.get(i).getId());
                                            activity.refreshList();
                                        }
                                    });
                                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    dialog.show();
                                }
                                case R.id.menu_mark_as_completed: {
                                    activity.dbHandler.updateToDoItemCompletedStatus(list.get(i).getId(), true);
                                    break;
                                }
                                case R.id.menu_reset: {
                                    activity.dbHandler.updateToDoItemCompletedStatus(list.get(i).getId(), false);
                                    break;
                                }
                            }
                            return true;
                        }
                    });
                    popup.show();
                }
            });*/
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView toDoName;
            //ImageView menu;

            ViewHolder(View v) {
                super(v);
                toDoName = v.findViewById(R.id.textView11);
                //menu = v.findViewById(R.id.imageView4);
            }
        }
    }
}
