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
import dibenedetto.valentin.tp.adapters.DetailAdapter;
import dibenedetto.valentin.tp.models.Contact;

public class FragmentDetailContact extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Contact> listContact;
    
    public FragmentDetailContact() {
        listContact = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_detail_contact, container, false);

        recyclerView = view.findViewById(R.id.recycler_detail_contact);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DetailAdapter detailAdapter = new DetailAdapter(getContext(), listContact);
        recyclerView.setAdapter(detailAdapter);

        return view;
    }

    public void setListContact(List<Contact> listContact) {
        this.listContact = listContact;
    }
}
