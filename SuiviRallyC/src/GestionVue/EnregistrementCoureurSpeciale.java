package GestionVue;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import GestionClassement.ClassementEtape;
import GestionDonnees.Etat;
import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;
import GestionInscription.Constructeur;
import GestionInscription.Coureur;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;
import GestionRallye.Speciale;

public class EnregistrementCoureurSpeciale extends JFrame implements ActionListener{

	private Box vBox ;
	private JComboBox liste1,liste2,liste3;
	private JTextField txtTemps;
	private EditionRallye er;

	public EnregistrementCoureurSpeciale(EditionRallye er) {
		this.er = er;
		this.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Etape etape = (Etape) this.liste1.getSelectedItem();

		//ON FORCE UNE OUVERTURE POUR LA DEMO.
		etape.setEtat(Etat.debute);

		Speciale speciale = (Speciale) this.liste2.getSelectedItem();
		Coureur coureur = (Coureur) this.liste3.getSelectedItem();
		String temps = this.txtTemps.getText();
		double t = Double.parseDouble(temps);

		try {
			ClassementEtape ce = etape.getClassement();
			ce.enregistrerTemps(coureur, speciale, t);
		}catch(Exception exception) {
			ClassementEtape ce = new ClassementEtape(etape);
			ce.enregistrerTemps(coureur, speciale, t);
			etape.setClassement(ce);
		}
		System.out.println("Nouveau classement : \n"+etape.getClassement().calculerClassement());
	}

	public void init() {
		this.setTitle("Temps edition :"+er.getNomR()+" "+er.getNumER());
		vBox = Box.createVerticalBox();
		Object[] elements = new Object[er.getEtapes().size()];
		int i =0;
		for(Etape e : er.getEtapes()) {
			elements[i] = e;
			i++;
		}
		JLabel lblEtape = new JLabel("Selectionnez une etape");
		liste1 = new JComboBox(elements);
		ClassementEtape ce;

		liste1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		vBox.add(lblEtape);
		vBox.add(liste1);
		Etape etape = (Etape) liste1.getSelectedItem();
		elements = new Object[etape.getSpeciales().size()];
		i = 0;
		for(Speciale s : etape.getSpeciales()) {
			elements[i] = s;
			i++;
		}
		liste2 = new JComboBox(elements);
		JLabel lblSpeciale = new JLabel("Selectionnez une speciale");
		vBox.add(lblSpeciale);
		vBox.add(liste2);
		elements = new Object[er.getCoureurs().size()];
		i=0;
		for(Coureur c : er.getCoureurs()) {
			elements[i] = c;
			i++;
		}

		JLabel lblCoureur = new JLabel("Selectionnez un coureur");
		this.liste3 = new JComboBox(elements);

		vBox.add(lblCoureur);
		vBox.add(liste3);

		appButton();

		this.add(vBox);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);             
		this.setVisible(true);
	}

	public void appButton() {
		txtTemps = new JTextField("Entrez un temps");
		txtTemps.setSize(this.getWidth(), 10);

		Box hbox = Box.createHorizontalBox();
		JButton btnEnr = new JButton("Valider Temps");
		btnEnr.addActionListener(this);
		JButton btnReturn = new JButton("Menu");
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Rallye> listRallye = new ArrayList<Rallye>();
				listRallye.add(new Rallye("France", "Toulouse", "France", TypeRegle.rallye));
				ArrayList<EditionRallye> listERallye = new ArrayList<EditionRallye>();
				ArrayList<Etape> listEtape = new ArrayList<Etape>();
				ArrayList<Constructeur> listCons = new ArrayList<Constructeur>();
				Fmenu menu = new Fmenu(listRallye, listERallye, listEtape, er,listCons);
				menu.setVisible(true);

			}
		});
		hbox.add(btnEnr);
		hbox.add(btnReturn);
		vBox.add(txtTemps);
		vBox.add(hbox);
		this.add(vBox);
	}
}
