package projekt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Kansliet extends JPanel {
	
	private JPanel panel = new JPanel();
	private JPanel panelband = new JPanel();
	private JLabel bokaband = new JLabel("Skriv bandnamn:");
	private JLabel medlem = new JLabel("Skriv medlemsnamn:");
	private JLabel kontaktperson = new JLabel("Skriv bandnamn:");
	private JLabel prn = new JLabel("Skriv kontaktpersonens personnummer:");
	private JLabel kontaktband = new JLabel("Skriv in bandnamn igen:");
	private JLabel spelband = new JLabel("Skriv bandnamn:");
	private JLabel spelplats = new JLabel("Skriv scen:");
	private JLabel speltid = new JLabel("Skriv tid:");
	private JLabel spelbandinfo = new JLabel("Skriv bandinfo:");
	private JLabel kansliet = new JLabel("Kansliet");
	private JButton btnboka = new JButton("Boka band");
	private JButton btnkontakt = new JButton("Boka kontakperson");
	private JButton btnspel = new JButton("Boka spelning");
	private JTextArea textmedlem;
	private JTextArea textband;
	private JTextArea textkontakt = new JTextArea();
	private JTextArea textprn = new JTextArea();
	private JTextArea textspelband = new JTextArea();
	private JTextArea textspelplats = new JTextArea();
	private JTextArea textspeltid = new JTextArea();
	private JTextArea textspelbandinfo = new JTextArea();
	private kListener klist = new kListener();


	//private JComboBox box = new JComboBox();



	
	public Kansliet() {
		textband = new JTextArea();
		textmedlem = new JTextArea("hej");
		
		btnboka.addActionListener(klist);
		btnkontakt.addActionListener(klist);
		btnspel.addActionListener(klist);
		
		panel.setPreferredSize(new Dimension(600,600));
		panel.setLayout(null);
		textmedlem.setBackground(Color.LIGHT_GRAY);
		textband.setBackground(Color.LIGHT_GRAY);
		textkontakt.setBackground(Color.LIGHT_GRAY);
		textspelband.setBackground(Color.LIGHT_GRAY);
		textspelplats.setBackground(Color.LIGHT_GRAY);
		textspeltid.setBackground(Color.LIGHT_GRAY);
		textspelbandinfo.setBackground(Color.LIGHT_GRAY);
		textprn.setBackground(Color.LIGHT_GRAY);
		panel.setBackground(Color.WHITE);
		
//		box.addItem("band1");
//		box.addItem("band2");
//		box.addItem("band3");
//		box.addItem("band4");
//		box.addItem("band5");
//		box.setSelectedItem(null);

		
		this.add(panel);
		this.add(kansliet);
		this.add(bokaband);
		this.add(btnboka);
		this.add(medlem);
		this.add(textband);
		this.add(textmedlem);
		this.add(kontaktperson);
		this.add(textkontakt);
		this.add(kontaktband);
		this.add(btnkontakt);
		this.add(spelband);
		this.add(speltid);
		this.add(spelbandinfo);
		this.add(spelplats);
		this.add(btnspel);
		this.add(textspelband);
		this.add(textspeltid);
		this.add(textspelbandinfo);
		this.add(textspelplats);
		this.add(prn);
//		this.add(box);
		
		kansliet.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		bokaband.setBounds(40, 70, 200, 20);
		kansliet.setBounds(270, 10, 200, 20);
		btnboka.setBounds(40, 130, 100, 20);
		textmedlem.setBounds(170, 100, 200, 20);
		textband.setBounds(150, 70, 200, 20);
//		box.setBounds(140, 40, 100, 20);
		medlem.setBounds(40, 100, 200, 20);
		kontaktperson.setBounds(40, 180, 300, 20);
		prn.setBounds(40, 210, 300, 20);
		textkontakt.setBounds(150, 180, 200, 20);
		btnkontakt.setBounds(40, 240, 150, 20);
		spelband.setBounds(40, 290, 100, 20);
		spelbandinfo.setBounds(40, 320, 100, 20);
		spelplats.setBounds(40, 350, 100, 20);
		speltid.setBounds(40, 380, 100, 20);
		btnspel.setBounds(40, 410, 130, 20);
		textspelband.setBounds(150, 290, 200, 20);
		textspelbandinfo.setBounds(140, 320, 200, 20);
		textspelplats.setBounds(120, 350, 200, 20);
		textspeltid.setBounds(100, 380, 200, 20);
		textprn.setBounds(280, 210, 200, 20);
		
	
		panel.add(bokaband);
		panel.add(kansliet);
		panel.add(btnboka);
		panel.add(medlem);
		panel.add(textband);
		panel.add(textmedlem);
		panel.add(kontaktperson);
		panel.add(textkontakt);
		panel.add(kontaktband);
		panel.add(btnkontakt);
		panel.add(spelband);
		panel.add(spelbandinfo);
		panel.add(spelplats);
		panel.add(speltid);
		panel.add(btnspel);
		panel.add(textspelbandinfo);
		panel.add(textspelband);
		panel.add(textspelplats);
		panel.add(textspeltid);
		panel.add(prn);
		panel.add(textprn);
//		panel.add(box);
		
	}
	
	private class kListener implements ActionListener {
		String band, contact, member, prn, bandinfo, scen, tid; 
		DBConnectionUser user ; 
		
		public void actionPerformed(ActionEvent e) {
			try {
				user = new 	DBConnectionUser();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
//			DBConnectionVisitor DBconn = null;
//			try {
//				DBconn = new DBConnectionVisitor();
//			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e2) {
//				e2.printStackTrace();
//			}
			
			
			if( e.getSource()==btnboka){
				band = textband.getText();
				member = textmedlem.getText();
				try {
					user.bookBand(band, member);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(band + " " + member);
				
				
			} else if (e.getSource()==btnkontakt){
				
				contact = textkontakt.getText();
				prn = textprn.getText();
				System.out.println(contact + prn);
				try {
					System.out.println("tja" );
					user.giveContact(contact, prn);	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				band = textmedlem.getText();
			} else if (e.getSource()==btnspel){
				band = textspelband.getText();
				bandinfo = textspelbandinfo.getText();
				scen = textspelplats.getText();
				tid = textspeltid.getText();
				System.out.println(band + " " + bandinfo + " " + scen + " " + tid);
				
				try {
					user.bookSpelning(band, bandinfo, scen, tid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		
	}

	
	
	
	public static void main (String[] args) {
		Kansliet kans = new Kansliet();
		JFrame ja = new JFrame();
		ja.setVisible(true);
		ja.setSize(600, 600);
		ja.add(kans);
		ja.setLocationRelativeTo(null);
		
	}

}