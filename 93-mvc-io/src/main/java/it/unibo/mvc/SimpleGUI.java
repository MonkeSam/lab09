package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 6;

    private final JFrame frame = new JFrame("SIMPLE GUI");
    private final SimpleController controller;

    /**
     * SimpleGUI constructor sets up GUI.
     */
    public SimpleGUI() {
        controller = new SimpleController();
        final JPanel canva = new JPanel();
        final JPanel inner = new JPanel();

        final JTextField textField = new JTextField("texfield");
        final JTextArea tArea = new JTextArea("tArea");
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show history");

        canva.setLayout(new BorderLayout());
        inner.setLayout(new BorderLayout());
        tArea.setLineWrap(true);
        canva.add(inner, BorderLayout.SOUTH);
        inner.add(print, BorderLayout.LINE_START);
        inner.add(history, BorderLayout.LINE_END);
        canva.add(tArea, BorderLayout.CENTER);
        canva.add(textField, BorderLayout.NORTH);

        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNext(textField.getText());
                controller.printCurrent();
            }

        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                tArea.setText(controller.getHistory().toString());
            }

        });
    }

    /**
     * Displays SimpleGUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Main method that create and display SimpleGUI.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
