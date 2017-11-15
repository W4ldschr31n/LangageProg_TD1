#TP V2
##principes de conception suivis pour les interfaces et les classes d'implémentation
Interfaces: utilisation de classes annonymes pour pouvoir instancier les interfaces par elles même

Principes de conception suivis: Héritage


        File
       /    \_________    
       |               \                           Liste
    FileMutable         FileImmutable                |                
        |               |                            |                             
    FileMutableImpl  FileImmutableImpl          ListeMutable   

FileMutableImpl, FileImmutableImpl   : utilisation de deux Liste pour stoquer les éléments



##principes de nommage suivis
Acesseurs: Noms communs, singulier si de type élémentaire pluriel si de type liste file ect (premier, suivants,tete,taille
Fabriques: cree(), creeCopie()
Services: Utilisation de noms communs (ajout, retrait,miroir,representation)
Tests/Booleens: estNom (estVide, estEgual)

##complexité des opérations
###File:
ajout (element): O(1)
ajout (seconde file): O(n) avec n taille de la seconde file
retrait: O(1)
###Liste:
miroir (): O(n) avec n la taille de la liste
vide (): O(1)
cons (): O(1)
changerReste (): O(2n) avec n la taille de la liste

##lien vers la documentation,
LangageProg_TD1\LangageProd_TP1\Javadoc\index.html
##guide pour lancer les tests.
Tout les test sont dans le package Test.
Chaque classe de teste test une classe ou une interface.
Sauf ComparateurPerf qui compare les performances des files mutables et immutable
