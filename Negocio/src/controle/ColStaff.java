package controle;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoStaff;
import unioeste.geral.evento.bo.Staff;
import util.NegocioException;

public class ColStaff {

public Connection con;
	
	public ColStaff(Connection connection) {
		con = connection;
	}
	
	public int inserirStaff(Staff s, Connection con) throws NegocioException, SQLException {
		
		int res = 0;
		DaoStaff daoStaff = new DaoStaff();
		
		res = daoStaff.insereStaff(s, con);
		return res ;
	}
	
	public Staff consultarStaff(String cpf, Connection con) throws NegocioException, SQLException {
		
		DaoStaff staff = new DaoStaff();
		Staff res = new Staff();
		
		res = staff.consultar(cpf, con);
		return res;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
