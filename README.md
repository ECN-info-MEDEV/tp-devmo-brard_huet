# Jus'te à coté : application mobile Smartphone

Nous formons une équipe de deux développeurs : Arthur Huet et Tristan Brard.

Nous avons créé un prototype d'application pour le projet Jus'te à coté

## A propos de Jus'te à coté
Jus'te à coté est une application qui permet de promouvoir le commerce de proximité de Nantes et de ses environs pour les jus de fruit.
Ainsi, des utilisateurs peuvent commander des jus de fruit provenant à coté de chez eux grace à cette application.
Les différentes annonces sont postées directement par les producteurs locaux

## Périmètre de ce prototype
Pour ce prototype, on s'est limité aux intéractions de l'utilisateur avec l'application (pas pour les producteurs ni pour les livreurs).
Notre objectif est donc d'implémenter 4 écrans différents : 
 - écran login qui permet à l'utilisateur de se connecter
 - écran register qui permet à l'utilisateur de se créer un compte
 - écran liste des commandes qui permet à l'utilisateur de voir les différentes commandes disponibles à proximité
 - écran commande qui permet à l'utilisateur de commander des jus de fruit

## Base de données de l'application
Cette application possède une base de donnée sur le téléphone (donc pas en réseau) pour différentes intéractions basiques afin de rapprocher au mieux de la réalité le prototype.
On retrouve donc 3 tables dans cette base de données : 
 - command : correspond aux différentes commandes entrées par les producteurs (nom, description, lieu, image)
 - producteur : données concernant les producteurs (nom, prénom, description, avatar)
 - user : informations de connexion (username, password)

## Fonctionnalités de l'application :
### Ecran login
Sur cet écran, l'utilisateur a la possibilité de se connecter, il sera redirigé vers la page de la liste des jus si les identifiants se trouvent bien dans la bdd.
Sinon, un toast : "connexion impossible" apparaît.

### Ecran register
Cet écran permet à l'utilisateur de se créer un compte, ce compte sera alors écrit dans la bdd

### Écran commandes
Sur cette écran on trouve un RecyclerView connecté à la base de données des différentes commandes. Lorsque l'on appuie sur une des commandes, on est redirigé sur la page de réservation et l'id de la commande cliquée est passée dans l'intent ce qui permet de savoir quelle commande a été cliquée.

### Écran réservation
Sur cet écran, on récupère les informations de la commande et du producteur. On les affiches ensuite.
Il y a un bouton commander en bas de l'écran. Lorsque l'on appuie dessus, l'activité est détruite (ce qui a pour conséquence de revenir à la page précédente) et un toast apparaît en disant commande réservée.
La commande n'est donc pas vraimet réservée !
