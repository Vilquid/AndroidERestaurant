package fr.isen.vilquid.androiderestaurant.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.vilquid.androiderestaurant.R


class DetailAdapter(private val images: Array<String>): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
	/**
	 * Cette fonction est appelée lorsque RecyclerView a besoin d'un nouveau RecyclerView.ViewHolder du
	 * type donné pour représenter un élément
	 *
	 * @param parent Le ViewGroup dans lequel la nouvelle vue sera ajoutée après sa liaison à une position
	 * d'adaptateur.
	 * @param viewType C'est le type de vue qui sera créé. Dans ce cas, nous n'avons qu'un seul type de
	 * vue, nous pouvons donc ignorer ce paramètre.
	 * @return Un objet DetailViewHolder.
	 */
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.details_imageview, parent, false)

		return DetailViewHolder(view)
	}

	/**
	 * La fonction prend un DetailViewHolder et un Int comme paramètres, puis définit le imageViewVP sur
	 * l'image à la position dans le tableau d'images
	 *
	 * @param holder DetailViewHolder - Le ViewHolder qui doit être mis à jour pour représenter le contenu
	 * de l'élément à la position donnée dans l'ensemble de données.
	 * @param position La position de l'élément dans l'ensemble de données de l'adaptateur de l'élément
	 * dont nous voulons la vue.
	 */
	override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
		val itemsViewModel = images[position]

		if (itemsViewModel != "")
		{
			Picasso.get().load(itemsViewModel).into(holder.imageViewVP)
		}
	}

	override fun getItemCount(): Int {
		return images.size
	}

	class DetailViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
		val imageViewVP: ImageView = itemView.findViewById(R.id.imageViewVP)
	}
}