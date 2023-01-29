package fr.isen.vilquid.androiderestaurant.data.model


/**
 * C'est une classe de données qui contient un objet Plat et un entier.
 * @property {Plat} plat - Plat
 * @property {Int} nb_cart - le nombre d'articles dans le panier
 */
data class CartObject(val plat: Plat, var nb_cart: Int) {}