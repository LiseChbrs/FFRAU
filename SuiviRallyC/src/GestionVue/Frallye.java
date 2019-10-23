package GestionVue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import GestionDonnees.*;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;
import GestionRallye.Speciale;
import GestionRallye.TypeRegleSpecial;

import javax.swing.JComboBox;


public class Frallye extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	ArrayList<Rallye> listRallye = new ArrayList<Rallye>();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	public Frallye(ArrayList<Rallye> listRallye, ArrayList<EditionRallye> listERallye, ArrayList<Etape> listEtape) {
		this.listRallye = listRallye;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewRallye = new JLabel("New Rallye : ");
		lblNewRallye.setBounds(10, 11, 72, 14);
		contentPane.add(lblNewRallye);
		
		textField = new JTextField();
		textField.setBounds(74, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ville : ");
		lblNewLabel.setBounds(177, 11, 41, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 8, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPays = new JLabel("Pays : ");
		lblPays.setBounds(314, 11, 52, 14);
		contentPane.add(lblPays);
		
		textField_2 = new JTextField();
		textField_2.setBounds(355, 8, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox cbRegle = new JComboBox();
		cbRegle.addItem(TypeRegle.rallye);
		cbRegle.addItem(TypeRegle.superRallye);
		//cbRegle.add(TypeRegle.rallye);
		
		cbRegle.setBounds(484, 8, 80, 20);
		contentPane.add(cbRegle);
		
		JLabel lblRallye = new JLabel("Rallye : ");
		lblRallye.setBounds(10, 51, 46, 14);
		contentPane.add(lblRallye);
		
		JComboBox cbRallye = new JComboBox();
		cbRallye.setBounds(74, 48, 86, 20);
		contentPane.add(cbRallye);
		for (Rallye rallye : listRallye) {
			cbRallye.addItem(rallye.getNomR());
		}
		
		JLabel lblNomEdition = new JLabel("Num Edition : ");
		lblNomEdition.setBounds(172, 51, 72, 14);
		contentPane.add(lblNomEdition);
		
		textField_3 = new JTextField();
		textField_3.setBounds(239, 48, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDatedeb = new JLabel("DateDeb : ");
		lblDatedeb.setBounds(335, 51, 62, 14);
		contentPane.add(lblDatedeb);
		
		textField_4 = new JTextField();
		textField_4.setBounds(391, 48, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDatefin = new JLabel("DateFin : ");
		lblDatefin.setBounds(487, 51, 52, 14);
		contentPane.add(lblDatefin);
		
		textField_5 = new JTextField();
		textField_5.setBounds(535, 48, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(74, 76, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEditionRallye = new JLabel("Edition Rallye : ");
		lblEditionRallye.setBounds(10, 107, 94, 14);
		contentPane.add(lblEditionRallye);
		
		JLabel lblAnnee = new JLabel("Annee : ");
		lblAnnee.setBounds(10, 76, 46, 14);
		contentPane.add(lblAnnee);
		
		JLabel lblDifficulte = new JLabel("Difficulte : ");
		lblDifficulte.setBounds(239, 107, 65, 14);
		contentPane.add(lblDifficulte);
		
		JComboBox cbDiff = new JComboBox();
		cbDiff.setBounds(297, 104, 100, 20);
		contentPane.add(cbDiff);
		for (Difficulte dif : Difficulte.values()) {
			cbDiff.addItem(dif);
		}
		
		
		JLabel lblNumetape = new JLabel("NumEtape : ");
		lblNumetape.setBounds(419, 107, 72, 14);
		contentPane.add(lblNumetape);
		
		JLabel lblDistance = new JLabel("Distance : ");
		lblDistance.setBounds(10, 135, 72, 14);
		contentPane.add(lblDistance);
		
		textField_7 = new JTextField();
		textField_7.setBounds(74, 132, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(478, 104, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox cbEdR = new JComboBox();
		cbEdR.setBounds(84, 104, 112, 20);
		contentPane.add(cbEdR);
		
		JLabel lblEtape = new JLabel("Etape : ");
		lblEtape.setBounds(10, 160, 46, 14);
		contentPane.add(lblEtape);
		
		JComboBox cbEtape = new JComboBox();
		cbEtape.setBounds(74, 157, 122, 20);
		contentPane.add(cbEtape);
		for (EditionRallye er : listERallye) {
			for (Etape etape : er.getEtapes()) {
				cbEtape.addItem(er.getNomR() + "." + er.getNumER() + "." + etape.getNumEtape());
			}
		}
		
		
		JLabel lblTypeSpeciale = new JLabel("Type Speciale : ");
		lblTypeSpeciale.setBounds(182, 185, 86, 14);
		contentPane.add(lblTypeSpeciale);
		
		JComboBox cbSpeciale = new JComboBox();
		cbSpeciale.setBounds(278, 182, 119, 20);
		contentPane.add(cbSpeciale);
		for (TypeRegleSpecial ts : TypeRegleSpecial.values()) {
			cbSpeciale.addItem(ts);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Distance : ");
		lblNewLabel_1.setBounds(249, 160, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(335, 157, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
		JLabel lblOrder = new JLabel("Order : ");
		lblOrder.setBounds(449, 160, 46, 14);
		contentPane.add(lblOrder);
		
		textField_10 = new JTextField();
		textField_10.setBounds(501, 157, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblChronlimit = new JLabel("Chronlimit : ");
		lblChronlimit.setBounds(10, 185, 72, 14);
		contentPane.add(lblChronlimit);
		
		textField_11 = new JTextField();
		textField_11.setBounds(74, 182, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Create Speciale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double distanceParcS = Double.parseDouble(textField_9.getText());
				int numOrdreS = Integer.parseInt(textField_10.getText());
				double chronoLimiteS = Double.parseDouble(textField_11.getText());
				String txt = cbEtape.getSelectedItem().toString();
				String rallye = "";
				int numEd = 0;
				int numEt = 0;
				String [] split = txt.split("\\.");
				rallye = split[0];
				numEd = Integer.parseInt(split[1]);
				numEt = Integer.parseInt(split[2]);
				for1:
				for (EditionRallye er : listERallye) {
					for (Etape et : er.getEtapes()) {
						if (er.getNomR().equals(rallye) && et.getNumEtape() == numEt && er.getNumER() == numEd) {
							boolean isExist = false;
							for (Speciale s : et.getSpeciales()) {
								if (s.getNumOrdreS() == numOrdreS) {
									isExist = true;
									break;
								}
							}
							if (!isExist) {
								Speciale sp = new Speciale(distanceParcS, numOrdreS, chronoLimiteS, (TypeRegleSpecial)cbSpeciale.getSelectedItem());
								et.addSpeciale(sp);
								System.out.println("Create new speciale OK.");
								break for1;
							}else {
								System.out.println("This speciale has exist.");
							}

						}
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(419, 181, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnCreateEtape = new JButton("Create Etape");
		btnCreateEtape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rallye = "";
				int numR = 0;
				int numEtape = Integer.parseInt(textField_8.getText());
				int distance = Integer.parseInt(textField_7.getText());
				String now = cbEdR.getSelectedItem().toString();
				String[] split = now.split("\\.");
				rallye = split[0];
				numR = Integer.parseInt(split[1]);
				
				for1:
				for (EditionRallye er : listERallye) {
					if (er.getNomR().equals(rallye) && er.getNumER() == numR) {
						for (Etape et : er.getEtapes()) {
							if (numEtape == et.getNumEtape()) {
								System.out.println("This numEtape exist.");
								break for1;
							}
						}
						Etape e = new Etape((Difficulte)cbDiff.getSelectedItem(),numEtape, distance,er);
						er.addEtape(e);
						cbEtape.addItem(er.getNomR() + "." + er.getNumER() + "." + e.getNumEtape());
						System.out.println("Create OK.");
						break;
					}
				}
				
				
				
			}
		});
		btnCreateEtape.setBounds(177, 132, 118, 23);
		contentPane.add(btnCreateEtape);
		

		for (EditionRallye editionRallye : listERallye) {
			cbEdR.addItem(editionRallye.getNomR() + "."  + editionRallye.getNumER());
		}
		
		JButton btnNewButton = new JButton("Create Edition");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rallye r = null;
				for (Rallye rl : listRallye) {
					if (cbRallye.getSelectedItem().equals(rl.getNomR())) {
						r = rl;
						break;
					}
				}
				
				boolean isExist = false;
				for (EditionRallye editionRallye : listERallye) {
					if (cbRallye.getSelectedItem().equals(editionRallye.getNomR()) && editionRallye.getNumER() == Integer.parseInt(textField_3.getText())) {
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					EditionRallye er = new EditionRallye(r.getNomR(), r.getVilleR(), r.getPaysR(), r.getRegle(), textField_4.getText(), textField_5.getText(), Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_6.getText()));
					listERallye.add(er);
					cbEdR.addItem(er.getNomR() + "." + er.getNumER());
					System.out.println("Create EditionRallye OK.");
				}else {
					System.out.println("Have exist.");
				}
				
			}
		});
		btnNewButton.setBounds(182, 76, 122, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCreatRallye = new JButton("Creat Rallye");
		btnCreatRallye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isExist = false;
				for (Rallye rallye : listRallye) {
					if (textField.getText().equals(rallye.getNomR())) {
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					Rallye r = new Rallye(textField.getText(),textField_1.getText(), textField_2.getText(),(TypeRegle)cbRegle.getSelectedItem());
					listRallye.add(r);
					System.out.println(listRallye.get(listRallye.size() - 1).getNomR());
					System.out.println(listRallye.size());
					cbRallye.addItem(r.getNomR());
					System.out.println(textField.getText() + " have been created successfully.");
				}else {
					System.out.println(textField.getText() + " exists in our list.");
				}
				
			}
		});
		btnCreatRallye.setBounds(574, 7, 112, 23);
		contentPane.add(btnCreatRallye);
		

	}
}
