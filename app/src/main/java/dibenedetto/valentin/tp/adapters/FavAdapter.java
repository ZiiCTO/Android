package dibenedetto.valentin.tp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dibenedetto.valentin.tp.R;
import dibenedetto.valentin.tp.models.Contact;
import dibenedetto.valentin.tp.views.ViewHolderDetailContact;
import dibenedetto.valentin.tp.views.ViewHolderFav;

public class FavAdapter extends RecyclerView.Adapter<ViewHolderFav> {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<Contact> listContact;

    public FavAdapter(Context context, List<Contact> listContact) {
        this.context = context;
        this.listContact = listContact;
    }


    @NonNull
    @Override
    public ViewHolderFav onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = layoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.items_favs, parent, false);

        ViewHolderFav viewHolderFav = new ViewHolderFav(view);

        return viewHolderFav;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFav holder, int position) {
        TextView nom, prenom;

        nom = holder.nom;
        prenom = holder.prenom;

        nom.setText(listContact.get(position).getNom());
        prenom.setText(listContact.get(position).getPrenom());
    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }
}
