package fr.isen.vilquid.androiderestaurant.data.model


/**
 * @property {Int} id - L'identifiant du plat.
 * @property {String} name_fr - Le nom du plat en français.
 * @property {String} name_en - Le nom du plat en anglais.
 * @property {Int} id_category - L'identifiant de catégorie du plat.
 * @property {String} categ_name_fr - Le nom de la catégorie en français.
 * @property {String} categ_name_en - Le nom de la catégorie en anglais.
 * @property {Array<String>} images - Tableau<chaîne>
 * @property {Array<Ingredient>} ingredients - Tableau<Ingrédient>
 * @property {Array<Price>} prices - Tableau<Prix>
 */
data class Plat(var id: Int,
				var name_fr: String,
				var name_en: String,
				var id_category: Int,
				var categ_name_fr: String,
				var categ_name_en: String,
				var images: Array<String>,
				var ingredients: Array<Ingredient>,
				var prices: Array<Price> ): java.io.Serializable {
	/**
	 * La fonction retourne true si les deux objets sont identiques, ou si les deux objets ont le même id,
	 * name_fr, name_en, id_category, categ_name_fr, categ_name_en, images et ingredients
	 *
	 * @param other Quelconque?
	 * @return Le hashcode de l'objet.
	 */
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Plat

		if (id != other.id) return false
		if (name_fr != other.name_fr) return false
		if (name_en != other.name_en) return false
		if (id_category != other.id_category) return false
		if (categ_name_fr != other.categ_name_fr) return false
		if (categ_name_en != other.categ_name_en) return false
		if (!images.contentEquals(other.images)) return false
		if (!ingredients.contentEquals(other.ingredients)) return false

		return true
	}

	/**
	 * Renvoie le code de hachage de l'objet.
	 *
	 * @return Le code de hachage de l'objet.
	 */
	override fun hashCode(): Int {
		var result = id
		result = 31 * result + name_fr.hashCode()
		result = 31 * result + name_en.hashCode()
		result = 31 * result + id_category
		result = 31 * result + categ_name_fr.hashCode()
		result = 31 * result + categ_name_en.hashCode()
		result = 31 * result + images.contentHashCode()
		result = 31 * result + ingredients.contentHashCode()
		return result
	}
}