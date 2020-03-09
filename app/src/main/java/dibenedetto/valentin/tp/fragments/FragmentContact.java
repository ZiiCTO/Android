package dibenedetto.valentin.tp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dibenedetto.valentin.tp.R;
import dibenedetto.valentin.tp.SecondActivity;
import dibenedetto.valentin.tp.adapters.ContactAdapter;
import dibenedetto.valentin.tp.models.Contact;

public class FragmentContact extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Contact> listContact;

    public FragmentContact() {
        listContact = new ArrayList<>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_contact, container, false);

        recyclerView = view.findViewById(R.id.recycler_contact);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ContactAdapter contactAdapter = new ContactAdapter(getContext(), listContact);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }

    public void setListContact(List<Contact> listContact) {
        this.listContact = listContact;
    }


}
