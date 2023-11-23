package com.solissa.iansolissa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.solissa.iansolissa.adapter.adapter;
import com.solissa.iansolissa.helper.helper;
import com.solissa.iansolissa.model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class crud1 extends AppCompatActivity {
    ListView listView;
    AlertDialog.Builder dialog;
    List<data>list=new ArrayList<>();
    adapter adapter;
    helper db=new helper(this);
    Button btn_add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud1);

        db=new helper(getApplicationContext());
        btn_add = findViewById(R.id.btn_add2);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crud1.this,crud2.class);
                startActivity(intent);
            }
        });
        listView=findViewById(R.id.list_item2);
        adapter=new adapter(crud1.this,list);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long I) {
                final String id=list.get(i).getId();
                final String name=list.get(i).getName();
                final String email=list.get(i).getEmail();
                final CharSequence[] dialogItem={"edit","hapus"};
                dialog=new AlertDialog.Builder(crud1.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0 : Intent intent = new Intent(crud1.this,crud2.class);
                                intent.putExtra("id", id);
                                intent.putExtra("email", email);
                                intent.putExtra("name", name);
                                startActivity(intent);
                                break;
                            case 1:
                                db.delete(Integer.parseInt(id));
                                list.clear();
                                getData();
//panggil data ulang
                                break;

                        }
                    }
                }).show();
                return false;
            }
        });
        getData();
    }

    private void getData(){
        ArrayList<HashMap<String, String>>rows=db.getall();
        for(int i=0;i<rows.size();i++){
            String id = rows.get(i).get("id");
            String name = rows.get(i).get("name");
            String email = rows.get(i).get("email");
            data Data=new data();
            Data.setId(id);
            Data.setName(name);
            Data.setEmail(email);
            list.add(Data);

        }

        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume(){
        super.onResume();
        list.clear();
        getData();
    }

}