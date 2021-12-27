package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ibrahim.khaled
 */
public class grid extends javax.swing.JFrame {

    //number of cells
    public static int n=4;
    public static int[][]arr;
    private Container content;
    //cells
    private JButton[][]cells;

    //colors
    private Color selected = Color.GRAY;
    private Color StartEnd = Color.BLACK;
    private Color notSelected = Color.WHITE;

    public grid() {
        super("Rat Maze");
        content = getContentPane();
        content.setLayout(new GridLayout(1, 3));
        JLabel no = new JLabel("Number of Grids N*N");
        JTextField num = new JTextField();
        num.setBounds(200, 200, 200, 200);
        no.setBounds(50, 200, 100, 100);
        Action action = new AbstractAction("Hello Action") {
            public void actionPerformed(ActionEvent e) {
                gridGen(Integer.parseInt(num.getText()));
            }
        };
        num.setAction(action);
        
        content.add(no);
        content.add(num);
        setSize(350, 80);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * Creates new form grid
     */
    public void gridGen(int num) {
        n=num;
         arr = new int [n][n];
          cells = new JButton[n][n];
        initComponents();
        content.removeAll();
        content = getContentPane();
        content.setLayout(new GridLayout(n+1, n));

        //event handler
        ButtonHandler buttonHandler = new ButtonHandler();

        //creat the grid board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new JButton();
                arr[i][j]=0;
                cells[i][j].setBackground(notSelected);

                if (i == 0 && j == 0) {
                    cells[i][j].setBackground(StartEnd);
                    cells[i][j].setText("START");
                    cells[i][j].setForeground(Color.WHITE);
                } else if (i == n - 1 && j == n - 1) {
                    cells[i][j].setBackground(StartEnd);
                    cells[i][j].setText("END");
                    cells[i][j].setForeground(Color.WHITE);

                }
//                else{
//                    cells[i][j]= new JButton();
//                }

                content.add(cells[i][j]);
                cells[i][j].addActionListener(buttonHandler);
            }
        }
        JButton Start=new JButton("START");
        content.add(Start);
        setSize(750, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (source == cells[i][j]) {
                        if (cells[i][j].getBackground() == selected) {
                            cells[i][j].setBackground(notSelected);
                            arr[i][j]=0;
                        } else if (cells[i][j].getBackground() == notSelected) {
                            cells[i][j].setBackground(selected);
                            arr[i][j]=1;
                        }
                        return;
                    }

                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grid().setVisible(true);
            }

        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
