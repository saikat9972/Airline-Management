package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Flights extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,flcode,Ticketid,Fcode,Jnydate,Jnytime,flname,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Flights();
    }
    
    public Flights(){
        
        setTitle("FLIGHTS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	flname = new JLabel("SOURCE");
	flname.setFont(new Font("Tahoma", Font.PLAIN, 19));
	flname.setBounds(60, 100, 150, 27);
	add(flname);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("FLIGHTS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(350, 27, 359, 31);
	add(ReservationDetails);
		
	flcode = new JLabel("FLIGHT CODE");
	flcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	flcode.setBounds(79, 270, 83, 20);
	add(flcode);
		
		
	flname = new JLabel("FLIGHT NAME");
	flname.setFont(new Font("Tahoma", Font.PLAIN, 13));
	flname.setBounds(613, 270, 94, 20);
	add(flname);
	String[] items1 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    
                    String str = "select f_code , f_name from flight where src= '"+src+"' and dst = '"+dst+"'";
                    ResultSet rs=c.s.executeQuery(str);					
                    table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}catch(Exception e){}
            }
	});
		
	setSize(860,600);
        setLocation(400,200);
	setVisible(true);
		
    }
}
