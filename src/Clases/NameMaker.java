package Clases;

/**
 * Class to make some names
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class NameMaker{
    
    /**
     * Method to make a "random" name
     * @return String
     */
    public static String nameRandom(){
        String[] nombres = { "Andres", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
        "Bartolome", "Baruc", "Baruj", "Johan", "Carlos", "Canelo", "Jose", "Golovkin", "Eduardo",
        "Carlo", "Bruno", "Baltazar", "Pedro", "Alejandro", "Mohammed", "Rene", "Mauricio", "Kevin", "Julian",
         "Marco", "Patricio", "Cujo", "Hector", "Alonso", "Esteban", "Saul", "Anshar", "Patrick", "Wallace", "Bojack"};

String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
        "Carion", "Carmona", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
        "Grigalva", "Rubio", "Perez", "Ali", "Tyson", "Alvarez", "Garchuz", "Plaez", "Baez", "Smith", "De Jesus", "Castillo", "Holland", "Linares", "Estrada" };
        String name= nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
        + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
        return name;
    }

}