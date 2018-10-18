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

public class SignUp extends AppCompatActivity {
    Button b3,b4;//decl button
    EditText e3,e4,e5;//declaration of  widgets text field
    String s3,s4,s5;//decl string of texts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignUp.this,MainActivity.class);
                startActivity(i);//instance variable
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                SQLiteDatabase data=openOrCreateDatabase("d",MODE_PRIVATE,null);
                data.execSQL("create table if not exists camp(name varchar, password varchar, email varchar");
                String s="select * from camp where name='"+s3+"' and password='"+s4+"'";
                Cursor c=data.rawQuery(s,null);
                if(c.getCount()>0)
                {
                    Toast.makeText(SignUp.this, "user exists", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(SignUp.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(SignUp.this, "database updated", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(SignUp.this,First.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }
}
