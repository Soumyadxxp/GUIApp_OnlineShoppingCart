package guiapplicationpack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
public class MainClass
{
    public static void main(String[] args)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int width = tk.getScreenSize().width;
        int height = tk.getScreenSize().height;
        int leftWinXPos = (width - 1300)/2;
        int rightWinXPos = leftWinXPos + 500;
        int leftWinYPos = (height - 280)/2;
        int rightWinYPos = (height - 600)/2;
        
        WindowRight winRight = new WindowRight();
        winRight.setVisible(true);
        winRight.getContentPane().setBackground(new Color(220,250,230));
        winRight.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        winRight.setSize(800, 610);
        winRight.setLocation(rightWinXPos,rightWinYPos);
        winRight.setTitle("List of Products Ordered");
        winRight.setLayout(new BorderLayout());
        
        WindowLeft winLeft = new WindowLeft(winRight);
        winLeft.setVisible(true);
        winLeft.getContentPane().setBackground(new Color(220,250,230));
        winLeft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winLeft.setSize(500, 280);
        winLeft.setLocation(leftWinXPos,leftWinYPos);
        winLeft.setTitle("Product Order Form");
        winLeft.setLayout(new BorderLayout());
        winLeft.setResizable(false);
    }
}