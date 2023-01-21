package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Money_Calculator_View extends JFrame{
    

    public Money_Calculator_View(String title, JPanel panel) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);    
    }
    
    
    
}
