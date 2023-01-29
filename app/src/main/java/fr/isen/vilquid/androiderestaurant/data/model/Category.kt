package fr.isen.vilquid.androiderestaurant.data.model


/**
 * `Category` est une classe de données qui a trois propriétés : `name_fr`, `name_en` et `items`.
 *
 * Les deux premières propriétés sont des chaînes, et la troisième est un tableau de `Plat`s.
 *
 * Le mot clé `data` signifie que cette classe est une classe de données.
 *
 * Le mot-clé `var` signifie que les propriétés sont modifiables.
 *
 * Le mot clé `override` signifie que la fonction remplace une fonction d'une superclasse.
 *
 * Le symbole `:` signifie que la classe hérite d'une autre classe.
 * @property {String} name_fr - Le nom de la catégorie en français.
 * @property {String} name_en - Le nom de la catégorie en anglais.
 * @property {Array<Plat>} items - Tableau<Plat>
 */
data class Category(var name_fr: String, var name_en: String, var items: Array<Plat>): java.io.Serializable {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Category

		if (name_fr != other.name_fr) return false
		if (name_en != other.name_en) return false
		if (!items.contentEquals(other.items)) return false

		return true
	}

	override fun hashCode(): Int {
		var result = name_fr.hashCode()
		result = 31 * result + name_en.hashCode()
		result = 31 * result + items.contentHashCode()
		return result
	}
}