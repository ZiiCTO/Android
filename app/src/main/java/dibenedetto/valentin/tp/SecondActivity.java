package dibenedetto.valentin.tp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    final String nameUser = "user_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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


        Intent intent = getIntent();
        String name = intent.getStringExtra(nameUser);

        TextView textView = findViewById(R.id.nameUser);
        textView.setText(intent.getStringExtra(nameUser));

        /** Création du Toast **/
        View layout = getLayoutInflater().inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Hello " + intent.getStringExtra(nameUser) + " !");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchView searchView = findViewById(R.id.search);
        ImageView imageView = searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        imageView.setColorFilter(getResources().getColor(R.color.colorText2), PorterDuff.Mode.SRC_IN);

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

    public boolean updateSearchView(SearchView searchView){
        searchView = findViewById(R.id.search);
        ImageView imageView = searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        imageView.setColorFilter(getResources().getColor(R.color.colorText2), PorterDuff.Mode.SRC_IN);

        return true;
    }

}
