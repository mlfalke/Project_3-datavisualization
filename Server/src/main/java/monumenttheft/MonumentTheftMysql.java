package monumenttheft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MonumentTheftMysql {
	//copy paste this:{
		private String databaseUrl = "localhost:3306";
		private String databaseUser = "root";
		private String databasePass = "jessinrodenburg";
		private String tableName = "Datavisualisatie";
		
		private Connection conn;
		
		
		
		public MonumentTheftMysql() throws SQLException {
		
			String connectionUrl = "jdbc:mysql://localhost:3306/" + tableName + "?useUnicode=true&characterEncoding=UTF-8&user=" + databaseUser + "&password=" + databasePass;
	        conn = DriverManager.getConnection(connectionUrl);
		}
		//} until this
		//and set your own variables and classnames
		
		
		
		
		
}
