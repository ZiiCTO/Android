package dibenedetto.valentin.tp.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dibenedetto.valentin.tp.R;

public class ViewHolderContact extends RecyclerView.ViewHolder {
    public TextView nom, prenom;
    public ImageView photo, fav;
    public Button fav2;

    public ViewHolderContact(@NonNull View itemView) {
        super(itemView);

        photo = itemView.findViewById(R.id.contact_img);
        nom = itemView.findViewById(R.id.contact_nom);
        prenom = itemView.findViewById(R.id.contact_prenom);
        //fav = itemView.findViewById(R.id.contact_fav_ic);
        fav2 = itemView.findViewById(R.id.button_fav_ic);
    }
}
