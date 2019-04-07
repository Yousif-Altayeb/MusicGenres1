package com.example.yousif.musicgenres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.yousif.musicgenres.R.id.rock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        // The long way of setting Click Listeners
//        // On click listener for the rock section
//        RockClickListener clickListenerRock = new RockClickListener();
//        TextView rock=(TextView)findViewById(R.id.rock);
//        rock.setOnClickListener( clickListenerRock );

//        The Short way of setting Click Listeners
        TextView rock = (TextView) findViewById(R.id.rock);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), " Open the list of rock", Toast.LENGTH_SHORT).show();


//                long way of setting the intent for starting new activity
//                Intent rockGenre = new Intent(MainActivity.this, RockActivity.class);
//                startActivity(rockGenre);

//                short way of setting the intent for starting new activity
                startActivity(new Intent(MainActivity.this, RockActivity.class));
            }
        });





        // The long way of setting Click Listeners
        // On click listener for the Jazz section          the long way
//        JazzClickListener clickListenerJazz = new JazzClickListener();
//        TextView jazz = (TextView) findViewById(R.id.jazz);
//        jazz.setOnClickListener(clickListenerJazz);

//        The Short way of setting Click Listeners
        TextView jazz = (TextView) findViewById(R.id.jazz);
        jazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), " Opent the list of Jazz", Toast.LENGTH_SHORT).show();

//                long way of setting the intent for starting new activity
//                Intent jazzGenre = new Intent(MainActivity.this, JazzActivity.class);
//                startActivity(jazzGenre);

//                short way of setting the intent for starting new activity
                startActivity(new Intent(MainActivity.this, JazzActivity.class));

            }
        });


        // The long way of setting Click Listeners
        // On click listener for the Classical section
//        ClassicalClickListener clickListenerClassical = new ClassicalClickListener();
//        TextView classical = (TextView) findViewById(R.id.classical);
//        classical.setOnClickListener(clickListenerClassical);


        //        The Short way of setting Click Listeners
        TextView classical = (TextView) findViewById(R.id.classical);
        classical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Open the List of Classical", Toast.LENGTH_SHORT).show();

//                long way of setting the intent for starting new activity
//                Intent classicalGenre = new Intent(MainActivity.this, ClassicalActivity.class);
//                startActivity(classicalGenre);

//                short way of setting the intent for starting new activity
                startActivity(new Intent(MainActivity.this, ClassicalActivity.class));
            }
        });

//        The Long way of setting the Click Listener
        // On click listener for the Country section
//        CountryClickListener clickListenerCountry = new CountryClickListener();
//        TextView country = (TextView) findViewById(R.id.country);
//        country.setOnClickListener(clickListenerCountry);
//    }

//    The Short way of setting the Click Listener
        TextView country = (TextView) findViewById(R.id.country);
        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Opent the List of Country", Toast.LENGTH_SHORT).show();

//                long way of setting the intent for starting new activity
//                Intent countryGenre = new Intent(MainActivity.this, CountryActivity.class);
//                startActivity(countryGenre);

//                short way of setting the intent for starting new activity
                startActivity(new Intent(MainActivity.this, CountryActivity.class));
            }
        });


//    public  void goToRock(View view){
//        Toast.makeText(this,"Enjoy listening to Rock Music", Toast.LENGTH_LONG ).show();
//    }

    }
}
