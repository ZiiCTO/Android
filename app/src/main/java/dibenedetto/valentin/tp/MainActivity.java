package dibenedetto.valentin.tp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String nameUser = "user_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */


        /** Je localise mon EditText en fonction de son id **/
        final EditText name = findViewById(R.id.name);

        /** Pareil pour le bouton **/
        Button button = findViewById(R.id.boutonConfirmation);

        /** Je crée une action sur le bouton récupéré **/
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!name.getText().toString().isEmpty()) {
                    /** Je passe de la MainActivity à SecondActivity ... **/
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    /** ... en transférant la valeur rentrée par l'utilisateur dans l'EditText ... **/
                    intent.putExtra(nameUser, name.getText().toString());

                    /** ... et je démarre la SecondActivity **/
                    startActivity(intent);
                }
            }
        });

        /** Création du Toast **/
        View layout = getLayoutInflater().inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Bonjour !");

        Toast toast =new Toast(getApplicationContext());
        //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    
    public void secondActivity(View view){
        startActivity(new Intent(this, SecondActivity.class));
    }
/*
    @Override
    public void onClick(View v) {
        String name = tp.getText().toString();
        System.out.println(name);
    }*/

    //https://www.youtube.com/watch?v=dBCOhaEsiiU
}
