package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Booking_Details extends JFrame{ //Fifth

    JTextField textField;
    JTable table;
    JLabel Sector;
    JLabel FlightCode, Capacity, Classcode, Classname, label;

    public static void main(String[] args) {
        new Booking_Details();
    }

    public Booking_Details(){
	initialize();
    }

    private void initialize(){
        setTitle("FLIGHT_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setSize(860,486);
	setLayout(null);
		
	JLabel Fcode = new JLabel("PHONE NO");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Fcode.setBounds(60, 160, 150, 26);
	add(Fcode);
		
	textField = new JTextField();
	textField.setBounds(200, 160, 150, 26);
	add(textField);
	
        table = new JTable();
	table.setBounds(45, 329, 766, 87);
	add(table);
		
	JButton Show = new JButton("SHOW");
	Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
	Show.setBounds(200, 210, 150, 26);
	add(Show);
	label = new JLabel("");
	label.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/payment.png")));
	label.setBounds(425, 15, 239, 272);
	add(label);
		
	JLabel CName = new JLabel("NAME");
	CName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	CName.setBounds(50, 250, 101, 19);
	add(CName);
		
	JLabel Gender = new JLabel("GENDER");
	Gender.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Gender.setBounds(150, 250, 101, 19);
	add(Gender);
        JLabel Addr = new JLabel("ADDRESS");
	Addr.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Addr.setBounds(250, 250, 101, 19);
	add(Addr);
        JLabel Phno = new JLabel("PHONE NO");
	Phno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Phno.setBounds(340, 250, 101, 19);
	add(Phno);
        JLabel PaymntID = new JLabel("PAYMENT ID");
	PaymntID.setFont(new Font("Tahoma", Font.PLAIN, 13));
	PaymntID.setBounds(430, 250, 101, 19);
	add(PaymntID);
        JLabel Flcd = new JLabel("FLIGHT CODE");
	Flcd.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Flcd.setBounds(520, 250, 101, 19);
	add(Flcd);
        JLabel Flnm = new JLabel("FLIGHT NAME");
	Flnm.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Flnm.setBounds(610, 250, 101, 19);
	add(Flnm);
        JLabel FPrice = new JLabel("TICKET CLASS");
	FPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FPrice.setBounds(700, 250, 101, 19);
	add(FPrice);
	
        setVisible(true);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                try {
                    String ph_no  = textField.getText();
                    
                    conn c = new conn();
                    String str = "select * from passenger where ph_no = '"+ph_no+"'";
					
                    ResultSet rs = c.s.executeQuery(str);
		
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(SQLException e) {
                    e.printStackTrace();
                }
            }
	});
		
	setSize(960,590);
        setLocation(400,200);
	setVisible(true);

    }
}
