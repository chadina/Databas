package projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Klassen f�r bes�kare
public class DBConnectionVisitor {
	ArrayList<String> schema = new ArrayList<String>();
	Connection conn;

	public DBConnectionVisitor() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver").newInstance();
		try {
			conn = DriverManager
					.getConnection("jdbc:postgresql://pgserver.mah.se/ag8084?user=ag8084&password=u2njniar");
		} catch (SQLException e) {

		}

	}

	// H�mtar SCHEMA fr�n databasen
	public ArrayList<String> getData(String scen) throws SQLException {
		PreparedStatement stmt;
//		System.out.println("getData");
		
		if(scen!="alla"){
			 stmt = conn.prepareStatement("Select * from spelning inner join scen on scen.vart= spelning.vart where spelning.vart = '"+scen+"'");
		}else {
		 stmt = conn.prepareStatement("Select * from spelning");
		}
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1));
			schema.add(rs.getString(1)); //bandnamn
			schema.add(rs.getString(2)); //vart
			schema.add(rs.getString(3)); //tid
			schema.add(rs.getString(4)); //bandinfo
//			schema.add(rs.getString(5)); //prnr
//			schema.add(rs.getString(6));
		}

		return schema;
	}

	

	// H�mtar BANDINFO
	public ArrayList<String> getBandInfo(String bandnamn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("Select * from bandinfo where bandnamn like = '" + bandnamn+ "'");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			schema.add(rs.getString("text"));
			schema.add(rs.getString("bandnamn"));
		}

		return schema;

	}
	 
	//Hämtar bandinfo till det andra fönstret
	public ArrayList<String> getAllBandinfo(String bandnamn) throws SQLException {

		int x = 1;
		PreparedStatement stmt = conn.prepareStatement("Select badnamn, namn from bandinformation inner join medlemx on medlemx.namn = bandinformation.medlemsnamn WHERE bandinformation.badnamn  = '" + bandnamn + "'");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if (x==1){
			schema.add(rs.getString(1));
			x++;
			}
			schema.add(rs.getString(2));
		}
		
		return schema;

	}
	

	public static void main(String[] argd)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DBConnectionVisitor db = new DBConnectionVisitor();
//		db.getData();
	}

}
