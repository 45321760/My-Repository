package JFrameTest;

import javax.swing.*;

public class Main extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    private Main() {
        super("JFrame by thomasC");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}