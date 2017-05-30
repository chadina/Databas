package Festival;

import java.awt.*;

import javax.swing.*;

public class Bes�kare extends JPanel {
	
	private JPanel panel = new JPanel();
	private JPanel childpanel = new JPanel();
	private JLabel spelschema = new JLabel("Spelschema");
	private JLabel bandnamn = new JLabel("Band");
	private JLabel vart = new JLabel("Plats");
	private JLabel tid = new JLabel("Tid");
	private JLabel bandinfo = new JLabel("Bandinfo");
	private JLabel kontakt = new JLabel("Kontaktperson");
	private JLabel info = new JLabel("Skriv in det band du vill ha mer info ifr�n h�r:");
	private JTextArea textarea = new JTextArea("");
	private JTextArea bandtext = new JTextArea("");
	private JButton klar = new JButton("Forts�tt");

	
	public Bes�kare() {
		
		

	//	setPreferredSize(new Dimension(600, 600));
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBackground(Color.WHITE);
		bandtext.setBackground(Color.LIGHT_GRAY);
		textarea.setBackground(Color.LIGHT_GRAY);

		this.add(panel);
		this.add(spelschema);
		this.add(bandnamn);
		this.add(vart);
		this.add(tid);
		this.add(bandinfo);
		this.add(kontakt);
		this.add(textarea);
		this.add(bandtext);
		this.add(info);
		this.add(klar);
	    panel.setLayout(null);
		
		spelschema.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		spelschema.setBounds(260, 10, 150, 50);
		bandnamn.setBounds(40,60, 150, 40);
		vart.setBounds(160,60, 150, 40);
		bandinfo.setBounds(280,60, 150, 40);
		tid.setBounds(400,60, 150, 40);
		kontakt.setBounds(480,60, 150, 40);
		textarea.setBounds(40, 90, 530, 300);
		bandtext.setBounds(40, 450, 250, 20);
		info.setBounds(40, 420, 300, 40);
		klar.setBounds(300, 450, 100, 20);

	
		panel.add(spelschema);
		panel.add(bandinfo);
		panel.add(bandnamn);
		panel.add(kontakt);
		panel.add(tid);
		panel.add(vart);
		panel.add(textarea);
		panel.add(bandtext);
		panel.add(info);
		panel.add(klar);
				
		
	}
	
	


	public static void main (String[] args) {
		Bes�kare bes = new Bes�kare();
		JFrame ja = new JFrame();
		ja.setVisible(true);
		ja.setSize(600, 600);
		ja.add(bes);
		ja.setLocationRelativeTo(null);
		
	}

}
