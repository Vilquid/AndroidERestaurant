package fr.isen.vilquid.androiderestaurant.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import fr.isen.vilquid.androiderestaurant.R
import fr.isen.vilquid.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
	private lateinit var binding: ActivityHomeBinding

	/**
	* La fonction est appelée lors de la création de l'activité. Elle définit le titre de l'activité sur
	* "Accueil", puis définit la vue du contenu sur la disposition activity_home. Elle définit ensuite les
	* onClickListeners pour les trois boutons de la page
	*
	* @param savedInstanceState Un objet Bundle contenant l'état précédemment enregistré de l'activité.
	* Si l'activité n'a jamais existé auparavant, la valeur de l'objet Bundle est nulle.
	*/
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_home)
		setTitle("Accueil")
		Log.v("HomeActivity", "onCreate")

		binding = ActivityHomeBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.Starter.setOnClickListener{
			ChangePage(binding.Starter)
		}
		binding.middle.setOnClickListener{
			ChangePage(binding.middle)
		}
		binding.dessert.setOnClickListener{
			ChangePage(binding.dessert)
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.v("HomeActivity", "onDestroy")
	}

	/**
	 * Change la page en activité de catégorie.
	 *
	 * @param Button Le bouton qui a été cliqué
	 */
	fun ChangePage(Button: Button){
		val intent = Intent(this, CategoryActivity::class.java)
		intent.putExtra("title", Button.text)

		startActivity(intent)
	}
}