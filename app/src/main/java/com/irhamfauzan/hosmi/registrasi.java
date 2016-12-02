package com.irhamfauzan.hosmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registrasi extends AppCompatActivity {


    private EditText first_name,last_name, password, email, phone_numb;
    private RequestQueue requestQueue;
    public String insertUrl = "http://192.168.100.11/RumahSakit/insert_Pasien.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phone_numb = (EditText) findViewById(R.id.phone_number);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public void savepasien(View view){
        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Saved");
                Toast.makeText(getApplicationContext(),"Account Saved",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<>();
                parameters.put("first_name",first_name.getText().toString());
                parameters.put("last_name",last_name.getText().toString());
                parameters.put("email",email.getText().toString());
                parameters.put("password",password.getText().toString());
                parameters.put("phone_numb",phone_numb.getText().toString());
                return parameters;
            }
        };
        requestQueue.add(request);
    }
}
