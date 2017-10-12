package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
private final String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	
	public Connection getConexaoAclimacao () throws Exception {
		Class.forName(DRIVE);
		Connection conn = DriverManager.getConnection(
				"jdbc:sqlserver://pokemons.database.windows.net:1433;"
				+ "user=FelipePatente@pokemons;"
				+ "password=Numeronumero1;"
				+ "database=Pokemons");
				
		return conn;
	}

}
