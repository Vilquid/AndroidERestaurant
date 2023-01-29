package fr.isen.vilquid.androiderestaurant.activity


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.isen.vilquid.androiderestaurant.R
import fr.isen.vilquid.androiderestaurant.adapter.DetailAdapter
import fr.isen.vilquid.androiderestaurant.data.model.CartContainer
import fr.isen.vilquid.androiderestaurant.data.model.CartObject
import fr.isen.vilquid.androiderestaurant.data.model.Plat
import fr.isen.vilquid.androiderestaurant.databinding.ActivityDetailBinding
import java.io.File


class DetailActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDetailBinding
	private lateinit var plat: Plat
	private var cart: Int = 0
	private lateinit var cartContainer: CartContainer
	var price: Float = 0.0F
	val filename: String = "current_cart.json"

	/**
	 * Nous obtenons l'objet plat de l'intent, nous définissons le titre de l'activité sur le nom du plat,
	 * nous obtenons le conteneur du panier, nous définissons le texte du titre, la description, le prix
	 * et le numéro du plat, nous définissons le viewpager adaptateur, nous définissons le onclicklistener
	 * des boutons plus, moins et panier
	 *
	 * @param savedInstanceState Un objet Bundle contenant l'état précédemment enregistré de l'activité.
	 * Si l'activité n'a jamais existé auparavant, la valeur de l'objet Bundle est nulle.
	 */
	@SuppressLint("SetTextI18n")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)
		binding = ActivityDetailBinding.inflate(layoutInflater)
		setContentView(binding.root)
		plat = intent.getSerializableExtra("plat") as Plat
		title = plat.name_fr
		cartContainer = getCartContainer()

		var ingredients = ""
		for (ingr in plat.ingredients)
		{
			ingredients += ingr.name_fr+ ", "
		}

		binding.DetailsTitle.text = plat.name_fr
		binding.DetailsDesc.text = ingredients
		price = plat.prices[0].price.toFloat()
		binding.DetailsPrice.text = "$price €"
		binding.DetailsNumber.text = cart.toString()

		calculateCart()

		val viewPager = binding.DetailViewPager
		val adapter = DetailAdapter(plat.images)

		viewPager.adapter=adapter

		binding.DetailsPlus.setOnClickListener {
			addNumber()
		}

		binding.DetailsMinus.setOnClickListener {
			removeNumber()
		}

		binding.DetailsCart.setOnClickListener {
			addToCart()
		}
	}

	/**
	 * Supprime un article du panier et met à jour l'interface utilisateur
	 */
	private fun removeNumber() {
		if (cart > 0)
			cart--

		binding.DetailsNumber.text = cart.toString()
		calculateCart()
	}

	/**
	 * Ajoute un à la variable cart, met à jour le texte du TextView et appelle
	 * la fonction calculateCart()
	 */
	fun addNumber() {
		cart++
		binding.DetailsNumber.text = cart.toString()
		Log.i("CART_CONTENT", cart.toString())
		calculateCart()
	}

	/**
	 * Calcule le prix total du produit.
	 */
	@SuppressLint("SetTextI18n")
	fun calculateCart() {
		var total= price * cart
		binding.DetailsCart.text = "Prix total $total €"
	}

	/**
	 * Ajoute le plat actuel au panier
	 */
	fun addToCart() {
		var index = -1
		index = cartContainer.CartsObjectList.map { it.plat.name_fr }.indexOf(plat.name_fr)

		if (index <0)
		{
			cartContainer.CartsObjectList.add(CartObject(plat,cart))
		}
		else
		{
			cartContainer.CartsObjectList[index].nb_cart = cart
		}

		Log.i("CART_CONTAINER", cartContainer.toString())
		saveCartContainer()
	}

	/**
	 * Enregistre le cartContainer dans un fichier.
	 */
	fun saveCartContainer() {
		val jsonBuilder = GsonBuilder().setPrettyPrinting().create()
		val jsonText = jsonBuilder.toJson(cartContainer)

		File(cacheDir.absolutePath,filename).writeText(jsonText)
	}

	/**
	 * Lecture du fichier s'il existe et renvoie le dernier objet CartContainer qui y a été enregistré
	 *
	 * @return Un objet CartContainer
	 */
	fun getCartContainer(): CartContainer {
		var file = File(cacheDir.absolutePath,filename)

		if( file.exists())
		{
			var outputText = file.readText()
			val jsonBuilder = Gson()
			Log.i("FILE EXIST", "vrai")

			var lastCartContainer = jsonBuilder.fromJson(outputText,CartContainer::class.java)
			var index = lastCartContainer.CartsObjectList.map { it.plat.name_fr }.indexOf(plat.name_fr)
			Log.v("INDEX", index.toString())
			if (index >= 0)
			{
				Log.i("LAST CART CONTAINER", lastCartContainer.CartsObjectList[index].nb_cart.toString())
				cart = lastCartContainer.CartsObjectList[index].nb_cart
			}
			else
			{
				cart = 0
			}

			return lastCartContainer
		}
		else
		{
			Log.i("FILE DOES NOT EXIST", "faux")
			return CartContainer(mutableListOf<CartObject>())
		}
	}
}