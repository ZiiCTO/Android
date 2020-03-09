package dibenedetto.valentin.tp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import dibenedetto.valentin.tp.adapters.ViewPagerAdapter;
import dibenedetto.valentin.tp.fragments.FragmentContact;
import dibenedetto.valentin.tp.fragments.FragmentDetailContact;
import dibenedetto.valentin.tp.fragments.FragmentFav;
import dibenedetto.valentin.tp.models.Contact;

public class SecondActivity extends AppCompatActivity {
    private final String NAME_USER = "user_name";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Contact> listContact = new ArrayList<>();
    private final int[] ICONS = {R.drawable.ic_group_white_24dp, R.drawable.ic_star_white_24dp, R.drawable.ic_contact_phone_white_24dp};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        /** Récupérer les infos de la main activity **/
        Intent intent = getIntent();
        String name = intent.getStringExtra(NAME_USER);

        //TextView textView = findViewById(R.id.nameUser);
        //textView.setText(intent.getStringExtra(NAME_USER));

        /** Création du Toast **/
        View layout = getLayoutInflater().inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Hello " + intent.getStringExtra(NAME_USER) + " !");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        initData();

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(ICONS[i]);
        }

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FragmentContact fragmentContact = new FragmentContact();
        fragmentContact.setListContact(listContact);

        FragmentDetailContact fragmentDetailContact = new FragmentDetailContact();
        fragmentDetailContact.setListContact(listContact);

        FragmentFav fragmentFav = new FragmentFav();
        fragmentFav.setListContact(listContact);

        adapter.addItem(fragmentContact, "Contacts");
        adapter.addItem(fragmentFav, "Favoris");
        adapter.addItem(fragmentDetailContact, "Détails");
        viewPager.setAdapter(adapter);
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

    /*
    public boolean updateSearchView(SearchView searchView){
        searchView = findViewById(R.id.search);
        ImageView imageView = searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        imageView.setColorFilter(getResources().getColor(R.color.colorText2), PorterDuff.Mode.SRC_IN);

        return true;
    }
    */



    private void initData() {
        Contact contact = new Contact("Gauser", "Aifekan", 0100000000, "prenom1@gmail.com", "ville1");
        listContact.add(contact);

        contact = new Contact("Massnain", "Tib",0200000000, "prenom2@gmail.com", "ville2");
        listContact.add(contact);

        contact = new Contact("Bjart", "Kvin",0300000000, "prenom3@gmail.com", "ville3");
        listContact.add(contact);

        contact = new Contact("Suslek", "Aymeric",0400000000, "prenom4@gmail.com", "ville4");
        listContact.add(contact);

        contact = new Contact("Hène", "Alex", 0500000000, "prenom5@gmail.com", "ville5");
        listContact.add(contact);

        contact = new Contact("test6", "prenom6", 0600000000, "prenom6@gmail.com", "ville6");
        listContact.add(contact);

        contact = new Contact("test7", "prenom7", 0700000000, "prenom7@gmail.com", "ville7");
        listContact.add(contact);

        contact = new Contact("test8", "prenom8", 00000001, "prenom8@gmail.com", "ville8");
        listContact.add(contact);

        contact = new Contact("test9", "prenom9", 000000002, "prenom9@gmail.com", "ville9");
        listContact.add(contact);

        contact = new Contact("test10", "prenom10", 1000000000, "prenom10@gmail.com", "ville10");
        listContact.add(contact);

    }

}
