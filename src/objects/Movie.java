package objects;

/**
 * This class creates a movie object which defines
 * different characteristics of movies.
 * This class allows these fields to be accessed and set in
 * other classes.
 *
 * @author Keny Dutton-Gillespie
 * @version 1.0
 */
public class Movie{
    private String film;
    private String genre;
    private String studio;
    private int audience;
    private double profit;
    private int rtScore;
    private double worldGross;
    private int year;

    /**
     * @param film the name of the movie
     * @param genre the genre of the movie
     * @param studio the studio that created the movie
     * @param audience the audience score of the movie
     * @param profit the profit that the movie made
     * @param rtScore the Rotten Tomatoes score
     * @param worldGross the world gross amount made by the movie
     * @param year the year the movie was released
     */
    public Movie(String film, String genre, String studio, int audience,
                 double profit, int rtScore,
                 double worldGross, int year) {
        this.setFilm(film);
        this.setGenre(genre);
        this.setStudio(studio);
        this.setAudience(audience);
        this.setProfit(profit);
        this.setRtScore(rtScore);
        this.setWorldGross(worldGross);
        this.setYear(year);
    }

    /**
     * Returns the name of the film.
     * @return the name of the film
     */
    public String getFilm() {
        return film;
    }

    /**
     * Changes the stored name of the film
     * @param film the name of the film
     */
    public void setFilm(String film) {
        this.film = film;
    }

    /**
     * Returns the genre of the movie
     * @return the genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Changes the stored genre of the movie
     * @param genre the genre of the movie
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the studio of the movie
     * @return the studio that made the movie
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the stored studio of the film
     * @param studio the studio that made the movie
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Returns the audience score of the movie
     * @return the audience score of the movie
     */
    public int getAudience() {
        return audience;
    }

    /**
     * Sets the stored audience score of the movie
     * @param audience the audience score of the movie
     */
    public void setAudience(int audience) {
        this.audience = audience;
    }

    /**
     * Returns the profit that the movie made
     * @return the profit the movie made
     */
    public double getProfit() {
        return profit;
    }

    /**
     * Sets the stored value of the profit the movie made
     * @param profit the profit the movie made
     */
    public void setProfit(double profit) {
        this.profit = profit;
    }

    /**
     * Returns the score of the movie on Rotten Tomatoes
     * @return the score on Rotten Tomatoes
     */
    public int getRtScore() {
        return rtScore;
    }

    /**
     * Changes the stored value of the rotten tomatoes score
     * @param rtScore the score of the movie on rotten tomatoes
     */
    public void setRtScore(int rtScore) {
        this.rtScore = rtScore;
    }

    /**
     * Returns the world gross of the movie
     * @return the world gross of the movie
     */
    public double getWorldGross() {
        return worldGross;
    }

    /**
     * Changes the stored value for the world gross of the movie
     * @param worldGross the world gross of the movie
     */
    public void setWorldGross(double worldGross) {
        this.worldGross = worldGross;
    }

    /**
     * Returns the year the movie was released
     * @return the year the movie was released
     */
    public int getYear() {
        return year;
    }

    /**
     * Changes the stored year the movie was released
     * @param year the year the movie was released
     */
    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return
                film + " " +
                        genre + " " +
                        studio + " "
                        + audience + " "
                        + profit + " "
                        + rtScore + " "
                        + worldGross + " "
                        + year
                ;

    }
}