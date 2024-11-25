package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * Set the next string to print.
     * 
     * @param next
     * 
     * @throws NullPointerException Passing a null value is not accepted
     */
    public void setNext(final String next);

    /**
     * 
     * @return next string to print
     */
    public String getNext();

    /**
     * 
     * @return history of printed strings
     * 
     */
    public List<String> getHistory();

    /**
     * Prints the current string.
     * 
     * @throws IllegalStateException
     */
    public void printCurrent();

}
