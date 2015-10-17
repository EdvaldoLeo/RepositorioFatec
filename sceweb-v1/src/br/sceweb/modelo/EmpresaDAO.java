package br.sceweb.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpresaDAO {
	/*
	 * inclui uma empresa no db entrada objeto do tipo empresa saída - o número
	 * de linhas afetadas com a operação
	 */
	public int adiciona(Empresa empresa) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = new FabricaDeConexoes().getConnetion()) {
			ps = conn
					.prepareStatement("insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values(?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigoRetorno;
	}
	
	
	/**
	 * exclui empressa no bd
	 * @param cnpj
	 * @return
	 */
	public int exclui(String cnpj){
		PreparedStatement ps;
		int codigoRetorno =0;
		try (Connection conn = new FabricaDeConexoes().getConnetion()) {
			ps=conn.prepareStatement("delete from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			codigoRetorno=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigoRetorno;
	}
}
