package guiapplicationpack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class WindowRight extends JDialog
{
    private JTable tblData;
    private JScrollPane spnData;
    private DefaultTableModel tModel;
    private JButton btnPrint,btnClose;
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
                if(ob == btnPrint)
                {
                    try
                    {
                        tblData.print();
                    }
                    catch(Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
                else if(ob == btnClose)
                {
                    dispose();
                }
            }
        });
        super.add(temp);
        return temp;
    }
    public void setData(String orderNo,String customer,String product,String qty)
    {
        tModel.addRow(new String[]{orderNo,customer,product,qty});
    }
    public WindowRight()
    {
        Border brdr1 = BorderFactory.createLineBorder(Color.RED, 2);
        Border brdr2 = BorderFactory.createLineBorder(Color.YELLOW, 2);
        Border brdr3 = BorderFactory.createCompoundBorder(brdr1, brdr2);
        JLabel caption = new JLabel("LIST OF ORDERS PLACED");
        caption.setBorder(brdr3);
        caption.setOpaque(true);
        caption.setBackground(Color.BLUE);
        caption.setForeground(Color.YELLOW);
        caption.setFont(new Font("verdana",1,25));
        caption.setHorizontalAlignment(JLabel.CENTER);
        caption.setBounds(10,10,770,50);
        super.add(caption);
        
        tModel = new DefaultTableModel(new String[]{"ORDER NO.","CUSTOMER NAME","PRODUCT NAME","QUANTITY"},0);
        tblData = new JTable(tModel);
        tblData.setRowHeight(25);
        tblData.setFont(new Font("courier new",1,16));
        spnData = new JScrollPane(tblData);
        spnData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spnData.setBounds(10,70,770,450);
        add(spnData);
        
        btnPrint = makeButton("Print",167,530,150,30);
        btnClose = makeButton("Close",484,530,150,30);
        
        JLabel lbl = new JLabel();
        lbl.setBounds(10,10,20,20);
        add(lbl);
    }
}
