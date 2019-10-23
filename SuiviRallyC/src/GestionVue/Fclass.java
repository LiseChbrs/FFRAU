package GestionVue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionClassement.Couple;
import GestionDonnees.Rallye;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Fclass extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Fclass(ArrayList<Rallye> listRallye, ArrayList<EditionRallye> listERallye, ArrayList<Etape> listEtape) {
		String type = "";
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnTous = new JRadioButton("Tous");
		rdbtnTous.setBounds(6, 153, 109, 23);
		contentPane.add(rdbtnTous);

		JRadioButton rdbtnVoiture = new JRadioButton("Voiture");
		rdbtnVoiture.setBounds(6, 179, 109, 23);
		contentPane.add(rdbtnVoiture);

		JRadioButton rdbtnCamion = new JRadioButton("Camion");
		rdbtnCamion.setBounds(6, 205, 109, 23);
		contentPane.add(rdbtnCamion);

		JRadioButton rdbtnMoto = new JRadioButton("Moto");
		rdbtnMoto.setBounds(6, 231, 109, 23);
		contentPane.add(rdbtnMoto);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnTous);
		group.add(rdbtnMoto);
		group.add(rdbtnCamion);
		group.add(rdbtnVoiture);

		JLabel lblEditionrallye = new JLabel("EditionRallye : ");
		lblEditionrallye.setBounds(6, 11, 109, 14);
		contentPane.add(lblEditionrallye);

		JComboBox cbEdR = new JComboBox();
		cbEdR.setBounds(87, 8, 149, 20);
		contentPane.add(cbEdR);

		JButton btnClasscoureur = new JButton("ClassCoureur");
		btnClasscoureur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rl = "";
				int numE = 0;
				String txt = (String)cbEdR.getSelectedItem();
				String[] split =  txt.split("\\.");
				rl = split[0];
				numE = Integer.parseInt(split[1]);
				EditionRallye erNow = null;
				for (EditionRallye edr : listERallye) {
					if (edr.getNomR().equals(rl) && edr.getNumER() == numE) {
						erNow = edr;
						break;
					}
				}
				ArrayList<Couple> res;
				if(rdbtnVoiture.isSelected()) {
					res = erNow.getClassementDefinitif().calculerClassementG("Voiture");
				}else if(rdbtnCamion.isSelected()) {
					res = erNow.getClassementDefinitif().calculerClassementG("Camion");
				}else if(rdbtnMoto.isSelected()) {
					res = erNow.getClassementDefinitif().calculerClassementG("Moto");
				}else {
					res = erNow.getClassementDefinitif().calculerClassementG("");
				}
				
				ArrayList<ArrayList<String>> matrice = new ArrayList<ArrayList<String>>();

				for(int i=0;i<res.size();i++) {
					ArrayList<String> ligne = new ArrayList<String>();
					Couple couple = res.get(i);
					ligne.add(""+(i+1));
					ligne.add(couple.getKey().toString());
					ligne.add(""+couple.getValue());
					matrice.add(ligne);

				}
				System.out.println(matrice);
				String[] col = {"Place","Coureur","Temps"};
				String [][] matmatStrings = new String[matrice.size()+1][3];
				matmatStrings[0][0] = "Place";
				matmatStrings[0][1] = "Coureur";
				matmatStrings[0][2] = "Temps";
				
				for(int i=0;i<matrice.size();i++) {
					for(int j=0;j<matrice.get(i).size();j++) {
						matmatStrings[i+1][j] = matrice.get(i).get(j);
					}
				}
				table_1 = new JTable(matmatStrings,col);
				table_1.setBounds(419, 240, -271, -177);
				contentPane.add(table_1);
				table_1.setBounds(150, 50, 500, 300); 
				table_1.setVisible(true); 



			}
		});
		btnClasscoureur.setBounds(246, 7, 116, 23);
		contentPane.add(btnClasscoureur);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnMenu.setBounds(6, 36, 89, 23);
		contentPane.add(btnMenu);



		for (EditionRallye er : listERallye) {
			cbEdR.addItem(er.getNomR() + "." + er.getNumER());
		}

	}
}
