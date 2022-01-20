package com.example.getcurrentlocation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity  {
    EditText loginuser;
    EditText loginpass;
    Button loginbtn;
    TextView logintext;
    DatabseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        db=new DatabseHelper(this);
        loginuser=findViewById(R.id.loginmail);
        loginpass=findViewById(R.id.loginpassword);
        loginbtn=findViewById(R.id.loginbutton);
        logintext=findViewById(R.id.logintext);
        String text="Not Registered Yet?Register Here";
        SpannableString ss=new SpannableString(text);
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent=new Intent(MainActivity1.this,register.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState( TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan,19 ,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        logintext.setText(ss);
        logintext.setMovementMethod(LinkMovementMethod.getInstance());
        loginbtn.setOnClickListener(v -> {
            String user=loginuser.getText().toString().trim();
            String pass=loginpass.getText().toString().trim();
            if(user.isEmpty())
            {
                loginuser.setError("Field can't be empty");
                return;
            }
            if(pass.isEmpty())
            {
                loginpass.setError("Field can't be empty");
                return;
            }
            Boolean res=db.checkuser(user,pass);
            if(res==true)
            {
                Toast.makeText(MainActivity1.this,"Successsfully logged in..",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity1.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(MainActivity1.this,"Error",Toast.LENGTH_SHORT).show();;
            }
        });
    }
}
