package dibenedetto.valentin.tp.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dibenedetto.valentin.tp.R;

public class ViewHolderDetailContact extends RecyclerView.ViewHolder {
    public TextView nom, prenom, tel, mail, ville;
    public ImageView photo, fav;

    public ViewHolderDetailContact(@NonNull View itemView) {
        super(itemView);

        photo = itemView.findViewById(R.id.detail_img);
        nom = itemView.findViewById(R.id.detail_nom);
        prenom = itemView.findViewById(R.id.detail_prenom);
        tel = itemView.findViewById(R.id.detail_tel);
        mail = itemView.findViewById(R.id.detail_mail);
        ville = itemView.findViewById(R.id.detail_ville);
        fav = itemView.findViewById(R.id.detail_fav_ic);
    }
}
