import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection con = (new Person()).connectTo("root", "malatya44");
		try {
			Statement st = con.createStatement();
			//st.execute("delete from people");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Person ramazan = new Person(1, "Ramazan Aktaş", 30);
		Person feyzi = new Person(2, "Muhammet Feyzi Sağlam", 31);
		Person lina = new Person(3, "Lina Sağlam", 1);
		ramazan.DBCreate(con);
		ramazan.DBUpdate(con, lina);
		feyzi.DBDelete(con);
	}

}
