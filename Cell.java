import javax.swing.*;

public class Cell extends JButton {
    Cell(int x, int y, int value, int row, int col) {
        
        this.xPos = x;
        this.yPos = y;
        this.value = value;
        this.row = row;
        this.col = col;

    }

    public JButton placeCell() {

        // this.button.setBounds(this.xPos, this.yPos, dims, dims);
        // return this.button;
        this.setBounds(this.xPos, this.yPos, this.dims, this.dims);
        return this;
    }

    public void updateValue(int numBombs) {
        this.value = numBombs;
    }

    public boolean isBomb() {
        if(this.value < 0) {
            return true;    
        }
        else {
            return false;
        }
    }
    
    public String getVal() {
        if(this.value == 0) {
            return "";
        }
        else if (this.value < 0) {
            return "B";
        }
        else {
            return String.valueOf(value);
        }
        
    }

    public int getRow() {
        return this.row;
    }
    
    public int getColumn() {
        return this.col;
    }


    private int dims = 25;
    private int xPos, yPos, value, row, col;
    //private JButton button;
}