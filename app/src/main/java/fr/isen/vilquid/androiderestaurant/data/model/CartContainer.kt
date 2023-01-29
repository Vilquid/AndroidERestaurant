package fr.isen.vilquid.androiderestaurant.data.model


/**
 * `CartContainer` est une classe de données qui contient une liste de `CartObject`.
 * @property {MutableList<CartObject>} CartsObjectList - Ceci est une liste de CartObjects.
 */
data class CartContainer(var CartsObjectList: MutableList<CartObject>) {}