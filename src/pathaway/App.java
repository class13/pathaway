package pathaway;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

  public static void main(String[] args) {
    final JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final LineComponent comp = new LineComponent();
    comp.setPreferredSize(new Dimension(320, 200));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    final JPanel buttonsPanel = new JPanel();
    final JButton newLineButton = new JButton("New Line");
    final JButton clearButton = new JButton("Clear");
    buttonsPanel.add(newLineButton);
    buttonsPanel.add(clearButton);
    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    newLineButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        comp.distortPath();
      }
    });
    clearButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    testFrame.pack();
    testFrame.setVisible(true);
  }
}
