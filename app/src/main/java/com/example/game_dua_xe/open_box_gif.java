package com.example.game_dua_xe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class open_box_gif extends AppCompatActivity {

    GridView gvbox;
    ArrayList<box>arrbox;
    boxAdapter adapter;
    int tienthuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_box_gif);

        anhxa();

        adapter=new boxAdapter(this,R.layout.inline_box,arrbox);
        gvbox.setAdapter(adapter);
        gvbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Random random=new Random();
                tienthuong=random.nextInt(200)+100;

                arrbox.get(i).setGiatri(tienthuong+"");
                arrbox.get(i).setHinh(R.drawable.gifopen);
                adapter.notifyDataSetChanged();

                AlertDialog.Builder builder=
                        new AlertDialog.Builder(open_box_gif.this);
                builder.setMessage("Chúc mừng bạn đã nhận được "+tienthuong+"$")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent it=new Intent();
                                it.putExtra("tienthuong",tienthuong);
                                setResult(RESULT_OK,it);
                                finish();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void anhxa() {
        gvbox=(GridView) findViewById(R.id.listbox);
        arrbox=new ArrayList<>();
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
        arrbox.add(new box(R.drawable.gifclose,"OPEN"));
    }
}