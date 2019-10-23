package GestionVue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDonnees.Rallye;
import GestionInscription.Camion;
import GestionInscription.Constructeur;
import GestionInscription.Coureur;
import GestionInscription.Vehicule;
import GestionInscription.Voiture;
import GestionRallye.EditionRallye;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class F_Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	protected Vehicule Vehicule;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public F_Inscription(ArrayList<Constructeur> lstConstructeurs, ArrayList<Rallye> lstRallyes, ArrayList<EditionRallye> lstEditionRallyes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFicheInscription = new JLabel("FICHE INSCRIPTION");
		lblFicheInscription.setBounds(10, 0, 117, 48);
		contentPane.add(lblFicheInscription);
		
		JLabel lblRallye = new JLabel("RALLYE PAR ETAPES");
		lblRallye.setBounds(10, 44, 574, 25);
		contentPane.add(lblRallye);
		
		
		JLabel lblsysdate = new JLabel("New label");
		lblsysdate.setBounds(207, 80, 80, 25);
		contentPane.add(lblsysdate);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		lblsysdate.setText(date.toString());
		
		JLabel lblDateEnregistrementInscription = new JLabel("Date enregistrement inscription");
		lblDateEnregistrementInscription.setBounds(10, 80, 156, 14);
		contentPane.add(lblDateEnregistrementInscription);
		
		

		
		JLabel lblRallye_1 = new JLabel("RALLYE");
		lblRallye_1.setBounds(10, 124, 46, 14);
		contentPane.add(lblRallye_1);
		
		JLabel lblNomDuRallye = new JLabel("NOM DU RALLYE");
		lblNomDuRallye.setBounds(10, 161, 86, 25);
		contentPane.add(lblNomDuRallye);
		
		JLabel lblVille = new JLabel("VILLE");
		lblVille.setBounds(10, 230, 46, 14);
		contentPane.add(lblVille);
		
		JLabel lblPays = new JLabel("PAYS");
		lblPays.setBounds(10, 268, 46, 14);
		contentPane.add(lblPays);
		
		JLabel lblNewLabel = new JLabel("EDITION");
		lblNewLabel.setBounds(10, 324, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(10, 353, 46, 14);
		contentPane.add(lblAnnee);
		
		JLabel lblDatedebut = new JLabel("Date");
		lblDatedebut.setBounds(10, 425, 143, 14);
		contentPane.add(lblDatedebut);
		
		JLabel lblCoureur = new JLabel("COUREUR");
		lblCoureur.setBounds(359, 42, 64, 28);
		contentPane.add(lblCoureur);
		
		JLabel lblNumeroInscriptionCoureur = new JLabel("NUMERO INSCRIPTION COUREUR");
		lblNumeroInscriptionCoureur.setBounds(359, 80, 168, 14);
		contentPane.add(lblNumeroInscriptionCoureur);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 163, 168, 20);
		contentPane.add(comboBox);
		for(Rallye ry : lstRallyes) {
			comboBox.addItem(ry.getNomR());
		}
		
		JLabel lblNom = new JLabel("NOM ");
		lblNom.setBounds(359, 124, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("PRENOM");
		lblPrenom.setBounds(359, 166, 46, 14);
		contentPane.add(lblPrenom);
		
		textField = new JTextField();
		textField.setBounds(543, 121, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(543, 163, 156, 20);
		contentPane.add(textField_1);
		
		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setBounds(359, 215, 117, 14);
		contentPane.add(lblDateDeNaissance);
		
		textField_8 = new JTextField();
		textField_8.setBounds(543, 212, 156, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblGroupeSaguin = new JLabel("Groupe Saguin");
		lblGroupeSaguin.setBounds(359, 268, 117, 14);
		contentPane.add(lblGroupeSaguin);
		
		textField_9 = new JTextField();
		textField_9.setBounds(543, 265, 156, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblRhsus = new JLabel("Rh\u00E9sus");
		lblRhsus.setBounds(359, 324, 46, 14);
		contentPane.add(lblRhsus);
		
		textField_10 = new JTextField();
		textField_10.setBounds(543, 318, 156, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblVehicule = new JLabel("VEHICULE");
		lblVehicule.setBounds(359, 381, 64, 25);
		contentPane.add(lblVehicule);
		
		JLabel lblNumeroDimmatriculationDu = new JLabel("NUMERO D'IMMATRICULATION DU VEHICULE");
		lblNumeroDimmatriculationDu.setBounds(359, 417, 239, 31);
		contentPane.add(lblNumeroDimmatriculationDu);
		
		textField_11 = new JTextField();
		textField_11.setBounds(359, 454, 225, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblConstructeur = new JLabel("CONSTRUCTEUR");
		lblConstructeur.setBounds(359, 492, 117, 28);
		contentPane.add(lblConstructeur);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(502, 496, 156, 20);
		contentPane.add(comboBox_1);
		for (Constructeur cons : lstConstructeurs) {
			comboBox_1.addItem(cons.getNomConst());
		}
		
		
		JLabel lblNomville = new JLabel("nomVille");
		lblNomville.setBounds(131, 230, 70, 14);
		contentPane.add(lblNomville);
		
		JLabel lblNompays = new JLabel("nomPays");
		lblNompays.setBounds(131, 268, 70, 14);
		contentPane.add(lblNompays);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(131, 350, 168, 20);
		contentPane.add(comboBox_2);
		for (EditionRallye erl : lstEditionRallyes) {
			comboBox_2.addItem(erl.getAnneeER());
		}
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(77, 425, 239, 14);
		contentPane.add(lblDate);
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setBounds(73, 547, 128, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(77, 468, 117, 48);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblPuissance = new JLabel("PUISSANCE");
		lblPuissance.setBounds(457, 564, 80, 14);
		contentPane.add(lblPuissance);
		
		textField_12 = new JTextField();
		textField_12.setBounds(587, 561, 86, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		
		
		
		JLabel lblPoids = new JLabel("POIDS");
		lblPoids.setBounds(457, 589, 70, 14);
		contentPane.add(lblPoids);
		
		textField_13 = new JTextField();
		textField_13.setBounds(587, 586, 86, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		
		
		
		JLabel lblCylindree = new JLabel("CYLINDREE");
		lblCylindree.setBounds(457, 622, 86, 14);
		contentPane.add(lblCylindree);
		
		textField_14 = new JTextField();
		textField_14.setBounds(587, 617, 86, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		
		
		JRadioButton rdbtnVoiture = new JRadioButton("VOITURE");
		rdbtnVoiture.setBounds(359, 564, 69, 23);
		contentPane.add(rdbtnVoiture);
		rdbtnVoiture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_13.setVisible(false);
				textField_14.setVisible(false);
				lblPoids.setVisible(false);
				lblCylindree.setVisible(false);
				textField_12.setVisible(true);
				lblPuissance.setVisible(true);
				
			}
			
		});
		
		
		
		
		JRadioButton rdbtnCamion = new JRadioButton("CAMION");
		rdbtnCamion.setBounds(359, 590, 67, 23);
		contentPane.add(rdbtnCamion);
		rdbtnCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_12.setVisible(false);
				textField_14.setVisible(false);
				lblPoids.setVisible(false);
				lblCylindree.setVisible(false);
				textField_13.setVisible(true);
				lblPoids.setVisible(true);
				
			}
			
		});
	
		
		JRadioButton rdbtnMoto = new JRadioButton("MOTO");
		rdbtnMoto.setBounds(359, 618, 55, 23);
		contentPane.add(rdbtnMoto);
		rdbtnMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPoids.setVisible(false);
				lblPuissance.setVisible(false);
				textField_12.setVisible(false);
				textField_13.setVisible(false);
				textField_14.setVisible(true);
				lblCylindree.setVisible(true);
				
			}
			
		});
		
		
		ButtonGroup group = new ButtonGroup(); 
		group.add(rdbtnMoto);
		group.add(rdbtnCamion);
		group.add(rdbtnVoiture);
		
		JButton btnNewButton_2 = new JButton("voir ville et pays");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String er = (String)comboBox.getSelectedItem();
				for (Rallye r : lstRallyes) {
					if (r.getNomR().equals(er)) {
						
							lblNomville.setText(r.getVilleR());
							lblNompays.setText(r.getPaysR());
						
						
					}
					
				}
				
			}
		});
		btnNewButton_2.setBounds(10, 196, 143, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voir la date");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ery = (int)comboBox_2.getSelectedItem();
				for (EditionRallye era : lstEditionRallyes) {
					if(era.getAnneeER() == ery) {
						lblDate.setText(" De " + era.getDateDebER() + " à " + era.getDateFinER() );
						
				}
			}
			}
		});
		btnNewButton_3.setBounds(10, 378, 117, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblnumeroC = new JLabel("numero");
		lblnumeroC.setBounds(553, 80, 46, 14);
		contentPane.add(lblnumeroC);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Coureur> lstCoureurs = new ArrayList<Coureur>();
				ArrayList<Vehicule> lstVehicules = new ArrayList<Vehicule>();
				Vehicule vi = null;
			
				
				boolean exist = false;
				for (Coureur cr : lstCoureurs) {
					System.out.println(textField.getText().equals(cr.getNomC()));
					
					if(textField.getText() == cr.getNomC() && textField_1.getText() == cr.getPrenomC() && textField_8.getText() == cr.getDateNaissC()
							&& textField_9.getText() == cr.getGrSanguin() && textField_10.getText() == String.valueOf(cr.getRhesusC()) ) {
						exist = true;
						System.out.println("D¨¦ja inscrit!");
						break;
						
					}
				}
				if (!exist) {
					int nb = lstCoureurs.size()+1; 
					lblnumeroC.setText("" + nb);
				
					String type = null;
					
					if(rdbtnVoiture.isSelected()) {
						type = "VOITURE";
	
					for(Constructeur cons : lstConstructeurs) {
						if(comboBox_1.getSelectedItem().equals(cons)) {
							vi = new Voiture(textField_11.getText(), Integer.valueOf(textField_12.getText()).intValue(), cons);
						}
					}
		
					} else if (rdbtnCamion.isSelected()) {
						type = "CAMION";
						
						for(Constructeur cons : lstConstructeurs) {
							if(comboBox_1.getSelectedItem().equals(cons)) {
								vi = new Camion(textField_11.getText(), Integer.valueOf(textField_13.getText()).intValue(), cons);
							}
						}
					} else if (rdbtnMoto.isSelected()){
						type = "MOTO";
						
						for(Constructeur cons : lstConstructeurs) {
							if(comboBox_1.getSelectedItem().equals(cons)) {
								vi = new Voiture(textField_11.getText(), Integer.valueOf(textField_14.getText()).intValue(), cons);
							}
						}
					} else if (!rdbtnVoiture.isSelected() && !rdbtnCamion.isSelected() && !rdbtnMoto.isSelected()) {
						type = "";
					}
				
				      Coureur r = new Coureur(nb+1,textField.getText(), textField_1.getText(), textField_8.getText(), textField_9.getText(), textField_10.getText().charAt(0), vi);
				      lstVehicules.add(vi);
				      lstCoureurs.add(r);
					
				}
			
			}
		});
	}
}
