package projekt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import projekt.test.bListener;

public class Besokare extends JPanel {
	private bListener b = new bListener();
	private kListener listener = new kListener();

	private JPanel panel = new JPanel();
	private JPanel bandpanel = new JPanel();
	private JLabel lblBandinfo = new JLabel("Info");

	private JLabel spelschema = new JLabel("Spelschema");
	private JLabel bandnamn = new JLabel("Band");
	private JLabel vart = new JLabel("Plats");
	private JLabel tid = new JLabel("Tid");
	private JLabel bandinfo = new JLabel("Bandinfo");
	private JLabel kontakt = new JLabel("Kontaktperson");
	private JLabel info = new JLabel("Skriv in det band du vill ha mer info ifrån hår:");
	private JLabel sceninfo = new JLabel("Välj ifrån listan vilken scen du vill ha mer info ifrån:");
	private JTextArea textarea = new JTextArea();
	private JTextArea bandtext = new JTextArea();
	private JTextArea bandinfotext = new JTextArea();
	private JButton klar = new JButton("Fortsätt");
	private JComboBox box;

	public Besokare() {

		box = new JComboBox();
		box.addActionListener(b);

		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBackground(Color.WHITE);
		bandtext.setBackground(Color.LIGHT_GRAY);
		textarea.setBackground(Color.LIGHT_GRAY);
		box.addItem("Alla");
		box.addItem("Mallorcascenen");
		box.addItem("Forumscenen");
		box.addItem("Dieselt„ltet");
		box.setSelectedItem(null);

		this.add(panel);
		this.add(spelschema);
		this.add(bandnamn);
		this.add(vart);
		this.add(tid);
		this.add(textarea);
		this.add(bandtext);
		this.add(info);
		this.add(klar);
		this.add(sceninfo);
		this.add(box);
		this.add(bandinfotext);

		panel.setLayout(null);

		spelschema.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		spelschema.setBounds(260, 10, 150, 50);
		bandnamn.setBounds(40, 60, 150, 40);
		vart.setBounds(240, 60, 100, 40);
		tid.setBounds(430, 60, 150, 40);
		textarea.setBounds(40, 90, 550, 300);
		bandtext.setBounds(40, 500, 250, 20);
		info.setBounds(40, 470, 480, 40);
		sceninfo.setBounds(40, 390, 400, 40);
		klar.setBounds(300, 500, 100, 20);
		box.setBounds(40, 420, 170, 20);

		panel.add(spelschema);
		panel.add(bandnamn);
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

	public Besokare(ArrayList<String> arr) {
		String output = "";
		for (int i = 0; i < arr.size(); i++) {
			output = arr.get(i) + "\n";
		}
		
		bandpanel.setPreferredSize(new Dimension(300, 300));
		bandpanel.setBackground(Color.WHITE);
		bandinfotext.setBounds(300, 300, 300, 3000);

		this.add(bandpanel);
		this.add(bandinfotext);
		bandpanel.add(bandinfotext);

		bandinfotext.setText(output);

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.add(bandpanel);
		frame.setLocationRelativeTo(null);
	}

	// public void putonSecondWindow(ArrayList<String> arr){
	//
	// }

	public void putOnWindow(ArrayList<String> arr) {
		String output = "";
//		System.out.println("Metoden " + arr.size());
		for (int i = 0; i < arr.size(); i++) {
			output += arr.get(i) + "\t  ";
//			System.out.println(arr.get(i));
			if (i == 4 || i == 8 || i == 12 || i == 16) {
				output += "\n";
			}
		}
		textarea.setText(output);
	}

	private class kListener implements ActionListener {
		Besokare be;
		String band;
		DBConnectionVisitor visiter;
		ArrayList<String> schema = new ArrayList<String>();

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				visiter = new DBConnectionVisitor();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (e.getSource() == klar) {
				band = bandtext.getText();
				// System.out.println(band);
				try {
					schema = visiter.getAllBandinfo(band);
					be = new Besokare(schema);
					// putonSecondWindow(schema);

					for (int i = 0; i < schema.size(); i++) {
						System.out.println(schema.get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.print(band);

			}

		}

	}

	class bListener implements ActionListener {
		ArrayList<String> schema = new ArrayList<String>();

		@Override
		public void actionPerformed(ActionEvent e) {
			DBConnectionVisitor DBconn = null;
			try {
				DBconn = new DBConnectionVisitor();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e2) {
				e2.printStackTrace();
			}

			int boxInfo = (int) box.getSelectedIndex();

			switch (boxInfo) {
			case 0:
//				System.out.println("Alla 1");
				try {
					schema = DBconn.getData("alla");
					putOnWindow(schema);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 1:
				System.out.println("Band 2");
				try {
					schema = DBconn.getData("Mallorcascenen");
					putOnWindow(schema);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Band 3");
				try {
					schema = DBconn.getData("Forumscenen");
					putOnWindow(schema);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			case 3:
				System.out.println("Band 4");
				try {
					schema = DBconn.getData("Dieselt„ltet");
					putOnWindow(schema);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

	public static void main(String[] args) {
		Besokare bes = new Besokare();
		JFrame ja = new JFrame();
		ja.setVisible(true);
		ja.setSize(600, 600);
		ja.add(bes);
		ja.setLocationRelativeTo(null);

	}

}
