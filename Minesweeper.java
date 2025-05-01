import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Minesweeper extends JFrame implements ActionListener {
    JButton easy, medium, hard, expert, home;
    JFrame easyFrame, medFrame, hardFrame, expFrame;
    JTextField title;
    Cell[][] cells;
    int[] dims = {0, 0};
    int x,y;
    Random rand = new Random();
    String mode;
    

    Minesweeper() {
        
        
        title = new JTextField("Minesweeper");
        Font myFont = new Font("Helvetica", Font.BOLD, 30);

        title.setBounds(190, 50, 200, 50);
        title.setFont(myFont);
        title.setEditable(false);


        //the button to call the easy mode of the game
        easy = new JButton("Easy");
        //button location and dimensions
        easy.setBounds(140, 150, 300, 50);
        easy.setFocusable(false);
        //this is what listens if the button is pressed
        easy.addActionListener(this);

        //button to call the medium mode of the game
        medium = new JButton("Medium");
        medium.setBounds(140, 250, 300, 50);
        medium.setFocusable(false);
        medium.addActionListener(this);

        //the button to call the hard mode of the game
        hard = new JButton("Hard");
        hard.setBounds(140, 350, 300, 50);
        hard.setFocusable(false);
        hard.addActionListener(this);

        //the button to call the expert mode of the game
        expert = new JButton("Expert");
        expert.setBounds(140, 450, 300, 50);
        expert.setFocusable(false);
        expert.addActionListener(this);
        

        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(title);
        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.add(expert);


        home = new JButton("HOME");
        home.setBounds(150, 0, 150, 25);
        home.setFocusable(false);
        home.addActionListener(this);
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for(int i = 0; i < dims[0]; i++) {
            for(int j = 0; j < dims[1]; j++) {
                if(e.getSource() == cells[i][j]) {
                    if(cells[i][j].getVal() == "B") {
                        cells[i][j].setEnabled(false);
                        cells[i][j].setText(cells[i][j].getVal());
                        
                        for(i = 0; i < dims[0]; i++) {
                            for(j = 0; j < dims[1]; j++) {
                                if(cells[i][j].getVal() == "B") {
                                    cells[i][j].setBackground(Color.RED);
                                    cells[i][j].setText(cells[i][j].getVal());;
                                    cells[i][j].setEnabled(false);
                                }
                                else {
                                    cells[i][j].setEnabled(false);
                                }
                            }
                        }
                    
                        break;
                    }
                    else{
                        cells[i][j].setEnabled(false);
                        cells[i][j].setText(cells[i][j].getVal());
                    }
                }
            }
        }

        if(e.getSource() == easy) {
            mode = "easy";
            x = 55; y = 50;
            dims[0] = 10; dims[1] = 7;
            cells = new Cell[dims[0]][dims[1]];

            int bombs = 10;
            
            if(easy.getText() == "RESET") {
                easyFrame.dispose();
            }

            easy.setText("RESET");
            easy.setBounds(0, 0, 150, 25);
            
            this.dispose();
            easyFrame = new JFrame("Easy");
            easyFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            easyFrame.setLayout(null);
            easyFrame.setSize(300,400);
            easyFrame.setLocationRelativeTo(null);
            easyFrame.setVisible(true);
            easyFrame.add(easy);
            easyFrame.add(home);
            
//*****************************WILL BE REPLACED LATER********************************************* */
            for(int i = 0; i < dims[0]; i++) {
                
                for(int j = 0; j < dims[1]; j++) {
                    int rng = rand.nextInt(4);
                    int val = 0;
                    if(rng == 0 && bombs != 0) {
                        val = -1;
                        
                        bombs--;
                    }
                    
                    cells[i][j] = new Cell(x, y, val, i, j);
                    cells[i][j].addActionListener(this);
                    cells[i][j].setFocusable(false);
                    cells[i][j].setBorder(BorderFactory.createBevelBorder(1));
                    easyFrame.add(cells[i][j].placeCell());
                    x+=25;
                }
                x = 55;
                y+=25;
            }
//****************************************************************************************** */            
            
        }

        if(e.getSource() == medium) {
            mode = "medium";
            int x = 110, y = 50;
            dims[0] = 10; dims[1] = 14;
            cells = new Cell[dims[0]][dims[1]];

            int bombs = 40;

            if(medium.getText() == "RESET") {
            medFrame.dispose();
            }

            medium.setText("RESET");
            medium.setBounds(0, 0, 150, 25);

            this.dispose();
            medFrame = new JFrame("Medium");
            medFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            medFrame.setLayout(null);
            medFrame.setSize(600,400);
            medFrame.setLocationRelativeTo(null);
            medFrame.setVisible(true);
            medFrame.add(medium);
            medFrame.add(home);

             for(int i = 0; i < dims[0]; i++) {
                
                for(int j = 0; j < dims[1]; j++) {
                    int rng = rand.nextInt(5);
                    int val = 0;
                    if(rng == 0 && bombs != 0) {
                        val = -1;
                        bombs--;
                    }

                    cells[i][j] = new Cell(x, y, val, i, j);
                    cells[i][j].addActionListener(this);
                    cells[i][j].setFocusable(false);
                    cells[i][j].setBorder(BorderFactory.createBevelBorder(1));
                    medFrame.add(cells[i][j].placeCell());
                    val = 0;
                    x+=25;
                }
                x = 110;
                y+=25;
            }
        }

        if(e.getSource() == hard) {
            hardFrame = new JFrame("Hard");
            hardFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            hardFrame.setLayout(null);
            hardFrame.setSize(600,800);
            hardFrame.setLocationRelativeTo(null);
            hardFrame.setVisible(true);
        }

        if(e.getSource() == expert) {
            expFrame = new JFrame("Expert");
            expFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            expFrame.setLayout(null);
            expFrame.setSize(620,850);
            expFrame.setLocationRelativeTo(null);
            expFrame.setVisible(true);
        }
        if(e.getSource() == home) {
            if(mode == "easy") {
                easy.setText(("Easy"));
                easy.setBounds(140, 150, 300, 50);
                easyFrame.dispose();
                
            }
            if(mode == "medium") {
                medium.setText("Medium");
                medium.setBounds(140, 250, 300, 50);
               medFrame.dispose();
            }
            if(mode == "hard") {
                hardFrame.dispose();
            }
            if(mode == "expert") {
                expFrame.dispose();
            }
            this.setTitle("Minesweeper");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setSize(600, 800);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.add(title);
            this.add(easy);
            this.add(medium);
            this.add(hard);
            this.add(expert);
        }

    }

    


    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
    }
}
