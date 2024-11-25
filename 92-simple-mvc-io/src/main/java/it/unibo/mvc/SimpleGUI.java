package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "My first Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final JPanel canva;
    private final Controller con;
    private static final int PROPORTION = 6;

    /**
     * Setup a SimpleGUI.
     */
    public SimpleGUI() {
        con = new Controller();
        canva = new JPanel();
        canva.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        final JTextArea textArea = new JTextArea("File Content");
        canva.add(textArea);
        canva.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    con.saveOnFile(textArea.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, e1, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    /**
     * Displays the SimpleGUI.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);

    }

    /**
     * Main method that starts the graphical application.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
