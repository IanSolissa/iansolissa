package com.solissa.iansolissa;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.solissa.iansolissa.helper.helper;


public class login extends AppCompatActivity {
    public EditText editname,editemail;
   public Button btnsave;
    public helper db=new helper(this);

  public String name,email,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        tombollogin.mencariid();
        editname = findViewById(R.id.edittextemail);
        editemail = findViewById(R.id.edittextpass);
        btnsave = findViewById(R.id.btnsave);
        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        if (id == null || id.equals("")) {
            setTitle("Login");
        } else {
            setTitle("Edit User");
            editname.setText(name);
            editemail.setText(email);
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (id == null || id.equals("")) {
                        save();
                        Intent intent;
                        intent = new Intent(login.this , navigasi.class);
                        startActivity(intent);
                    } else {

                        edit();
                    }
                } catch (Exception e) {
                    Log.e("saving", e.getMessage());

                }




            }
        });
    }


//
////      memanggil fungsi klick pada clas tombolbtn
//tombollogin.klick();


private void save() {
    if (String.valueOf(editname.getText()).equals("") || String.valueOf(editemail.getText()).equals("")) {
Toast.makeText(getApplicationContext(),"silahkan isi data ",Toast.LENGTH_SHORT).show();
    }else{
        db.insert(editname.getText().toString(),editemail.getText().toString());
    finish();
    }

}

    private void edit() {
        if (String.valueOf(editname.getText()).equals("") || String.valueOf(editemail.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),"silahkan isi data ",Toast.LENGTH_SHORT).show();
        }else{
            db.update(Integer.parseInt(id),editname.getText().toString(),editemail.getText().toString());
        finish();
        }

    }

}





