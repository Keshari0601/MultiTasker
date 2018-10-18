package com.example.dell.multitasker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                    Toast.makeText(MainActivity.this, "fill blanks to login", Toast.LENGTH_SHORT).show();
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("d",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists camp(name varchar, password varchar, email varchar");
                    String s3="select * from camp where name='"+s1+"' and password='"+s2+"'";
                    Cursor c=data.rawQuery(s3,null);
                    if(c.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,First.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "wrong user", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
                finish();
            }
        });
    }
}
