package comparators;

import objects.Movie;

import java.util.Comparator;

/**
 * This class instructs how films will
 * be compared based on their world gross earnings
 *
 * @author Keny Dutton
 * @version 1.0
 */
public class WorldGrossComparator implements Comparator<Movie>
{

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     * @param first the first object to be compared.
     * @param second the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     **/

    @Override
    public int compare(Movie first, Movie second)
    {
        return (int) (second.getWorldGross() - first.getWorldGross());
    }
}
