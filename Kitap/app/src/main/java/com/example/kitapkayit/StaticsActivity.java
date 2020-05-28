package com.example.kitapkayit;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;

import java.util.List;

public class StaticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics);
        GraphView graph = (GraphView) findViewById(R.id.graph);

    }

}
