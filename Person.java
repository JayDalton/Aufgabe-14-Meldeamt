/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.GregorianCalendar;

//############################################################################
/** Repräsentiert eine Person durch Vornamen, Nachnamen und Geburtsdatum.
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class Person
{
  /** Vorname der Person */
  private String vorName;

  /** Nachname der Person */
  private String famName;

  /** Geburtsdatum der Person */
  private GregorianCalendar gebDatum;
  
  //##########################################################################
  /** Initialisiert die Person
    *
    * @param derVorName Der Vorname der Person
    * @param derFamName Der Nachname der Person
    * @param dasGebDatum Das Geburtsdatum der Person
  */
  //##########################################################################
  public Person(String derVorName, String derFamName, GregorianCalendar dasGebDatum)
  {
    vorName = derVorName;
    famName = derFamName;
    gebDatum = dasGebDatum;
  }
  
  //##########################################################################
  /** Liefert den Vornamen der Person
    *
    * @return Der Vorname
  */
  //##########################################################################
  public String getVorName()
  {
    return vorName;
  }
  
  //##########################################################################
  /** Liefert den Nachnamen der Person
    *
    * @return Der Nachname
  */
  //##########################################################################
  public String getFamName()
  {
    return famName;
  }
  
  //##########################################################################
  /** Liefert das Geburtsdatum der Person
    *
    * @return Der Nachname
  */
  //##########################################################################
  public GregorianCalendar getGebDatum()
  {
    return gebDatum;
  }
    
}