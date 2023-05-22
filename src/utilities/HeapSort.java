package utilities;

import objects.Movie;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class places Movie objects into a binary heap
 * and then allows the Movie objects to be sorted.
 *
 * @author Keny Dutton-Gillespie
 * @version 1.0
 */
public class HeapSort {

    private static Movie[] movieArray;

    /**
     *
     * @param movieArray the array to be sorted
     * @param comparator the comparator for how the movies will be sorted
     */
    public static void sort(Movie[] movieArray, Comparator<Movie> comparator)
    {
        // put the array into a heap
        heapify(movieArray, comparator);

        int size = movieArray.length - 1;
        // go through the array and swap the first index with the last
        // index in the array
        // then sink the index down to the bottom of the heap
        for (int i = size; i >= 0; i--) {

            swap(movieArray, 0, i);
            size--;
            sink(0, comparator, movieArray, size);
        }
    }

    /**
     * Puts an array into a legitimate heap structure
     *
     * @param movieArray the array to be placed in the heap
     * @param comparator the value that the Movie objects in the
     *                   array wil be compared to each other by
     */
    public static void heapify(Movie[] movieArray, Comparator<Movie> comparator)
    {
        // loop through the movie array

        for (int i = movieArray.length / 2 - 1; i >= 0; i--) {
            // perform sink to move the objects to the
            // correct place in the heap to make a
            // legitimate heap structure
            sink(i, comparator, movieArray, size(movieArray));
        }

    }

    /**
     * A helper method that will sink items into
     * position where all values above them in the heap
     * will be lower, and all values below them will
     * be higher
     *
     * @param curIndex the index being referenced
     * @param movieComparator the comparator for how the movies will be compared
     * @param movieArray the array that will be manipulated
     * @param size the size of the array
     */
    public static void sink(int curIndex, Comparator<Movie> movieComparator, Movie[] movieArray, int size)
    {
        while (curIndex <= size / 2 )
        {
            int leftChild = 2 * curIndex + 1;
            int rightChild = 2 * curIndex + 2;

            int smallestChildIndex = leftChild;

            // if the right child is larger than its parent, swap them
            if(rightChild < size && movieComparator.compare(movieArray[curIndex], movieArray[rightChild]) > 0)
            {
                //swap(movieArray, curIndex, rightChild);
                swap(movieArray,curIndex,rightChild);
            }

            // if the left child is larger than its parent, swap them
            if(leftChild < size && movieComparator.compare
                    (movieArray[curIndex], movieArray[leftChild]) > 0)
            {
                //swap(movieArray, curIndex, leftChild);
                swap(movieArray,curIndex,smallestChildIndex);
            }

            else
            {
                break; // short circuit if all elements are in order
            }

            // move to the root and repeat the steps
            curIndex = smallestChildIndex;
        }
    }


    /**
     * This method swaps the position of two determined
     * items
     *
     * @param movieArray the array to pull the values from
     * @param firstIndex the first item to be swapped
     * @param secondIndex the second item to be swapped
     */
    public static void swap(Movie[] movieArray, int firstIndex, int secondIndex)
    {
        Movie temp = movieArray[firstIndex];
        movieArray[firstIndex] = movieArray[secondIndex];
        movieArray[secondIndex] = temp;
    }


    /**
     * A helper method to return the size of the array
     * @param movieArray the array to be sized
     * @return the size of the array
     */
    public static int size(Movie[] movieArray)
    {
        return movieArray.length;
    }

    /**
     * Helper method to set the movie array
     * @param movieArray the array to be used
     */
    public static void setMovieArray(Movie[] movieArray)
    {
        HeapSort.movieArray = movieArray;
    }


    @Override
    public String toString()
    {
        int root = 0;
        int nextAvailableIndex = 0;
        return "HeapSort{" +
                "heap=" + Arrays.toString(movieArray) +
                ", nextAvailableIndex=" + nextAvailableIndex +
                ", root=" + root +
                '}';
    }
}
