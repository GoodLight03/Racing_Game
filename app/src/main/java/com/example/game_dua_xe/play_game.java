package com.example.game_dua_xe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class play_game extends AppCompatActivity {
    EditText datcoc, nameuser;
    TextView txttien;
    CheckBox cbone,cbtwo,cbthree,cbfor,cbfive;
    SeekBar sbone,sbtwo,sbthree,sbfor,sbfive;
    ImageView startgame,nhanqua;
    int tien;
    int tiencoc;
    int REQUEST_CODE=123;
    SharedPreferences luuSotien;
    CountDownTimer countDownTimer;
    Button plnext, plpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        anhxa();

        luuSotien = getSharedPreferences("luuDiem", MODE_PRIVATE);

        Intent it=getIntent();
        Bundle bundle=it.getBundleExtra("sotien");
        if(bundle!=null){
            tien=(int)bundle.get("tien");
            luuTien();
        }else {
            tien = luuSotien.getInt("Tien", 300);
        }
        datcoc.setEnabled(true);
        sbone.setEnabled(false);
        sbtwo.setEnabled(false);
        sbthree.setEnabled(false);
        sbfor.setEnabled(false);
        sbfive.setEnabled(false);

        txttien.setText(tien+"$");


        countDownTimer=new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
//                int number=5;
//                Random random=new Random();
//                int one= random.nextInt(number);
//                int two= random.nextInt(number);
//                int thr= random.nextInt(number);
//                int fov= random.nextInt(number);
//                int five= random.nextInt(number);

                if(sbone.getProgress()>=sbone.getMax()){
                   this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    if(cbone.isChecked()){
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                            tien-=tiencoc;
                            if(tien==0){
                                Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                                luuTien();
                            }else{
                                luuTien();
                                Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                        }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }

                if(sbtwo.getProgress()>=sbtwo.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    if(cbtwo.isChecked()){
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                        tien-=tiencoc;
                            if(tien==0){
                                Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                                luuTien();
                            }else{
                                luuTien();
                                Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }

                if(sbthree.getProgress()>=sbthree.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    if(cbthree.isChecked()){
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                            tien-=tiencoc;
                            if(tien==0){
                                Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                                luuTien();
                            }else{
                                luuTien();
                                Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                        }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }

                if(sbfor.getProgress()>=sbfor.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    if(cbfor.isChecked()){
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{

                            tien-=tiencoc;
                            if(tien==0){
                                Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                                luuTien();
                            }else{
                                luuTien();
                                Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();
                        }}
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }

                if(sbfive.getProgress()>=sbfive.getMax()){
                    this.cancel();
                    startgame.setVisibility(View.VISIBLE);
                    datcoc.setEnabled(true);
                    if(cbfive.isChecked()){
                        tien+=tiencoc;
                        luuTien();
                        Toast.makeText(play_game.this,"Bạn đoán đúng",Toast.LENGTH_SHORT).show();
                    }else{
                            tien-=tiencoc;
                            if(tien==0){
                                Toast.makeText(play_game.this,"Bạn đã hất tiền...Hãy mở quà",Toast.LENGTH_SHORT).show();
                                luuTien();
                            }else{
                                luuTien();
                                Toast.makeText(play_game.this,"Bạn đoán sai",Toast.LENGTH_SHORT).show();}
                    }
                    txttien.setText(tien+"$");
                    EnableCheckBox();
                }

//                sbone.setProgress(sbone.getProgress()+one);
//                sbtwo.setProgress(sbtwo.getProgress()+two);
//                sbthree.setProgress(sbthree.getProgress()+thr);
//                sbfor.setProgress(sbfor.getProgress()+fov);
//                sbfive.setProgress(sbfive.getProgress()+five);
                chay();
            }

            @Override
            public void onFinish() {

            }
        };

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=datcoc.getText().toString();
                try{
                    tiencoc=Integer.parseInt(a);
                }
                catch (Exception e){

                };

                if(cbone.isChecked()||cbtwo.isChecked()||cbthree.isChecked()||cbfor.isChecked()||cbfive.isChecked()){
                    if(a.equals("")){
                        Toast.makeText(play_game.this,"Vui lòng đặt cược trước khi chơi",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(tiencoc>tien||tiencoc==0){
                            Toast.makeText(play_game.this,"Tiền cược chưa hợp lệ",Toast.LENGTH_SHORT).show();
                        }else{
                            if(sbone.getProgress()>=sbone.getMax()
                            ||sbtwo.getProgress()>=sbtwo.getMax()
                            ||sbthree.getProgress()>=sbthree.getMax()
                            ||sbfor.getProgress()>=sbfor.getMax()
                            ||sbfive.getProgress()>=sbfive.getMax()) {
                                sbone.setProgress(0);
                                sbtwo.setProgress(0);
                                sbthree.setProgress(0);
                                sbfor.setProgress(0);
                                sbfive.setProgress(0);
                            }else{
                                sbone.setProgress(sbone.getProgress());
                                sbtwo.setProgress(sbtwo.getProgress());
                                sbthree.setProgress(sbthree.getProgress());
                                sbfor.setProgress(sbfor.getProgress());
                                sbfive.setProgress(sbfive.getProgress());
                            }

                        startgame.setVisibility(View.INVISIBLE);
                        countDownTimer.start();
                        DisableCheckBox();
                        datcoc.setEnabled(false);
                        }
                    }
                }
                else {
                    Toast.makeText(play_game.this,"Vui lòng chọn xe trước khi chơi",Toast.LENGTH_SHORT).show();
                }
            }
        });

        plpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbone.isChecked()){
                    sbone.setProgress(sbone.getProgress()-5);

                }
                if(cbtwo.isChecked()){
                    sbtwo.setProgress(sbtwo.getProgress()-5);

                }
                if(cbthree.isChecked()){
                    sbthree.setProgress(sbthree.getProgress()-5);

                }
                if(cbfor.isChecked()){
                    sbtwo.setProgress(sbtwo.getProgress()-5);

                }
                if(cbfive.isChecked()){
                    sbtwo.setProgress(sbtwo.getProgress()-5);

                }
            }
        });

        plnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbone.isChecked()){
                    sbone.setProgress(sbone.getProgress()+5);

                }
                if(cbtwo.isChecked()){
                    sbtwo.setProgress(sbtwo.getProgress()+5);

                }
                if(cbthree.isChecked()){
                    sbthree.setProgress(sbthree.getProgress()+5);

                }
                if(cbfor.isChecked()){
                    sbtwo.setProgress(sbtwo.getProgress()+5);

                }
                if(cbfive.isChecked()){
                    sbtwo.setProgress(sbtwo.getProgress()+5);

                }
            }
        });

        nhanqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tien!=0){
                    Toast.makeText(play_game.this,"Bạn vẫn còn tiền",Toast.LENGTH_SHORT).show();
                }else{
                Intent it=new Intent(play_game.this,open_box_gif.class);
                startActivityForResult(it, REQUEST_CODE);}
            }
        });
        cbone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                    cbfor.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbtwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbone.setChecked(false);
                    cbthree.setChecked(false);
                    cbfor.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbone.setChecked(false);
                    cbfor.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbfor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                    cbone.setChecked(false);
                    cbfive.setChecked(false);
                }
            }
        });
        cbfive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                    cbfor.setChecked(false);
                    cbone.setChecked(false);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE&&resultCode==RESULT_OK&&data!=null){
            tien=data.getIntExtra("tienthuong",0);
            txttien.setText(tien+"$");
            luuTien();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void chay(){
        int number=5;
        Random random=new Random();
        int one= random.nextInt(number);
        int two= random.nextInt(number);
        int thr= random.nextInt(number);
        int fov= random.nextInt(number);
        int five= random.nextInt(number);
        if(cbone.isChecked()){
            sbone.setTransitionName(nameuser.getText().toString()+"");
            sbtwo.setProgress(sbtwo.getProgress()+two);
            sbthree.setProgress(sbthree.getProgress()+thr);
            sbfor.setProgress(sbfor.getProgress()+fov);
            sbfive.setProgress(sbfive.getProgress()+five);
        }
        if(cbtwo.isChecked()){

            sbone.setProgress(sbone.getProgress()+two);
            sbthree.setProgress(sbthree.getProgress()+thr);
            sbfor.setProgress(sbfor.getProgress()+fov);
            sbfive.setProgress(sbfive.getProgress()+five);
        }
        if(cbthree.isChecked()){
            sbtwo.setProgress(sbtwo.getProgress()+two);
            sbone.setProgress(sbone.getProgress()+two);
            sbfor.setProgress(sbfor.getProgress()+fov);
            sbfive.setProgress(sbfive.getProgress()+five);
        }
        if(cbfor.isChecked()){
            sbtwo.setProgress(sbtwo.getProgress()+two);
            sbthree.setProgress(sbthree.getProgress()+thr);
            sbone.setProgress(sbone.getProgress()+two);
            sbfive.setProgress(sbfive.getProgress()+five);
        }
        if(cbfive.isChecked()){
            sbtwo.setProgress(sbtwo.getProgress()+two);
            sbthree.setProgress(sbthree.getProgress()+thr);
            sbfor.setProgress(sbfor.getProgress()+fov);
            sbone.setProgress(sbone.getProgress()+two);
        }
    }

    private void EnableCheckBox(){
        cbone.setEnabled(true);
        cbtwo.setEnabled(true);
        cbthree.setEnabled(true);
        cbfor.setEnabled(true);
        cbfive.setEnabled(true);
    }

    private void DisableCheckBox(){
        cbone.setEnabled(false);
        cbtwo.setEnabled(false);
        cbthree.setEnabled(false);
        cbfor.setEnabled(false);
        cbfive.setEnabled(false);
    }

    private void luuTien(){
        SharedPreferences.Editor editor=luuSotien.edit();
        editor.putInt("Tien",tien);
        editor.commit();
    }

    private void anhxa(){
        nhanqua=(ImageView)findViewById(R.id.gifbox);
        txttien=(TextView)findViewById(R.id.diem) ;
        datcoc=(EditText)findViewById(R.id.datcoc) ;
        startgame =(ImageView)findViewById(R.id.startgame);;
        cbone=(CheckBox) findViewById(R.id.checkBoxone);
        cbtwo=(CheckBox) findViewById(R.id.checkBoxtwo);
        cbthree=(CheckBox) findViewById(R.id.checkBoxthree);
        cbfor=(CheckBox) findViewById(R.id.checkBoxfor);
        cbfive=(CheckBox) findViewById(R.id.checkBoxfive);
        sbone=(SeekBar) findViewById(R.id.seekBarone);
        sbtwo=(SeekBar) findViewById(R.id.seekBartwo);
        sbthree=(SeekBar) findViewById(R.id.seekBarthree);
        sbfor=(SeekBar) findViewById(R.id.seekBarfor);
        sbfive=(SeekBar) findViewById(R.id.seekBarfive);
        plnext=(Button) findViewById(R.id.buttonnext);
        plpre=(Button) findViewById(R.id.buttonpre);
        nameuser=(EditText) findViewById(R.id.nameuser);
    }


}