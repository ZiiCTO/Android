package dibenedetto.valentin.tp.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dibenedetto.valentin.tp.R;

public class ViewHolderFav extends RecyclerView.ViewHolder {
    public TextView nom, prenom;
    public ImageView photo, fav;

    public ViewHolderFav(@NonNull View itemView) {
        super(itemView);

        photo = itemView.findViewById(R.id.fav_img);
        nom = itemView.findViewById(R.id.fav_nom);
        prenom = itemView.findViewById(R.id.fav_prenom);
        fav = itemView.findViewById(R.id.fav_ic);
    }
}
