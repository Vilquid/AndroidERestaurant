package fr.isen.vilquid.androiderestaurant.activity


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.vilquid.androiderestaurant.R
import fr.isen.vilquid.androiderestaurant.adapter.CategoryAdapter
import fr.isen.vilquid.androiderestaurant.data.model.Data
import fr.isen.vilquid.androiderestaurant.data.model.Plat
import fr.isen.vilquid.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONException
import org.json.JSONObject


class CategoryActivity : AppCompatActivity() {
	private lateinit var binding: ActivityCategoryBinding
	private var url = "http://test.api.catering.bluecodegames.com/menu"
	private lateinit var adapter: CategoryAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_category)

		binding = ActivityCategoryBinding.inflate(layoutInflater)
		setContentView(binding.root)

		setTitle(intent.getStringExtra("title"))
		binding.Title.text = intent.getStringExtra("title")

		val back = binding.back
		back.setOnClickListener {
			var intent= Intent(this, HomeActivity::class.java)
			startActivity(intent)
		}

		binding.rvList.layoutManager = LinearLayoutManager(this)
		binding.rvList.adapter = CategoryAdapter(arrayOf()){
			onSetCategory(it)
		}

		addData()
	}

	/**
	 * Lorsque l'utilisateur clique sur une catégorie de plat -> création d'une intent pour démarrer
	 * DetailActivity et transmettre la catégorie
	 *
	 * @param plat Plat
	 */
	private fun onSetCategory(plat: Plat) {
		val intent = Intent(this, DetailActivity::class.java)
		intent.putExtra("plat", plat)
		startActivity(intent)
	}

	/**
	 * Création d'une nouvelle file d'attente de requêtes, un nouveau JSONObject, un nouvel objet Gson, on
	 * met l'id de la boutique dans le JSONObject.
	 * Création d'une nouvelle requête avec la méthode POST,
	 * l'url, le JSONObject et les listeners de réponse et d'erreur
	 */
	private fun addData() {
		val queue = Volley.newRequestQueue(this)
		val jsonObjectID = JSONObject()
		val gson = Gson()

		try {
			jsonObjectID.put("id_shop",1)

		} catch (e: JSONException)
		{
			Log.e("ERROR", e.toString())
		}

		val req = JsonObjectRequest(Request.Method.POST, url, jsonObjectID, {
				response ->
			val dataFromJSON: Data = gson.fromJson(response.toString(),Data::class.java)

			binding.progressBar.visibility = View.GONE

			val catlist = dataFromJSON.data.firstOrNull() { it.name_fr == binding.Title.text }
			val adapter = binding.rvList.adapter as CategoryAdapter
			adapter.updateData(catlist)
		}, {
				errorData -> Log.e("ERROR", errorData.toString())
		})

		queue.add(req)
	}
}

