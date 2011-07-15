/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.Comparator;

//##########################################################################
/** Dient dem Vergleich und der Sortierung der Liste von Personen. Die Liste 
  * wird aufsteigend nach dem Nachnamen, bei gleichem Nachnamen aufsteigend
  * nach dem Vornamen, bei gleichem Vor- und Nachnamen absteigend nach dem 
  * Alter, sortiert.
  *
  * @author Thomas Gerlach
*/
//##########################################################################
public class ComparatorAlpha implements Comparator<Person>
{
  //##########################################################################
  /**
    * Vergleicht die Attribute der Personen und liefert das Ergebnis.
    * 
    * @param  a Erste Person
    * @param  b Zweite Person
    * 
    * @return   Ergebnis des Vergleich wobei gilt:
    *           -1: Der erste Parameter ist untergeordnet
    *            0: Beide Parameter werden gleich eingeordnet
    *            1: Der erste Parameter ist uebergeordnet
  */
  //##########################################################################
  public int compare( Person a, Person b ) 
  {
    int ergebnis = 0;

    ergebnis = a.getFamName().compareTo(b.getFamName());
    
    if (ergebnis == 0)
    {
      ergebnis = a.getVorName().compareTo(b.getVorName());
      if (ergebnis == 0)
      {
        if (a.getGebDatum().getTimeInMillis() > b.getGebDatum().getTimeInMillis())
        {
          ergebnis = 1;
        }

        if (a.getGebDatum().getTimeInMillis() < b.getGebDatum().getTimeInMillis())
        {
          ergebnis = -1;
        }
      }
    }
    return ergebnis;
  }
}