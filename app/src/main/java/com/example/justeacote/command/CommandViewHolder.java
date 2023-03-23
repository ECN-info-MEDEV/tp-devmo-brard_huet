package com.example.justeacote.command;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.justeacote.R;

public class CommandViewHolder extends RecyclerView.ViewHolder {
    private final ImageView commandImgView;
    private final TextView commandNameTextView;
    private final TextView commandDescriptionTextView;
    private final TextView commandLocalisationTextView;
    private final RelativeLayout relativeLayout;

    private CommandViewHolder(View itemView) {
        super(itemView);
        this.commandImgView = (ImageView) itemView.findViewById(R.id.commandItemImg);
        this.commandNameTextView = (TextView) itemView.findViewById(R.id.commandItemTitle);
        this.commandDescriptionTextView = (TextView) itemView.findViewById(R.id.commandItemDescription);
        this.commandLocalisationTextView = (TextView) itemView.findViewById(R.id.commandItemLocalisation);
        relativeLayout = (RelativeLayout)itemView.findViewById(R.id.commandItemRelativeLayout);
    }

    public void bind(CommandData data, CommandActivity activity) {
        // On modifie le ViewHolder pour y affihcer nos données dessus
        commandDescriptionTextView.setText(data.getCommandDescription()); // Le nom de la commande
        commandNameTextView.setText(data.getCommandName()); // Le nom de la commande
        commandLocalisationTextView.setText(data.getCommandLocalisation()); // Le nom de la commande
        commandImgView.setImageResource(activity.getCommandImageFromLabel(data.getCommandImgId())); // L'image de la commande
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Permet d'afficher un message à chaque fois que l'utilisateur clique sur un élément de la liste déroulante
                Toast.makeText(view.getContext(), "Click sur commande : "+data.getCommandName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    static CommandViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.command_item, parent, false);
        return new CommandViewHolder(view);
    }
}
