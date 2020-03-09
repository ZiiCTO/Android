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
import dibenedetto.valentin.tp.views.ViewHolderContact;
import dibenedetto.valentin.tp.views.ViewHolderDetailContact;

public class DetailAdapter extends RecyclerView.Adapter<ViewHolderDetailContact> {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<Contact> listContact;

    public DetailAdapter(Context context,List<Contact> listContact) {
        this.context = context;
        this.listContact = listContact;
    }


    @NonNull
    @Override
    public ViewHolderDetailContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = layoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.items_details_contacts, parent, false);

        ViewHolderDetailContact viewHolderDetailContact = new ViewHolderDetailContact(view);

        return viewHolderDetailContact;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDetailContact holder, int position) {
        TextView nom, prenom, tel, mail, ville;

        nom = holder.nom;
        prenom = holder.prenom;
        tel = holder.tel;
        mail = holder.mail;
        ville = holder.ville;

        nom.setText(listContact.get(position).getNom());
        prenom.setText(listContact.get(position).getPrenom());
        tel.setText(listContact.get(position).getTel());
        mail.setText(listContact.get(position).getMail());
        ville.setText(listContact.get(position).getVille());
    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }
}
