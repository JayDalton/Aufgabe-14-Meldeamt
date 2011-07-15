/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.GregorianCalendar;

//############################################################################
/** Repräsentiert eine Person durch Zeugung mit Namen und Datum
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class Leben
{
  
  //##########################################################################
  /** Initialisiert ein Leben
  */
  //##########################################################################
  public Leben()
  {
  }
  
  //##########################################################################
  /** Konstruiert zufällig eine Person mit Namen und Datum und liefert diese
  */
  //##########################################################################
  public Person zeugen()
  {
    Namen namen = new Namen();
    Datum daten = new Datum(new GregorianCalendar(1900, 0, 1), new GregorianCalendar());
    return new Person(namen.getVorName(), namen.getFamName(), daten.generate());
  }
  
}