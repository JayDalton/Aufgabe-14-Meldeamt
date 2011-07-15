/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

//############################################################################
/** Repräsentiert eine Meldeamt und dessen Methoden zum Registrieren von Personen
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class MeldeAmt
{
  /**  */
  private int anzahl;
  
  /**  */
  private ArrayList<Person> register = new ArrayList<Person>();
  
  //##########################################################################
  /** Initialisiert das Meldeamt durch übergebene Anzahl von Personen
    *
    * @param dieAnzahl Anzahl der Personen
  */
  //##########################################################################
  public MeldeAmt(int dieAnzahl)
  {
    anzahl = dieAnzahl;
    register();
  }
  
  //##########################################################################
  /** Registriert die zu meldenen zufällig erstellten Personen im Register
  */
  //##########################################################################
  public void register()
  {
    Leben leben = new Leben();
    for (int i = 0; i < anzahl; i++)
    {
      register.add(leben.zeugen());
    }
  }
  
  //##########################################################################
  /** Schreibt die Liste der Personen alphabetisch sortiert
  */
  //##########################################################################
  public void listeAlpha()
  {
    Person person;
    Comparator<Person> comparator = new ComparatorAlpha();
    Collections.sort(register, comparator);

    System.out.format("\n---------------------------------------");
    System.out.format("\n---- Liste sortiert nach Alpha   ------");
    System.out.format("\n---------------------------------------");
    
    for (int i = 0; i < register.size(); i++)
    {
      person = register.get(i);
      System.out.format("\n%6d %-10s %-10s %-12s", i + 1, person.getVorName(), person.getFamName(), Datum.format(person.getGebDatum(), "dd.MM.yyyy"));
    }
  }

  //##########################################################################
  /** Schreibt die Liste der Personen nach Alter sortiert
  */
  //##########################################################################
  public void listeAlter()
  {
    Person person;
    Comparator<Person> comparator = new ComparatorAlter();
    Collections.sort(register, comparator);

    System.out.format("\n---------------------------------------");
    System.out.format("\n---- Liste sortiert nach Alter   ------");
    System.out.format("\n---------------------------------------");
    
    for (int i = 0; i < register.size(); i++)
    {
      person = register.get(i);
      System.out.format("\n%6d %-10s %-10s %-12s", i + 1, person.getVorName(), person.getFamName(), Datum.format(person.getGebDatum(), "dd.MM.yyyy"));
    }
  }
  
  //##########################################################################
  /** Schreibt die Liste der Personen dessen Geburtstag gesucht ist
    *
    * @param current Gesuchtes Geburtsdatum
  */
  //##########################################################################
  public void listeDatum(GregorianCalendar current)
  {
    Person person;
    ArrayList<Person> liste = new ArrayList<Person>();
    Comparator<Person> comparator = new ComparatorAlpha();

    System.out.format("\n---------------------------------------");
    System.out.format("\n---- Geburtsdatum %s ", Datum.format(current, "dd. MMMM yyyy"));
    System.out.format("\n---------------------------------------");
    
    for (int i = 0, j = 0; i < register.size(); i++)
    {
      person = register.get(i);
      if (current.getTimeInMillis() == person.getGebDatum().getTimeInMillis()) {
        liste.add(person);
      }
    }
    Collections.sort(liste, comparator);
    for (int i = 0; i < liste.size(); i++)
    {
      System.out.format("\n%6d %-10s %-10s", i + 1, liste.get(i).getVorName(), liste.get(i).getFamName());
    }
  }

  
}