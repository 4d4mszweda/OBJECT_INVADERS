import display.Board;

import javax.swing.*;

public class Main extends JFrame {
    private JFrame frame;
    public Main() {
        frame = new JFrame("SPACE INVADERS");
        frame.setSize(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new Board(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}