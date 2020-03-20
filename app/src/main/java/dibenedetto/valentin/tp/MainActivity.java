package dibenedetto.valentin.tp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.preference.PreferenceManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String NAME_USER = "user_name";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String tmp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (sharedPreferences.contains("NOM")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {

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
                        intent.putExtra(NAME_USER, name.getText().toString());
                        tmp = name.getText().toString();

                        editor = sharedPreferences.edit();
                        editor.putString("NOM", tmp);
                        editor.commit();

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

    //https://www.youtube.com/watch?v=dBCOhaEsiiU


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //sharedPreferences.edit().clear().commit();
    }
}
