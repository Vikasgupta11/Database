package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText movieName,actorName,actoresName,budget,releaseDate;
    Button addMovie,showData;
    TextView view;
    dbHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieName=(EditText) findViewById(R.id.movie_Name);
        actorName=(EditText) findViewById(R.id.actor_Name);
        actoresName=(EditText) findViewById(R.id.actores_Name);
        budget=(EditText) findViewById(R.id.buget);
        releaseDate=(EditText) findViewById(R.id.release_Date);
        view=(TextView)findViewById(R.id.view);

        addMovie=(Button) findViewById(R.id.addMovie);
        showData=(Button) findViewById(R.id.showData);
dbhelper=new dbHelper(getApplicationContext());





        addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movie_Name=movieName.getText().toString();
                String actor_Name=actorName.getText().toString();
                String actores_Name=actoresName.getText().toString();
                String Budget=budget.getText().toString();
                String release_Date=releaseDate.getText().toString();

                if(movie_Name.isEmpty() || actor_Name.isEmpty() || actor_Name.isEmpty() || Budget.isEmpty() ||
                 release_Date.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter All Values",Toast.LENGTH_SHORT).show();
                }else{

                    dbhelper.addMovies(movie_Name,actor_Name,actores_Name,Budget,release_Date);
                    movieName.setText("");
                    actorName.setText("");
                    actoresName.setText("");
                    budget.setText("");
                    releaseDate.setText("");
                    Toast.makeText(getApplicationContext(),"Movie Added Successfully",Toast.LENGTH_SHORT).show();

                } // End of Else



            }
        });

   showData.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           ArrayList<ArrayList<String>> list=dbhelper.veiwMovies();
           String str="";
             for(ArrayList<String> l:list){
                 str+=l.get(0);
             }

             view.setText(str);
       }
   });

    }
}