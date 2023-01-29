package fr.isen.vilquid.androiderestaurant.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.vilquid.androiderestaurant.R
import fr.isen.vilquid.androiderestaurant.data.model.Category
import fr.isen.vilquid.androiderestaurant.data.model.Plat


/* RecyclerView.Adapter qui prend une liste d'éléments et une fonction qui sera appelée
lorsqu'un élément est cliqué */
class CategoryAdapter(private var platsList: Array<Plat>, private val intentFun: (Plat) -> Unit): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
	/**
	 * Cette fonction est appelée lorsque RecyclerView a besoin d'un nouveau RecyclerView.ViewHolder du
	 * type donné pour représenter un élément
	 *
	 * @param parent Le ViewGroup dans lequel la nouvelle vue sera ajoutée après sa liaison à une position
	 * d'adaptateur.
	 * @param viewType C'est le type de vue. Il est utilisé lorsqu'il existe plusieurs types de vue dans
	 * la vue de l'outil de recyclage.
	 * @return Un objet CategoryViewHolder.
	 */
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)

		return CategoryViewHolder(view)
	}

	/**
	 * Prend un détenteur de vue et une position comme paramètres et lie les données au
	 * détenteur de vue
	 *
	 * @param holder CategoryViewHolder - Il s'agit du ViewHolder que vous avez créé à l'étape précédente.
	 * @param position Position de l'élément dans l'ensemble de données de l'adaptateur.
	 */
	override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
		val ItemsViewModel = platsList[position]

		holder.textView.text = ItemsViewModel.name_fr
		holder.price.text = ItemsViewModel.prices[0].price
		if(ItemsViewModel.images[0] != "")
		{
			Picasso.get().load(ItemsViewModel.images[0]).into(holder.imageView)
		}


		holder.cardLinear.setOnClickListener{
			intentFun(ItemsViewModel)
		}
	}

	override fun getItemCount(): Int {
		return platsList.size
	}

	fun updateData(filter: Category?) {
		if (filter != null) {
			platsList = filter.items
		}
		notifyDataSetChanged()
	}

	/* Cette classe est un détenteur de vue pour la vue recycleur. Elle contient les vues utilisées pour
	afficher les données */
	class CategoryViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
		val textView: TextView = itemView.findViewById(R.id.textView)
		val cardLinear: ConstraintLayout = itemView.findViewById(R.id.CardLinear)
		val price: TextView = itemView.findViewById(R.id.price)
		val imageView: ImageView = itemView.findViewById(R.id.imageview)
	}
}

