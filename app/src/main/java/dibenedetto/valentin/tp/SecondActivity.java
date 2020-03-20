package dibenedetto.valentin.tp;

import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
    private List<Contact> listFav = new ArrayList<>();
    private final int[] ICONS = {R.drawable.ic_group_white_24dp, R.drawable.ic_star_white_24dp, R.drawable.ic_contact_phone_white_24dp};
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        /** Récupérer les infos de la main activity **/
//        Intent intent = getIntent();
//        String name = intent.getStringExtra(NAME_USER);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sharedPreferences.getString("NOM", "" );

        //TextView textView = findViewById(R.id.nameUser);
        //textView.setText(intent.getStringExtra(NAME_USER));

        /** Création du Toast **/
        View layout = getLayoutInflater().inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Hello " + name + " !");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        initData();
        trieData();

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(ICONS[i]);
            tab.getIcon().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        }

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        FragmentContact fragmentContact = new FragmentContact();
        fragmentContact.setListContact(listContact);

        FragmentDetailContact fragmentDetailContact = new FragmentDetailContact();
        //fragmentDetailContact.setListContact(listContact);

        FragmentFav fragmentFav = new FragmentFav();
        //fragmentFav.setListContact(listContact);

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
        Contact contact = new Contact("Gocer", "Efekan", 0100000000, "efekan@gmail.com", "Quiévrechain");
        listContact.add(contact);

        contact = new Contact("Masnin", "Thibaut",0200000000, "thibaut@gmail.com", "Hellemmes");
        listContact.add(contact);

        contact = new Contact("Bajard", "Kévin",0300000000, "kevin@gmail.com", "Crespin");
        listContact.add(contact);

        contact = new Contact("Sulek", "Aymeric",0400000000, "aymeric@gmail.com", "Maubeuge");
        listContact.add(contact);

        contact = new Contact("Haine", "Alexis", 0500000000, "alexis@gmail.com", "Maubeuge");
        listContact.add(contact);

        contact = new Contact("Egret", "Guillaume", 0600000000, "guillaume@gmail.com", "Maubeuge");
        listContact.add(contact);

        contact = new Contact("Lequeux", "Maxence", 0700000000, "maxence@gmail.com", "Maubeuge");
        listContact.add(contact);

        contact = new Contact("Deboosère", "Amine", 00000001, "amine@gmail.com", "Roubaix");
        listContact.add(contact);

        contact = new Contact("Dupont", "Jean", 000000002, "jean@gmail.com", "Valenciennes");
        listContact.add(contact);

        contact = new Contact("Pons", "Alex", 1000000000, "alex0@gmail.com", "Sebourg");
        listContact.add(contact);

    }

    public List<Contact> trieData() {
        Contact[] listTemp = new Contact[listContact.size()];

        for (int i = 0 ; i < listContact.size(); i++){
            listTemp[i] = listContact.get(i);
        }

        Comparator comp = new Comparator() {
            public int compare(Object o1, Object o2) {
                Contact c1 = (Contact) o1;
                Contact c2 = (Contact) o2;
                return c1.getNom().compareToIgnoreCase(c2.getNom());
            }
        };

        Arrays.sort(listTemp, comp);

        for (int j = 0 ; j < listTemp.length ; j++){
            listContact.set(j, listTemp[j]);
        }

        return listContact;
    }

//    public void setFav() {
//        final Button b = (Button) findViewById(R.id.button_fav_ic);
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Drawable dr = getResources().getDrawable(R.drawable.ic_star_fav_24dp);
//                b.setBackground(dr);
//            }
//        });
//    }

}
