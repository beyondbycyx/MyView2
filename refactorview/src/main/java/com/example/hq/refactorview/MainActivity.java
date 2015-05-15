package com.example.hq.refactorview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {

    private MyListView myListView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        myListView=(MyListView)findViewById(R.id.mlv);
        ListAdapter listAdapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.tv,list);
        myListView.setAdapter(listAdapter);
    }
    public void initDatas()
    {
        list=new ArrayList<String>();
        for(char c='A';c<='Z';c++)
        {
            list.add(c+"");
        }
    }
}
