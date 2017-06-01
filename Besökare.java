package Festival;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Besökare extends JPanel  {
	
	private JPanel panel = new JPanel();
	private JPanel bandpanel = new JPanel(); 
	private JLabel spelschema = new JLabel("Spelschema");
	private JLabel bandnamn = new JLabel("Band");
	private JLabel vart = new JLabel("Scen");
	private JLabel tid = new JLabel("Tid");
//	private JLabel bandinfo = new JLabel("Bandinfo");
//	private JLabel kontakt = new JLabel("Kontaktperson");
	private JLabel info = new JLabel("Skriv in det band du vill ha mer info ifrån här:");
	private JLabel sceninfo = new JLabel("Välj ifrån listan vilken scen du vill ha mer info ifrån:");
	private JTextArea textarea = new JTextArea("");
	private JTextArea bandtext = new JTextArea("");
	private JButton klar = new JButton("Fortsätt");
	private JComboBox box = new JComboBox();
	
	bListener listener = new bListener();
	private String bandinfo;
	
	
	public Besökare() {
		
		
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBackground(Color.WHITE);
		bandtext.setBackground(Color.LIGHT_GRAY);
		textarea.setBackground(Color.LIGHT_GRAY);
		box.addItem("Mallorcascenen");
		box.addItem("Dieseltältet");
		box.addItem("Forumscenen");
		box.setSelectedItem(null);



		this.add(panel);
		this.add(spelschema);
		this.add(bandnamn);
		this.add(vart);
		this.add(tid);
//		this.add(bandinfo);
//		this.add(kontakt);
		this.add(textarea);
		this.add(bandtext);
		this.add(info);
		this.add(klar);
		this.add(sceninfo);
		this.add(box);
		
		
	    panel.setLayout(null);
		
		spelschema.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		spelschema.setBounds(260, 10, 150, 50);
		bandnamn.setBounds(40,60, 150, 40);
		vart.setBounds(250,60, 150, 40);
//		bandinfo.setBounds(280,60, 150, 40);
		tid.setBounds(440,60, 150, 40);
//		kontakt.setBounds(480,60, 150, 40);
		textarea.setBounds(40, 90, 530, 300);
		bandtext.setBounds(40, 500, 250, 20);
		info.setBounds(40, 470, 480, 40);
		sceninfo.setBounds(40, 390, 400, 40);
		klar.setBounds(300, 500, 100, 20);
		box.setBounds(40, 420, 170, 20);

	
		panel.add(spelschema);
//		panel.add(bandinfo);
		panel.add(bandnamn);
//		panel.add(kontakt);
		panel.add(tid);
		panel.add(vart);
		panel.add(textarea);
		panel.add(bandtext);
		panel.add(info);
		panel.add(klar);
		panel.add(sceninfo);
		panel.add(box);
		
			klar.addActionListener(listener);
			
		
	}
	
	public Besökare (String bandinfo) {
		
		this.bandinfo=bandinfo;
		
		bandpanel.setPreferredSize(new Dimension(300, 300));
		bandpanel.setBackground(Color.WHITE);
		
		this.add(bandpanel);
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.add(bandpanel);
		frame.setLocationRelativeTo(null);
	}
	
	
	private class bListener implements ActionListener {
		Besökare be;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (arg0.getSource()==klar){
				be = new Besökare ("hej");
				
				
			}
			
			
			
		}
		
	}


	
	public static void main (String[] args) {
		Besökare bes = new Besökare();
//		Besökare b = new Besökare("linking park");
		JFrame ja = new JFrame();
		ja.setVisible(true);
		ja.setSize(600, 600);
		ja.add(bes);
		ja.setLocationRelativeTo(null);
		
	}
	

}
