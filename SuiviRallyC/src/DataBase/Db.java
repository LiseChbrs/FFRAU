package DataBase;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;
import GestionVue.Frallye;

public class Db {
	private static Connection con;
	private static Statement st;


	/*
	 * connexion � la base
	 */
	public static Connection connection() {
		ArrayList<Rallye> listRallye = new ArrayList<Rallye>();
		listRallye.add(new Rallye("France", "Toulouse", "France", TypeRegle.rallye));
		ArrayList<EditionRallye> listERallye = new ArrayList<EditionRallye>();
		ArrayList<Etape> listEtape = new ArrayList<Etape>();

		try{
			String ur1 ="jdbc:sqlite:temp.db";
			con=DriverManager.getConnection(ur1);
			//st=con.createStatement();
			System.out.println("succesful");


		}catch(Exception ex) {
			System.out.println("Connection failed");

		}return con;
	}
	
	
	/*
	 * pour afficher une table dans la console
	 */

	public static void request(Connection state,String requete) throws SQLException {
		//L'objet ResultSet contient le r�sultat de la requ�te SQL
		
		Statement st = null ; 
		st = state.createStatement();
		
		ResultSet result = st.executeQuery(requete);
		//On r�cup�re les MetaData
		ResultSetMetaData resultMeta = result.getMetaData();

		System.out.println("\n**********************************************************************************************************************************************************************");
		//On affiche le nom des colonnes
		for(int i = 1; i <= resultMeta.getColumnCount(); i++)
			System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

		System.out.println("\n************************************************************************************************************************************************************************");

		while(result.next()){         
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				System.out.print("\t" + result.getObject(i).toString() + "\t |");

			System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------");

			/*while(result.next()){   
				for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
				    int valueVO = result.getInt("puissanceVO");
				    int valueMO = result.getInt("cylindreMO");
				    int valueCA = result.getInt("poidsCA");

					if(result.wasNull()) {
			            System.out.println("null");
					}else if (result.getObject(i).equals(valueVO)){
						System.out.print("\t" + valueVO + "\t |");
					}else if (result.getObject(i).equals(valueMO)) {
						System.out.print("\t" + valueMO + "\t |");
					}else if (result.getObject(i).equals(valueCA)) {
						System.out.print("\t" + valueCA + "\t |");

					}

					}
				}*/
		}

		result.close();
	}

	/*
	 * execute la requete
	 */
	public static void main(String[]args) throws SQLException {
		Connection cx;
		cx = connection();
		String sql = "Select * from rallye;";
		request(cx,sql);

	}

}
