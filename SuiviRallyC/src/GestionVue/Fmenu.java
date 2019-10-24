package GestionVue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDonnees.Rallye;
import GestionInscription.Constructeur;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Fmenu extends JFrame {

	private JPanel contentPane;
	/***
	 * Sert à la demo.
	 */
	private ArrayList<Rallye> rallyes;
	private ArrayList<EditionRallye> editions;
	private ArrayList<Etape> etapes;
	private ArrayList<Constructeur> constructeurs;
	private EditionRallye er;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Fmenu(ArrayList<Rallye> listRallye, ArrayList<EditionRallye> listERallye, ArrayList<Etape> listEtape, EditionRallye er, ArrayList<Constructeur> listCons) {
		this.er = er;
		this.rallyes = listRallye;
		this.editions = listERallye;
		this.etapes = listEtape;
		this.constructeurs = listCons;


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setIconImage(new ImageIcon("src/iconR.jpg/").getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGestionRallye = new JButton("Gestion Rallye");
		btnGestionRallye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Frallye frame = new Frallye(listRallye, listERallye, listEtape,er);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnGestionRallye.setBounds(96, 52, 251, 23);
		contentPane.add(btnGestionRallye);

		JButton btnGestionInscription = new JButton("Gestion Inscription");
		btnGestionInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F_Inscription frame = new F_Inscription(listCons,listRallye,listERallye);
				frame.setVisible(true);
			}
		});
		btnGestionInscription.setBounds(96, 97, 251, 23);
		contentPane.add(btnGestionInscription);

		JButton btnEnregisterTemps = new JButton("Enregister Temps");
		btnEnregisterTemps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EnregistrementCoureurSpeciale frame;
					frame = new EnregistrementCoureurSpeciale(er,listRallye,listERallye,listEtape,listCons);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		btnEnregisterTemps.setBounds(96, 144, 251, 23);
		contentPane.add(btnEnregisterTemps);

		JButton btnNewButton = new JButton("Gestion Classement");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fclass frame = new Fclass(listRallye, listERallye, listEtape);
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(96, 199, 251, 29);
		contentPane.add(btnNewButton);
	}
}
