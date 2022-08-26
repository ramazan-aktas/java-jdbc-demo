import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBAble {
	protected int id;
	final String MYSQL_SERVER = "jdbc:mysql://localhost:3306/";
	protected String dbName;
	protected String tableName;
	
	public Boolean isIdExist(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s WHERE id = '%s'", this.getTableName(), this.getId()));
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	};
	public abstract String dbReady();
	
	public void DBCreate(Connection con) {
		System.out.println("INSERT INTO " + this.tableName + " VALUES " + this.dbReady());
		try {
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO " + this.tableName + " VALUES " + this.dbReady());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void DBDelete(Connection con) {
		if (this.isIdExist(con)) {
			try {
				Statement st = con.createStatement();
				st.executeUpdate("DELETE FROM " + this.tableName + " WHERE id = " + this.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Öyle biri yok ki.");
		}
	};
	
	public void DBUpdate (Connection con, Person newEntry) {
		if (this.isIdExist(con) && newEntry.isIdExist(con)) {
			try {
				Statement st = con.createStatement();
				st.executeUpdate("UPDATE " + this.tableName + " SET name = " + String.format("'%s' , ", newEntry.getName()) + "age = " + newEntry.getAge() + " WHERE id = " + this.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Güncellemek istediğin kişi ya da yerine geçmesini istediğin kişi yok");
		}
	}
	
	public Connection connectTo(String userName, String pwd) {
		try {
			Connection con = DriverManager.getConnection(this.MYSQL_SERVER + this.dbName, userName, pwd);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	public int getId() {
		return id;
	}

	public String getDbName() {
		return dbName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}



}
