package dibenedetto.valentin.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import dibenedetto.valentin.tp.models.Contact;

public class ThirdActivity extends AppCompatActivity {
    private final String LASTNAME_USER = "user_lastname";
    private final String FIRSTNAME_USER = "user_firstname";
    private final String EMAIL_USER = "user_email";
    private final String MOBILE_USER = "user_mobile";
    private final String CITY_USER = "user_city";
    private final String FAV_USER = "user_fav";
    private List<Contact> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final EditText lastname = findViewById(R.id.cr_et_nom);
        final EditText firstname = findViewById(R.id.cr_et_prenom);
        final EditText email = findViewById(R.id.cr_et_mail);
        final EditText mobile = findViewById(R.id.cr_et_mobile);
        final EditText city = findViewById(R.id.cr_et_ville);
        final CheckBox fav = findViewById(R.id.cr_cb_fav);

        Button button = findViewById(R.id.b_cr_confirm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                intent.putExtra(LASTNAME_USER, lastname.getText().toString());
                intent.putExtra(FIRSTNAME_USER, firstname.getText().toString());
                intent.putExtra(EMAIL_USER, email.getText().toString());
                intent.putExtra(MOBILE_USER, mobile.getText().toString());
                intent.putExtra(CITY_USER, city.getText().toString());
                startActivity(intent);
            }
        });

    }
}
