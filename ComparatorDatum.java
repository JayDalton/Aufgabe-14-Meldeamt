/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.Comparator;

//##########################################################################
/** Dient dem Vergleich und der Sortierung der Liste von Personen. Die Liste 
  * wird nach Nach- und Vornamen alphabetisch sortiert.
  *
  * @author Thomas Gerlach
*/
//##########################################################################
public class ComparatorDatum implements Comparator<Person>
{
  //##########################################################################
  /**
    * Vergleicht die Namen der Studenten und liefert das Ergebnis.
    * 
    * @param  a Erster Student
    * @param  b Zweiter Student
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
    
    if( (a.getFamName() == null && b.getFamName() == null) || 
        (a.getFamName().isEmpty() && b.getFamName().isEmpty())
      )
    {
      ergebnis = 0;
    }
    
    if( a.getFamName() == null )
    {
      ergebnis = 1;
    }

    if (ergebnis == 0)
    {
      ergebnis = a.getFamName().compareTo(b.getFamName());
    }
    
    if (ergebnis == 0)
    {
      ergebnis = a.getVorName().compareTo(b.getVorName());
    }

    if (ergebnis == 0)
    {
      ergebnis = a.getGebDatum().getTimeInMillis() < b.getGebDatum().getTimeInMillis() ? -1 : 1;
    }

    return ergebnis;
  }
}