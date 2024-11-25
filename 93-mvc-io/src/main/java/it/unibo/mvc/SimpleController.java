package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String next;
    private final List<String> history;

    /**
     * Controller Setup.
     */
    public SimpleController() {
        history = new ArrayList<>();
        this.next = null;
    }

    @Override
    public void setNext(final String next) {
        this.next = Objects.requireNonNull(next, "String can't be null");
    }

    @Override
    public String getNext() {
        return this.next;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(this.history);
    }

    @Override
    public void printCurrent() {
        if (this.next == null) {
            throw new IllegalStateException();
        }
        this.history.add(this.next);
        System.out.println(this.next); // NOPMD: allowed in exercises

    }

}
