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



	public static Statement Statement_connection() {
		ArrayList<Rallye> listRallye = new ArrayList<Rallye>();
		listRallye.add(new Rallye("France", "Toulouse", "France", TypeRegle.rallye));
		ArrayList<EditionRallye> listERallye = new ArrayList<EditionRallye>();
		ArrayList<Etape> listEtape = new ArrayList<Etape>();

		try{
			String ur1 ="jdbc:sqlite:temp.db";
			con=DriverManager.getConnection(ur1);
			st=con.createStatement();
			System.out.println("succesful");


		}catch(Exception ex) {
			System.out.println("Connection failed");

		}return st;
	}


	public static void request(Statement state,String requete) throws SQLException {
		//L'objet ResultSet contient le résultat de la requête SQL
		ResultSet result = state.executeQuery(requete);
		//On récupère les MetaData
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

		}

		result.close();
	}


	public static void main(String[]args) throws SQLException {
		Statement cx;
		cx = Statement_connection();
		String sql = "Select * from coureur;";
		request(cx,sql);

		String QueryString="insert into coureur('txt.getString()','txte.getString()')";


	}

}
