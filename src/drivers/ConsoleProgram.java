package drivers;

import comparators.*;
import objects.Movie;
import utilities.HeapSort;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Keny Dutton-Gillespie
 * @version 1.0
 *
 * This class runs all text that the user will see
 * when running the console program and takes in input from
 * the user and outputs formatted data based on their selection
 */
public class ConsoleProgram
{
    static final int NUM_MOVIES = 68;

    /**
     * A method that prints the welcome message for
     * the movie night application
     */
    public static void printWelcome()
    {
        System.out.println("**************************************");
        System.out.println("Welcome to the Movie Night Application\n");
        System.out.println("This program will display movie suggestions");
        System.out.println("and allow you to sort movies in different\nways");
        System.out.println("**************************************\n");
        System.out.println();

    }

    /**
     * A method that prints the options for how to
     * interact with the program
     */
    public static void printOptions()
    {
        System.out.println("Pick from the following:");
        System.out.println("1. Show all movies");
        System.out.println("2. Show a random movie");
        System.out.println("3. Sort a movie");
        System.out.println("4. Exit");
        System.out.println();
    }

    /**
     * A method that allows the user to select how to sort the movies
     * @param movieArray the array to perform sorts on
     * @param comparator the comparator to be used to sort the data
     */
    public static void chooseComparator(Movie[] movieArray, Comparator<Movie> comparator)
    {
        System.out.println("Enter a comparator:");
        System.out.println("""
                1. By film
                2. By genre
                3. By studio
                4. By audience
                5. By profit
                6. By RT score
                7. By world gross
                8. By year""");

        runComparatorSelection(movieArray, comparator);
    }

    /**
     * A method that prints the headers for each
     * film category
     */
    public static void printRecordHeaders()
    {
        System.out.println();
        System.out.printf("%-45s", "FILM");
        System.out.printf("%-25s", "GENRE");
        System.out.printf("%-35s", "STUDIO");
        System.out.printf("%-20s", "AUDIENCE");
        System.out.printf("%-20s", "PROFIT");
        System.out.println();

    }

    /**
     * A method that prints a formated view of
     * unsorted movies beneath headers
     * @param movieArray the movie array to print
     */
    public static void returnMovieData(Movie[] movieArray)
    {
        printRecordHeaders();

        for (Movie movie : movieArray) {
            System.out.printf("%-45s", movie.getFilm());
            System.out.printf("%-25s", movie.getGenre());
            System.out.printf("%-35s", movie.getStudio());
            System.out.printf("%-20s", movie.getAudience());
            System.out.printf("%-20s", movie.getProfit());
            System.out.println();

        }
    }

    /**
     * A method that generates a random number and
     * selects a movie to display
     *
     * @param movieArray the array to pull data from
     */
    public static void returnRandom(Movie[] movieArray)
    {
        Random random = new Random();
        int randomMovie = random.nextInt(NUM_MOVIES-1);

        printRecordHeaders();
        System.out.printf("%-45s", movieArray[randomMovie].getFilm());
        System.out.printf("%-25s", movieArray[randomMovie].getGenre());
        System.out.printf("%-35s", movieArray[randomMovie].getStudio());
        System.out.printf("%-20s", movieArray[randomMovie].getAudience());
        System.out.printf("%-20s", movieArray[randomMovie].getProfit());
        System.out.println();
    }


    /**
     * This method reads in the input from the console
     * when the user is prompted to do so
     * @return user input from the console
     */
    public static int readUserInput()
    {
        Scanner userScan = new Scanner(System.in);

        int userInput = Integer.parseInt(userScan.nextLine());
        System.out.println();
        System.out.println("You have selected " + userInput);
        System.out.println();
        return userInput;

    }

    /**
     * This method takes in input from the user
     * and allows them to select how they want
     * to use the program
     * @param movieArray the array to pull the data from
     * @param comparator the comparator to use to sort the data
     */
    public static void runFirstSelection(Movie[] movieArray, Comparator<Movie> comparator)
    {

        int option = readUserInput();
        switch (option) {
            case 1 -> returnMovieData(movieArray);
            case 2 -> returnRandom(movieArray);
            case 3 -> chooseComparator(movieArray, comparator);
            case 4 -> System.out.println("Thanks for using the Movie Night Application! Goodbye.");
        }
    }

    /**
     * This console determines which comparators get used
     * when the user makes a selection
     * @param movieArray the array to pull the data from
     * @param comparator the comparator that you'll reassign
     * @return return the comparator object to use
     */
    public static void runComparatorSelection(Movie[] movieArray, Comparator<Movie> comparator)
    {
        int option = readUserInput();

        switch (option) {
            case 1 -> comparator = new FilmComparator();
            case 2 -> comparator = new GenreComparator();
            case 3 -> comparator = new StudioComparator();
            case 4 -> comparator = new AudienceComparator();
            case 5 -> comparator = new ProfitComparator();
            case 6 -> comparator = new RTComparator();
            case 7 -> comparator = new WorldGrossComparator();
            case 8 -> comparator = new YearComparator();
        }

        HeapSort.sort(movieArray, comparator);
        printSorted(movieArray);

    }

    /**
     * A method to print the array after it's been sorted.
     * @param movieArray the array
     *
     */
    public static void printSorted(Movie[] movieArray)
    {
        printRecordHeaders();

        for (Movie movie : movieArray) {
            System.out.printf("%-45s", movie.getFilm());
            System.out.printf("%-25s", movie.getGenre());
            System.out.printf("%-35s", movie.getStudio());
            System.out.printf("%-20s", movie.getAudience());
            System.out.printf("%-20s", movie.getProfit());
            System.out.println();
        }
    }


}
