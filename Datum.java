/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

//############################################################################
/**
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class Datum
{
  /** Datum der Erstellung des Objektes */
  private GregorianCalendar current;

  /** untere Grenze des zu erstellenden Datum */
  private GregorianCalendar minimum;

  /** obere Grenze des zu erstellenden Datum */
  private GregorianCalendar maximum;

  //############################################################################
  /** Konstruiert ein Datum aus den definierten Werten für die untere und obere
    * Grenze.
  */
  //############################################################################
  public Datum()
  {
    minimum = new GregorianCalendar(1970, 0, 1);
    maximum = new GregorianCalendar();
    current = new GregorianCalendar();
    generate();
  }
  
  //############################################################################
  /** Konstruiert ein Datum aus den übergebenen Werten für die untere und obere
    * Grenze.
  */
  //############################################################################
  public Datum(GregorianCalendar min, GregorianCalendar max)
  {
    minimum = min;
    maximum = max;
    current = new GregorianCalendar();
    generate();
  }
  
  //############################################################################
  /** Liefert des erzeugte Datum
  */
  //############################################################################
  public GregorianCalendar getDatum()
  {
    return current;
  }

  //##########################################################################
  /** Generiert ein formatiertes Datum mittels übergebenem Datum und Format 
    * und liefert dieses
    *
    * @param datum Datum welches formatiert zurück gegeben werden soll
    * @param syntax Format des Datum als Zeichenkette
    *
    * @return Formatierte Zeichenkette
  */
  //##########################################################################
  public static String format(GregorianCalendar datum, String syntax)
  {
    SimpleDateFormat format = new SimpleDateFormat(syntax);
    return String.format(format.format(datum.getTime()));
  }
  
  //############################################################################
  /** Generiert das aktuelle Datum zwischen der unteren und oberen Granze und 
    * liefert dieses am Anfang des Tages.
    *
    * @return Generiertes Datum
  */
  //############################################################################
  public GregorianCalendar generate()
  {
    long min = minimum.getTimeInMillis();
    long max = maximum.getTimeInMillis();

    Generator zufall = new Generator(min, max);
    current.setTimeInMillis(zufall.langzahl());

    return new GregorianCalendar(current.get(current.YEAR), current.get(current.MONTH), current.get(current.DAY_OF_MONTH));
  }
  
  //############################################################################
  /** Generiert eine Liste zufällig generierter Daten mittels übergebener Anzahl
    * und liefert dieses.
    *
    * @param anzahl Anzahl der in der Liste enthaltenen Elemente
    *
    * @return Liste mit zufälligen Daten
  */
  //############################################################################
  public ArrayList<Datum> generateList(int anzahl)
  {
    ArrayList<Datum> liste = new ArrayList<Datum>();
    for (int i = 0; i < anzahl; i++)
    {
      liste.add(new Datum(minimum, maximum));
    }
    return liste;
  }
}