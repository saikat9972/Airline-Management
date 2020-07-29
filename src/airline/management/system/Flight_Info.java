package airline.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Flight_Info().setVisible(true);    
    }
    
    public Flight_Info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    conn c = new conn();
                    String str = "select flight.f_code,flight.f_name,flight.src,flight.dst,sector.capacity,sector.class_code,sector.class_name,sector.ticket_price from sector,flight where flight.f_code=sector.flight_code and flight.f_code= '"+code+"'";
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel FlightCode = new JLabel("FLIGHT CODE");
	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        FlightCode.setBounds(24, 220, 126, 14);
	add(FlightCode);
		
	JLabel FlightName = new JLabel("FLIGHT NAME");
        FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FlightName.setBounds(128, 220, 120, 14);
	add(FlightName);
		
	JLabel Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(250, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(340, 220, 120, 14);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("CAPACITY");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(440, 220, 111, 14);
	add(Capacity);
		
	JLabel ClassCode = new JLabel("CLASS CODE");
	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassCode.setBounds(530, 220, 120, 14);
	add(ClassCode);
		
	JLabel ClassName = new JLabel("CLASS NAME");
	ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassName.setBounds(625, 220, 111, 14);
	add(ClassName);
        
	JLabel Price = new JLabel("PRICE");
	Price.setFont(new Font("Tahoma", Font.BOLD, 13));
	Price.setBounds(730, 220, 100, 14);
	add(Price);	
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}