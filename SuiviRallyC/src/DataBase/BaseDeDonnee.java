package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnee {

	public Connection cx;
	public String url;
	public String passwd;
	public String user;
	
	public BaseDeDonnee() {
		String url = "jdbc:postgresql://localhost:5432/Ecole";
	    String user = "postgres";
	    String passwd = "postgres";
	    
	    this.url = url;
	    this.user = user;
	    this.passwd = passwd;
	    
	    try {
			this.cx = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
   
}
