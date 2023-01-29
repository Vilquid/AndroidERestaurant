package fr.isen.vilquid.androiderestaurant.data.model


/**
 * @property {Int} id - L'identifiant du prix.
 * @property {Int} id_pizza - L'identifiant de la pizza
 * @property {Int} id_size - La taille de la pizza.
 * @property {String} price - Le prix de la pizza
 * @property {String} create_date - La date à laquelle le prix a été créé.
 * @property {String} update_date - La date à laquelle le prix a été mis à jour pour la dernière fois.
 * @property {String} size - La taille de la pizza.
 */
data class Price(var id: Int,
				 var id_pizza: Int,
				 var id_size: Int,
				 var price: String,
				 var create_date: String,
				 var update_date: String,
				 var size: String) : java.io.Serializable {}
