#TP FileRougeV5
##principes de conception suivis pour les interfaces et les classes d'implémentation
Nous avons implémenté nos files en suivant un principe d'agrégation/délégation.
Nous avons défini d'une part l'interface File et ses sous-interfaces mutables et immutables, qui déclarent la couche haute (services) de l'implémentation.
Ces interfaces sont concrétisées au moyen de classes anonymes. Ces classes délèguent la couche basse de l'implémentation (accesseurs et fabriques) à un objet de l'interface EtatFile.
L'interface EtatFile possède deux sous-interfaces représentant une manière mutable et immutable de gérer l'état d'une file.
Nous avons repris les classes X et Y des versions précédentes du TP.


                File                                                   Etat
                 |                                                       |
                 |                                                       |
                 |                                                       |
         ______________                                         _________________
        /               \                                      /                 \
       /                 \                                    /                   \
      /                   \                                  /                     \
 FileMutable            FileImmutable                    EtatMutable          EtatImmutable
                                                            |                       |
                                                            |                       |
                                                            |                       |
                                                 ImplementationMutable      ImplementationImmutable

Ainsi, nous créeons une File concrète à l'aide des fabriques statiques de l'interface File, et en passant un Etat concret en paramètre.
Lorsque l'on sollicite les services de la File créée, nous sollicitons ainsi indirectement les accesseurs et fabriques de l'Etat.

##Factorisation
