package fr.isen.vilquid.androiderestaurant.data.model


import java.io.Serializable


/**
 * `data class Ingredient(var id: Int, var id_shop: Int, var name_fr: String, var name_en: String,
 * var create_date: String, var update_date: String, var id_pizza: Int): sérialisable {}`
 * @property {Int} id - Identificateur unique de l'ingrédient.
 * @property {Int} id_shop - L'identifiant de la boutique à laquelle appartient l'ingrédient.
 * @property {String} name_fr - Le nom de l'ingrédient en français
 * @property {String} name_en - Le nom de l'ingrédient en anglais
 * @property {String} create_date - La date à laquelle l'ingrédient a été créé.
 * @property {String} update_date - La date à laquelle l'ingrédient a été mis à jour pour la dernière
 * fois.
 * @property {Int} id_pizza - L'identifiant de la pizza à laquelle appartient l'ingrédient.
 */
data class Ingredient(var id: Int,
					  var id_shop: Int,
					  var name_fr: String,
					  var name_en: String,
					  var create_date:String,
					  var update_date: String,
					  var id_pizza: Int): Serializable {}