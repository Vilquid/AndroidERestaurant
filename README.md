# AndroidERestaurant

Application pour un restaurateur proposer de réserver en ligne ses plats.

# Sujet

## Partie 1 : Création et configuration du projet

Créer un nouveau projet sous Android Studio. Le nom de l’application sera AndroidERestaurant, pour le package name utiliser le format suivant : fr.isen.[nom].androiderestaurant.

Sélectionner le niveau d’API qui regroupe au moins 96% des utilisateurs. Puis ajouter une activité vide accompagnée de son layout.

Lancer l’application sur votre émulateur ou votre smartphone Android.

Analyser la structure du projet et les différents éléments qui composent l’application.

## Partie 2 : Manipulation de l’interface utilisateur

Initialiser le projet en utilisant Git, puis renommer via Android Studio l'activité MainActivity  en HomeActivity ainsi que son fichier de layout activity_main en activity_home. Cette page d'accueil affichera les catégories suivantes proposées par le restaurant : Entrée, Plats et Dessert. Voici un exemple de ce à quoi pourrait ressembler la page home.

Au clique sur une des catégories afficher un toast à l'utilisateur en lui indiquant sur quel entrée du menu il a cliqué.

Créer une nouvelle activité qui affichera la catégorie sélectionnée ainsi que la liste des plats (la liste sera créée dans la partie suivante).

Au lieu d’afficher le message rediriger l’utilisateur vers la page de catégorie précédemment créée.

Ajouter un log pour indiquer quand l'activité Home est détruite. Comprendre le cycle de vie d'une activité.

## Partie 3 : Création de la liste d'une catégorie

Dans la nouvelle activité récupérer le nom de la catégorie passé en argument et l'afficher comme titre de la page.

Créer une liste en utilisant un RecyclerView et un Adapter qui affiche la liste des entrées, plats ou dessert en fonction de la catégorie. Simuler dans un premier temps les éléments de la liste avec une liste de titre stockés dans le fichier strings.xml

Au clique sur une des cellules de la liste, rediriger l'utilisateur vers une nouvelle activité qui contiendra le détail du plat choisi.

Récupérer la liste des entrées/plats/dessert par le biais d'un webservice. Utilisez la librairie Volley pour exécuter une requête POST vers l'url : http://test.api.catering.bluecodegames.com/menu passer en paramètre de cette requête l'objet "id_shop" qui vaut "1"

Parser le json avec la librairie GSON et filtrer suivant la catégorie précédemment sélectionnée.

Utiliser la librairie Picasso pour afficher plus facilement les images en ligne.

Améliorer l'interface des cellules de la liste pour afficher maintenant le titre, la photo et le prix du plat. Gérer également le chargement et les erreurs lors de l'affichage.

Facultatif : Ajouter du cache sur la requête afin de ne pas refaire systématiquement appel au serveur à chaque consultation de la page catégorie.

Facultatif : Implémenter un pull to refresh afin d'invalider le cache et de demander à nouveau la liste des plats au serveur (ceux ayant connu le service en salle y verront un double sens)

## Partie 4 : Détail d'un plat et l'ajout au panier

Dans l'activité du détail d'un plat à la carte, afficher l'ensemble des informations du plat. Il faudra pour cela passer à l'activité l'objet sélectionné par l'utilisateur.

Afficher les images liées au plat à l'aide d'un carrousel (ViewPager), l'utilisateur pourra slider de gauche à droite pour voir les différentes photos. Voici un exemple de cette page.

Ajouter un bouton indiquant le prix ainsi qu'un sélecteur de quantité. Le prix sera proportionnel à la quantité choisie par l'utilisateur.

Au clic sur ce bouton stocker les informations au format json dans un fichier qui sera rattaché à votre l’application. Ce fichier symbolisera le panier de l'utilisateur. Informer l'utilisateur de l'ajout via une Snackbar ou une AlertDialog.

Stocker dans les préférences utilisateurs le nombre d'articles en cours dans votre panier. Ajouter une icone "chariot" dans la toolbar qui redirigera vers le panier de l'utilisateur

Sur l'icône chariot insérer une pastille qui indiquera le nombre d'articles stockés précédemment.

Créer l'écran lié au panier en lisant les informations du fichiers et ajouter un bouton pour passer la commande. Donner la possibilité à l'utilisateur de supprimer chaque item de son panier.

Facultatif : Trouver et implémenter une méthode pour sécuriser les données sauvegardées.

## Mot de passe

Mot de passe de la clé : isen2023
