package macguffinco.hellrazorbarber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import macguffinco.hellrazorbarber.Activities.Common.MainRun;
import macguffinco.hellrazorbarber.Activities.Login.LoginActivity;
import macguffinco.hellrazorbarber.Logic.TormundManager;
import macguffinco.hellrazorbarber.Model.Branches.CompanyDC;

public class Macguffin_Code_Activity extends AppCompatActivity {
 Button Continuar;
 EditText edit1;
 EditText edit2;
 EditText edit3;
 EditText edit4;
 String texto1="";
 String texto2="";
 String texto3="";
 String texto4="";
 String Code="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macguffin__code_);
        edit1=(EditText)findViewById(R.id.edit1);
        edit2=(EditText)findViewById(R.id.edit2);
        edit3=(EditText)findViewById(R.id.edit3);
        edit4=(EditText)findViewById(R.id.edit4);
        Continuar=(Button)findViewById(R.id.btn_continuar);

        edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                texto1= edit1.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

       edit2.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               texto2= edit2.getText().toString();

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });


       edit3.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               texto3= edit3.getText().toString();

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

       edit4.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {


           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               texto4= edit4.getText().toString();
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
               Continuar.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Code=texto1+texto2+texto3+texto4;

                       if (Code.length() == 4 && (Code.equals("1234") || Code.equals("2345"))) {
                           if (Code.equals("1234")) {
                               CompanyDC company = new CompanyDC();
                               company.Id = 1;
                               TormundManager.GlobalCompany = company;
                           } else if (Code.equals("2345")) {
                               CompanyDC company = new CompanyDC();
                               company.Id = 2;
                               TormundManager.GlobalCompany = company;
                           }
                           TormundManager.goMainScreen(getApplicationContext());
                       } else {
                           Toast.makeText(Macguffin_Code_Activity.this, "Codigo Incorrecto", Toast.LENGTH_SHORT).show();
                       }
                   }
               });

    }
}
