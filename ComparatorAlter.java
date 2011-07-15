/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.Comparator;

//##########################################################################
/** Dient dem Vergleich und der Sortierung der Liste von Personen. Die Liste 
  * wird absteigend sortiert, bei gleichem Geburtsdatum zusätzlich aufsteigend 
  * nach Nach- und Vornamen.
  *
  * @author Thomas Gerlach
*/
//##########################################################################
public class ComparatorAlter implements Comparator<Person>
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
    
    if (a.getGebDatum().getTimeInMillis() > b.getGebDatum().getTimeInMillis())
    {
      ergebnis = -1;
    }

    if (a.getGebDatum().getTimeInMillis() < b.getGebDatum().getTimeInMillis())
    {
      ergebnis = 1;
    }
    
    if (ergebnis == 0)
    {
      if (0 < a.getFamName().compareTo(b.getFamName()))
      {
        ergebnis = 1;
      }
      if (0 > a.getFamName().compareTo(b.getFamName()))
      {
        ergebnis = -1;
      }
      if (ergebnis == 0)
      {
        if (0 < a.getVorName().compareTo(b.getVorName()))
        {
          ergebnis = 1;
        }
        if (0 > a.getVorName().compareTo(b.getVorName()))
        {
          ergebnis = -1;
        }
      }
    }
    return ergebnis;
  }
}