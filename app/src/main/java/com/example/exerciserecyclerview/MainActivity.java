package com.example.exerciserecyclerview;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private LinkedList<String> mWordList = new LinkedList<String>();
    private FloatingActionButton fab;
    private static final String[] mWordListStringArray={"0","1","2","3","4","5","6","7","8","9","10"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        for(int i=0;i<mWordListStringArray.length;i++){
            this.mWordList.add(mWordListStringArray[i]);
        }
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mWordList.add("+ New " + mWordList.size());
                mAdapter.notifyItemInserted(mWordList.size() - 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}