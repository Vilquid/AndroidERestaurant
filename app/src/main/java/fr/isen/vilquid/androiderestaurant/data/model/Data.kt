package fr.isen.vilquid.androiderestaurant.data.model

/**
 * `Data` est une classe qui contient un tableau d'objets `Category`.
 * @property {Array<Category>} data - Les données à afficher.
 */
data class Data(var data: Array<Category>): java.io.Serializable {
	/**
	 * Si l'autre objet n'est pas du même type, alors il n'est pas égal. Sinon, si les tableaux de données
	 * ne sont pas égaux, alors ce n'est pas égal. Sinon, c'est égal
	 *
	 * @param other Quelconque? - L'objet à comparer.
	 * @return Le code de hachage du tableau de données.
	 */
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Data

		if (!data.contentEquals(other.data)) return false

		return true
	}

	override fun hashCode(): Int {
		return data.contentHashCode()
	}
}