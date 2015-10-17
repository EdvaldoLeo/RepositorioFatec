package br.sceweb.teste;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;


public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Fant x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("9999-9999");
	}
	/**
	 * obj - verificar o comportamento do sistema na inclusão de uma empresa com sucesso
	 * @throws ClassNotFoundException 
	 * */


	@Test
	public void CT01UC01FBCadastra_com_sucesso() {

		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



}
