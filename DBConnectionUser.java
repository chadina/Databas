package projekt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Klassen f�r anv�ndaren
public class DBConnectionUser {
	private Connection conn;
	
	public DBConnectionUser() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		 Class.forName("org.postgresql.Driver").newInstance();
	        conn = DriverManager
					.getConnection("jdbc:postgresql://pgserver.mah.se/ag8084?user=ag8084&password=u2njniar");
//	        PreparedStatement stmt = conn.prepareStatement("insert into tjoff(x, y) values(390, 611)");
//	        int nRows = stmt.executeUpdate();
//	        System.out.println(nRows+" rows");
	    }
	
	// ger kontaktperson
	public void giveContact(String band, String contactPerson) throws SQLException{
		System.out.println("Inne i metoden " +  band + " " + contactPerson);
        PreparedStatement stmt = conn.prepareStatement("insert into contatperson values ('" + band + "', '" + contactPerson + "')");
        int nRows = stmt.executeUpdate();
        System.out.println(nRows+" rows");
//        conn.close();
	}
	
	//Lägger tll bandmedlem i band
	public void bookBand(String band, String member) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("insert into bandInformation values ('" + band + "', '" + member + "')" );
        int nRows = stmt.executeUpdate();
//        System.out.println("bookBand query");
	}
	
	public void bookSpelning(String bandname, String bandinfo, String scen, String time) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("insert into spelning values ('" + bandname + "', '" + scen + "', '" + time + "', '" + bandinfo + "')" );
        int nRows = stmt.executeUpdate();
//        System.out.println("bookBand query");
	}
	
//	public void bandInfo(String bandname){
//		PreparedStatement stmt = conn.prepareStatement("insert into spelning values ('" + bandname + "', '" + scen + "', '" + time + "', '" + bandinfo + "')" );
//        int nRows = stmt.executeUpdate();
//	}
	
	
	//Ger kontaktperson till band
//	public void giveContactPerson(String prn){
//    PreparedStatement stmt = conn.prepareStatement("insert into spelning");
//    int nRows = stmt.executeUpdate();
//	}
	

}
