package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("Simple GUI With File Chooser");
    private static final int PROPORTION = 6;
    private final Controller con;

    public SimpleGUIWithFileChooser() {
        con = new Controller();
        final JPanel canva = new JPanel();
        final JPanel inner = new JPanel();

        final JTextField txtField = new JTextField("Text field");
        final JButton browse = new JButton("Browse...");
        final JButton save = new JButton("Save");
        final JTextArea textArea = new JTextArea("Text Area");

        final JFileChooser chooser = new JFileChooser();
        txtField.setEditable(true);
        txtField.setText(con.getCurrentFilePath());

        canva.setLayout(new BorderLayout());
        inner.setLayout(new BorderLayout());

        canva.add(save, BorderLayout.SOUTH);
        canva.add(inner, BorderLayout.NORTH);
        inner.add(txtField, BorderLayout.CENTER);
        canva.add(textArea, BorderLayout.CENTER);
        inner.add(browse, BorderLayout.LINE_END);
        frame.setContentPane(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final int ret = chooser.showSaveDialog(null);
                switch (ret) {
                    case JFileChooser.APPROVE_OPTION:
                        con.setCurrentFile(chooser.getSelectedFile());
                        txtField.setText(con.getCurrentFilePath());

                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(chooser, "An error has occured", null, JOptionPane.ERROR_MESSAGE);
                        break;
                }

            }

        });
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

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
