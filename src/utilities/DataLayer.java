package utilities;
import objects.Movie;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class reads in the data from a csv file
 * and converts it into a movie object and puts
 * it in an array
 *
 * @version 1.0
 * @author Keny Dutton-Gillespie
 *
 */
public class DataLayer
{
    // TODO: CHANGE BACK NUM OF MOVIES TO 68!!
     final static int NUM_MOVIES = 68;

    /**
     *
     * @return returns the data from the file in an array
     */
    public static Movie[] readData()
    {
        // create new arraylist to store incoming data
        Movie[] movieArray = new Movie[NUM_MOVIES];

        try
        {
            // create new scanner object to read in data from file
            Scanner scanner = new Scanner(new FileReader("movies.csv"));
            // skip over initial line with category names
            scanner.nextLine();


            for (int i = 0; i < movieArray.length; i++)
            {
                String line = scanner.nextLine();
                String[] elements = line.split(",");

                movieArray[i] = new Movie(elements[0],elements[1],elements[2], Integer.parseInt(elements[3]),
                        Double.parseDouble(elements[4]), Integer.parseInt(elements[5]),
                        Double.parseDouble(elements[6]), Integer.parseInt(elements[7]));
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }

        return movieArray;
    }

}
