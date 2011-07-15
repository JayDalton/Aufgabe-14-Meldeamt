/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.GregorianCalendar;

//############################################################################
/** Repräsentiert Verkauf von Zeitungen eines Verlages
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class MeldeAmtMain
{
  /** Anzahl der an zu meldenden Personen im Meldeamt */
  static int anzahl;

  /** Auswahl des Programmodus und desses Sortierung */
  static String auswahl;

  /** Datum der zu suchenden Personen im Register */
  static GregorianCalendar current;

  //##########################################################################
  /** Programmaufruf zur Steuerung des Umsatzes MeldeAmtes
  */
  //##########################################################################
	public static void main(String[] args)
	{
    if (validiereArgs(args))
    {
      Ausgabe.leere();
  		Ausgabe.zeile("\n\n\tE i n w o h n e r m e l d e a m t\n\n");
  		Ausgabe.zeile("Melde dich an ...");
      
      MeldeAmt meldeAmt = new MeldeAmt(anzahl);
      
      if (auswahl.contains("-alpha")) {
        meldeAmt.listeAlpha();
      }

      if (auswahl.contains("-alter")) {
        meldeAmt.listeAlter();
      }

      if (auswahl.contains("-datum")) {
        meldeAmt.listeDatum(current);
      }
      
      Ausgabe.zeile("\n\n\tAuf Wiedersehen!\n\n");
      
  	} else {
      schreibeAnleitung();
    }
  }

  //##########################################################################
  /** Validiert die übergebenen Parameter aud Anzahl und Datentyp
    *
    * @param args Eine zu prüfende Liste von Zeichenketten
    *
    * @return Ergebnis der Prüfung
  */
  //##########################################################################
  private static boolean validiereArgs(String[] args)
  {
    boolean ergebnis = false;
    if (args.length == 2 || args.length == 5)
    {
      try {
        anzahl = Integer.parseInt(args[0]);
        auswahl = new String(args[1]);
        ergebnis = ((200 <= anzahl) && (anzahl <= 100000)) && (auswahl.contains("-alpha") || auswahl.contains("-alter")) ? true : false;

        if (args.length == 5 && auswahl.contains("-datum"))
        {
          GregorianCalendar maximum = new GregorianCalendar();
          GregorianCalendar minimum = new GregorianCalendar(1900, 0, 1);
          current = new GregorianCalendar(Integer.parseInt(args[4]), Integer.parseInt(args[3]) - 1, Integer.parseInt(args[2]));
          ergebnis = (minimum.getTimeInMillis() < current.getTimeInMillis() && current.getTimeInMillis() < maximum.getTimeInMillis() ) ? true : false;
        }
      } catch (NumberFormatException nfe) {
      }
    }
    return ergebnis;
  }
  //##########################################################################
  /** Schreibt eine Anleitung zum Programmaufruf in die Standardausgabe
  */
  //##########################################################################
  private static void schreibeAnleitung()
  {
    System.out.format("\nBenutzung   : java MeldeAmtMain anzahl auswahl <tag> <monat> <jahr>");
    System.out.format("\nanzahl      : Ganzzahl [200 <= n <= 100000]");
    System.out.format("\nauswahl     : Symbol   [-alpha | -alter | -datum]");
    System.out.format("\ntag         : Ganzzahl [1 <= n <= 31]");
    System.out.format("\nmonat       : Ganzzahl [1 <= n <= 12]");
    System.out.format("\njahr        : Ganzzahl [1900 <= n <= heute]");
    System.out.format("\n\n");
  }
}


