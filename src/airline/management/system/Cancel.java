package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Cancel extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) {
        new Cancel();
    }
    
    public Cancel() {
        initialize();
    }
    
    private void initialize() {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel PhoneNo = new JLabel("PHONE NO");
	PhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	PhoneNo.setBounds(60, 100, 132, 26);
	add(PhoneNo);
		
	JLabel FlightNo = new JLabel("FLIGHT NO");
	FlightNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	FlightNo.setBounds(60, 200, 150, 27);
	add(FlightNo);
		
		
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
		
	textField = new JTextField();
	textField.setBounds(250, 100, 150, 27);
	add(textField);
	
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                String ph_no = textField.getText();
		String fl_id = textField_2.getText();
		
					
					
		try{	
                    conn c = new conn();
                    String str2="Insert into cancellation select * from passenger where ph_no='"+ph_no+"' and fl_id='"+fl_id+"'";
                    String str = "DELETE FROM passenger where ph_no='"+ph_no+"' and fl_id='"+fl_id+"'";		
                    c.s.executeUpdate(str);
                    c.s.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null,"Ticket Canceled");
                    setVisible(false);
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}
