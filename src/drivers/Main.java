package drivers;
import comparators.FilmComparator;
import objects.Movie;
import utilities.DataLayer;
import java.util.Comparator;

/**
 * @author Keny Dutton-Gillespie
 * @version 1.0
 */
public class Main
{
    /**
     * The main method where the program is run
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args)
    {
        Comparator<Movie> comparator = new FilmComparator();

        ConsoleProgram.printWelcome();
        Movie[] movieArray = DataLayer.readData();
        ConsoleProgram.printOptions();
        ConsoleProgram.runFirstSelection(movieArray,comparator);

    }
}

