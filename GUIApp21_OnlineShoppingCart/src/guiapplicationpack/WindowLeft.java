package guiapplicationpack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class WindowLeft extends JFrame
{
    private WindowRight winRight = null;
    private JTextField txtCustomer,txtQty;
    private JComboBox cbxProduct;
    private JButton btnSubmit,btnCancel,btnExit;
    private String[] productList = {"Beverage","Condiment","Confection","Dairy Product","Grains/Cereal","Meat/Poultry","Seafood"};
    private int orderSerial = 0;
    
    private JLabel makeLabel(String cap,int x,int y,int w,int h)
    {
        JLabel temp = new JLabel(cap);
        temp.setFont(new Font("Courier New", 1, 16));
        temp.setBounds(x,y,w,h);
        super.add(temp);
        return temp;
    }
    private JTextField makeTextField(int x,int y,int w,int h)
    {
        JTextField temp = new JTextField();
        temp.setFont(new Font("Courier New", 1, 18));
        temp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        temp.setBounds(x,y,w,h);
        temp.setHorizontalAlignment(JTextField.CENTER);
        add(temp);
        return temp;
    }
    private JComboBox makeComboBox(int x,int y,int w,int h,String[] items)
    {
        JComboBox temp = new JComboBox(items);
        temp.setFont(new Font("Verdana", 1, 12));
        temp.setBounds(x,y,w,h);
        add(temp);
        return temp;
    }
    private JButton makeButton(String caption,int x,int y,int w,int h)
    {
        JButton temp = new JButton(caption);
        temp.setBounds(x,y,w,h);
        temp.setFont(new Font("Verdana", 1, 12));
        temp.setMargin(new Insets(0,0,0,0));
        temp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object ob = e.getSource();
                if(ob == btnSubmit)
                {
                    Date dt = new Date();
                    String orderNo = String.format("%d/%02d/%03d",(dt.getYear()+1900),(dt.getMonth()+1),++orderSerial);
                    winRight.setData(orderNo,txtCustomer.getText(),(String)cbxProduct.getSelectedItem(),txtQty.getText());
                    txtCustomer.grabFocus();
                    txtCustomer.selectAll();
                    cbxProduct.setSelectedIndex(0);
                }
                else if(ob == btnCancel)
                {
                    txtCustomer.setText("");
                    txtCustomer.grabFocus();
                    cbxProduct.setSelectedIndex(0);
                    txtQty.setText("");
                }
                else if(ob == btnExit)
                {
                    System.exit(0);
                }
            }
        });
        super.add(temp);
        return temp;
    }
    public WindowLeft(WindowRight right)
    {
        winRight = right;
        Border brdr1 = BorderFactory.createLineBorder(Color.RED, 2);
        Border brdr2 = BorderFactory.createLineBorder(Color.YELLOW, 2);
        Border brdr3 = BorderFactory.createCompoundBorder(brdr1, brdr2);
        JLabel caption = new JLabel("ONLINE SHOPPING CART");
        caption.setBorder(brdr3);
        caption.setOpaque(true);
        caption.setBackground(Color.BLUE);
        caption.setForeground(Color.YELLOW);
        caption.setFont(new Font("verdana",1,25));
        caption.setHorizontalAlignment(JLabel.CENTER);
        caption.setBounds(10,10,470,50);
        super.add(caption);
        
        makeLabel("NAME OF CUSTOMER",10,70,200,30);
        txtCustomer = makeTextField(220,70,260,30);
        makeLabel("NAME OF PRODUCT",10,110,200,30);
        cbxProduct = makeComboBox(220,110,260,30,productList);
        makeLabel("QUANTITY ORDERED",10,150,200,30);
        txtQty = makeTextField(220,150,260,30);
        
        btnSubmit = makeButton("Submit",50,200,100,30);
        btnCancel = makeButton("Cancel",200,200,100,30);
        btnExit = makeButton("Exit",350,200,100,30);
        
        makeLabel("",10,200,10,10);
    }
}
