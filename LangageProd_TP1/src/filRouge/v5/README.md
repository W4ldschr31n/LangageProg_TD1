#TP FileRougeV5
##principes de conception suivis pour les interfaces et les classes d'implémentation
Nous avons implémenté nos files en suivant un principe d'agrégation/délégation.
Nous avons défini d'une part l'interface File et ses sous-interfaces mutables et immutables, qui déclarent la couche haute (services) de l'implémentation.
Ces interfaces sont concrétisées au moyen de classes anonymes. Ces classes délèguent la couche basse de l'implémentation (accesseurs et fabriques) à un objet de l'interface EtatFile.
L'interface EtatFile possède deux sous-interfaces représentant une manière mutable et immutable de gérer l'état d'une file.
Ces interfaces possèdent une concrétisation par défaut, utilisant respectivement une liste mutale et une liste immutable pour gérer la file.
Nous avons également défini des classes d'implémentation plus performantes, en adaptant les classes EnveloppeDeuxListesImmutables et EnveloppeListeMutableDoubleAcces des corrections de la version précédente.
Cette architecture permet de définir autant d'implémentations mutables et immutables que l'on souhaite, tout en sachant qu'une implémentation peu performante existe de base.
Nous pourrions ainsi comparer aisément la performance de deux implémentations mutable ou immutables. 


                File                                                  EtatFile
                 |                                                       |
                 |                                                       |
                 |                                                       |
         ______________                                         _________________
        /               \                                      /                 \
       /                 \                                    /                   \
      /                   \                                  /                     \
 FileMutable            FileImmutable                 EtatFileMutable          EtatFileImmutable
                                                            |                           |
                                                            |                           |
                                                            |                           |
                                             EnveloppeListeMutableDoubleAcces      EnveloppeDoubleListeImmutable

Ainsi, nous créons une File concrète à l'aide des fabriques statiques de l'interface File, et en passant un Etat concret en paramètre.
Lorsque l'on sollicite les services de la File créée, nous sollicitons ainsi indirectement les accesseurs et fabriques de l'Etat.

##Factorisation
Nous avons factorisé la méthode ajouter(E) dans l'interface EtatFile car cela correspond toujours à la création d'un nouvel etat à partir du courant et d'un nouvel element
//Vérifier qu'on est bien en mode mutable/immutable à chaque fois
//Factoriser les méthodes redondantes type suivants, miroir?

##Analyse comparative des performances
### Performances des états définis dans des interfaces concrètes (avec classes anonymes)
Ci-dessous un des résultats obtenus (en milli secondes) par Thread Bean pour 500 ajouts et 250 retraits sur les files ayant des états définis dans des interfaces concrètes:
FileMutable - EtatFileMutable$2  ajout/retrait: 406
FileImmutable - EtatFileMutable$2  ajout/retrait: 375
FileMutable - EtatFileImmutable$1  ajout/retrait: 718
FileImmutable - EtatFileImmutable$1  ajout/retrait: 562

Nous avons remarqué que l'EtatFileImmutable est en moyenne deux fois moins efficace que l'étatFileMutable.

### Performances des états implémentés avec deux listes
Ci-dessous un des  résultats obtenus (en milli secondes) par Thread Bean pour un million ajouts et un million retraits sur les files ayant des états implémentés par deux listes.
class filRouge.v5.FileMutable$1-class filRouge.v5.EnveloppeListeMutableDoubleAcces  ajout: 78	retrait : 31
class filRouge.v5.FileImmutable$1-class filRouge.v5.EnveloppeListeMutableDoubleAcces  ajout: 46	retrait : 31
class filRouge.v5.FileMutable$1-class filRouge.v5.EnveloppeDeuxListesImmutables  ajout: 62	retrait : 31
class filRouge.v5.FileImmutable$1-class filRouge.v5.EnveloppeDeuxListesImmutables  ajout: 46	retrait : 46

On remarque que les états implémentés sont beaucoup plus performants, nous avons observé une complexité en O(log(n)).


