package com.learning.mavericksapp;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NameItem> namesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NamesListAdapter namesListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        namesListAdapter = new NamesListAdapter(namesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(namesListAdapter);
        prepareMovieData();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddNameDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void prepareMovieData() {
        NameItem nameItem = new NameItem("Mehroz","Munir");
        namesList.add(nameItem);
         nameItem = new NameItem("Johnny","Depp");
        namesList.add(nameItem);
         nameItem = new NameItem("Zara","Ahmed");
        namesList.add(nameItem);
         nameItem = new NameItem("Christian","Bale");
        namesList.add(nameItem);
         nameItem = new NameItem("Ayesha","Tariq");
        namesList.add(nameItem);
         nameItem = new NameItem("Muhammad","Ali");
        namesList.add(nameItem);
         nameItem = new NameItem("Tom","Hanks");
        namesList.add(nameItem);
         nameItem = new NameItem("Matt","Damon");
        namesList.add(nameItem);
        namesListAdapter.notifyDataSetChanged();
    }


    private void showAddNameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.add_name, null);
        alert.setView(dialogView);
        alert.setCancelable(false);
        final EditText etFname,etLname;
        etFname = (EditText) dialogView.findViewById(R.id.et_fname);
        etLname = (EditText) dialogView.findViewById(R.id.et_lname);

        alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (etFname.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "First Name cannot be empty",Toast.LENGTH_LONG).show();
                else if (etLname.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "Last Name cannot be empty",Toast.LENGTH_LONG).show();
                else {
                    NameItem nameItem = new NameItem(etFname.getText().toString(),etLname.getText().toString());
                    namesList.add(nameItem);
                    namesListAdapter.notifyDataSetChanged();
                }
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.show();
    }
}
