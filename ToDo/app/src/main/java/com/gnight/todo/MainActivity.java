package com.gnight.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText note, description, number;
    Button insert, show, delete;
    String deleteUrl = "http://mzpsib.ru/php/deleteNote.php";
    String insertUrl = "http://mzpsib.ru/php/insertNote.php";
    String showUrl = "http://mzpsib.ru/php/showNotes.php";
    TextView result;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = (EditText) findViewById(R.id.editText);
        description = (EditText) findViewById(R.id.editText2);
        number = (EditText) findViewById(R.id.editText3);
        insert = (Button) findViewById(R.id.insert);
        show = (Button) findViewById(R.id.show);
        delete = (Button) findViewById(R.id.delete);
        result = (TextView) findViewById(R.id.result);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        showUrl, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray notes = response.getJSONArray("notes");
                            for (int i=0; i<notes.length(); i++){
                                JSONObject note = notes.getJSONObject(i);

                                String id = note.getString("id");
                                String note1 = note.getString("note");
                                String description = note.getString("description");
                                String datetime = note.getString("datetime");

                                result.append(id + " : " + note1 + " - " + description + " | " + datetime + "\n");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("note",note.getText().toString());
                        parameters.put("description",description.getText().toString());
                        return parameters;
                    }
                };
                requestQueue.add(request);
                show.callOnClick();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, deleteUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("id",number.getText().toString());
                        return parameters;
                    }
                };
                requestQueue.add(request);
                show.callOnClick();
            }
        });

    }
}
