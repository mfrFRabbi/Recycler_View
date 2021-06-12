package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] country_name,country_desc;
    MyAdapter myAdapter;

    final int[] IMAGES = {R.drawable.afg,R.drawable.australia,R.drawable.bd,R.drawable.bhutan,R.drawable.china,R.drawable.germany,
            R.drawable.india,R.drawable.iran,R.drawable.iraq,R.drawable.japan,R.drawable.malaysia,R.drawable.nepal,
            R.drawable.pak,R.drawable.saudiarabia};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerviewId);

        country_name = getResources().getStringArray(R.array.country_name);
        country_desc = getResources().getStringArray(R.array.country_desc);

        myAdapter = new MyAdapter(this,IMAGES,country_name,country_desc);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Toast.makeText(getBaseContext(),"clicked "+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClickListener(View v, int position) {
                Toast.makeText(getBaseContext(),"Long clicked "+position,Toast.LENGTH_LONG).show();
            }
        });


    }
}