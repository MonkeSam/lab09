package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * Set the next string to print.
     * 
     * @param next next string
     * 
     * @throws NullPointerException Passing a null value is not accepted
     */
    void setNext(String next);

    /**
     * 
     * @return next string to print
     */
    String getNext();

    /**
     * 
     * @return history of printed strings
     * 
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     * 
     * @throws IllegalStateException
     */
    void printCurrent();

}
