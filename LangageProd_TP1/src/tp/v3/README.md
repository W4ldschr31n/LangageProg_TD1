#TP V3
##principes de conception suivis pour les interfaces et les classes d'implémentation
Interfaces: utilisation de classes annonymes pour pouvoir instancier les interfaces par elles même

Principes de conception suivis: Héritage

                                              ListeRenversable
        File                                         |
       /    \_________                               |
       |               \                           Liste
    FileMutable         FileImmutable                |                
        |               |                            |                             
    FileMutableImpl  FileImmutableImpl          ListeMutable   

FileMutableImpl, FileImmutableImpl   : utilisation de deux Liste pour stoquer les éléments

##Factorisation des listes
Nous avons créé une interface ListeRenversable qui exprime la propriété d'une liste qui peut être renversée (méthode miroir).
Pour ce faire nous avons utilisé les outils java reflection, pour appeler dynamiquement les méthodes statiques cons() et vide() en évaluant
à la volée l'interface sollicitée (soit Liste<E> soit ListeMutable<E>).

##Factorisation des files
Nous avons remonté les méthodes ajout(E) et ajout(File<E>) depuis les interfaces FileMutable et FileImmutable car le code était exactement le même.
