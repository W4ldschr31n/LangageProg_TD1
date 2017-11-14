package tp.v3;

import java.util.Iterator;

public interface FileImmutable<E> extends File<E> {

  /*
   * Accesseurs
   */
  FileImmutable<E> suivants();

  /*
   * Fabriques
   */
  FileImmutable<E> creer(E dernier);


  /*
   * Services
   */

  /**
   * Ajoute un element a la fin de la file
   * @param dernierDansFile l'element a ajouter
   * @return la file correspondant
   */
  @Override
  default FileImmutable<E> ajout(E dernierDansFile) {
    if( this.suivants().estVide()){

      return creer(dernierDansFile);

    }
    else {
      return this.suivants().ajout(dernierDansFile);
    }

  }

  /**
   * Enleve le premier element de la file
   * @return
   */
  @Override
  default FileImmutable<E> retrait() {
    return this.suivants();
  }


}
