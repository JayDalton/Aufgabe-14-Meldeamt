/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/**
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class Namen
{
  //############################################################################
  /** Listet alle Vornamen als Vorat für die Generierung eines vollständigen Namen
  */
  //############################################################################
  private String[] rufname = {
    "Stefanie", "Stephanie", "Catrin", "Katrin", "Kathrin", "Sandra", "Julia", "Nadine", "Nicole", "Melanie", "Anna", "Claudia", "Jessica", "Jessika", "Christina", 
    "Daniela", "Nina", "Katharina", "Katja", "Annika", "Anja", "Sabrina", "Andrea", "Ivonne", "Yvonne", "Anne", "Sarah", "Sara", "Diana", "Christine", "Kerstin", 
    "Jennifer", "Christin", "Kristin", "Carolin", "Caroline", "Karoline", "Bianca", "Bianka", "Maike", "Meike", "Susanne", "Tanja", "Franziska", "Svenja", "Sonja", 
    "Christian", "Sebastian", "Stefan", "Stephan", "Daniel", "Thomas", "Jan", "Alexander", "Matthias", "Andreas", "Dennis", "Michael", "Marcus", "Markus", "Martin", 
    "Florian", "Benjamin", "Tobias", "Sven", "Philip", "Philipp", "Christoph", "Patrick", "Marco", "Marko", "Björn", "Sascha", "Robert", "Johannes", "Oliver", 
    "Marcel", "Andre", "André", "Bastian", "David", "Frank", "Nils", "Niels", "Jens", "Marc", "Mark", "René"
  };

  //############################################################################
  /** Listet alle Nachnamen als Vorat für die Generierung eines vollständigen Namen
  */
  //############################################################################
  private String[] famname = {
    "Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz", "Hoffmann", "Schäfer", "Koch", "Bauer", "Richter", "Klein", 
    "Wolf", "Schröder", "Schneider", "Neumann", "Schwarz", "Zimmermann", "Braun", "Krüger", "Hofmann", "Hartmann", "Lange", "Schmitt", "Werner", "Schmitz", 
    "Krause", "Meier", "Lehmann", "Schmid", "Schulze", "Maier", "Köhler", "Herrmann", "König", "Walter", "Mayer", "Huber", "Kaiser", "Fuchs", "Peters", 
    "Lang", "Scholz", "Möller", "Weiß", "Jung", "Hahn", "Schubert", "Vogel", "Friedrich", "Keller", "Günther", "Frank", "Berger", "Winkler", "Roth", 
    "Beck", "Lorenz", "Baumann", "Franke", "Albrecht", "Schuster", "Simon", "Ludwig", "Böhm", "Winter", "Kraus", "Martin", "Schumacher", "Krämer", 
    "Vogt", "Stein", "Jäger", "Otto", "Sommer", "Groß", "Seidel", "Heinrich", "Brandt", "Haas", "Schreiber", "Graf", "Schulte", "Dietrich", "Ziegler", 
    "Kuhn", "Kühn", "Pohl", "Engel", "Horn", "Busch", "Bergmann", "Thomas", "Voigt", "Sauer", "Arnold", "Wolff", "Pfeiffer"
  };
  
  //############################################################################
  /** Liefert einen zufällig erzeugten Namen aus Vor- / Zunamen als Zeichenkette
    *
    * @return Erzeugter Name
  */
  //############################################################################
  public String getVorName()
  {
    return rufname[Generator.ganzzahl(0, rufname.length - 1)];
  }

  //############################################################################
  /** Liefert einen zufällig erzeugten Namen aus Vor- / Zunamen als Zeichenkette
    *
    * @return Erzeugter Name
  */
  //############################################################################
  public String getFamName()
  {
    return famname[Generator.ganzzahl(0, rufname.length - 1)];
  }

  //############################################################################
  /** Liefert einen zufällig erzeugten Namen aus Vor- / Zunamen als Zeichenkette
    *
    * @return Erzeugter Name
  */
  //############################################################################
  public String getName()
  {
    return getVorName() + " " + getFamName();
  }
  
  //############################################################################
  /** Liefert eine Liste zufällig erzeugter Namen aus Vor- / Zunamen als
    * Zeichenkette
    *
    * @param anzahl der in der Liste enthaltenen Elemente
    *
    * @return Liste mit zufälligen Namen
  */
  //############################################################################
  public String[] erzeugeListe(int anzahl)
  {
    String[] liste = new String[anzahl];
    for (int i = 0; i < anzahl; i++)
    {
      liste[i] = getName();
    }
    return liste;
  }

}