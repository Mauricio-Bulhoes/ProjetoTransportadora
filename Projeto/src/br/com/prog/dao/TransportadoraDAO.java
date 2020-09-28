package br.com.prog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog.database.ConnectFactory;
import br.com.prog.database.ProjetoException;
import br.com.prog.model.Transportadora;

public class TransportadoraDAO {
	
	private Connection conn;


	public List<Transportadora> listar() {
		
		String sql = "SELECT id,nome,cnpj,empresa,telefone,celular,email,whatsapp,modal,cep,estado,cidade,bairro,rua,numero,logo FROM transportadora ORDER BY nome";
		List<Transportadora> transportadora = new ArrayList<Transportadora>();
		
		try {
			conn = ConnectFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transportadora t = new Transportadora();
				t.setId(rs.getInt("id"));
				t.setNome(rs.getString("nome"));
				t.setCnpj(rs.getString("cnpj"));
				t.setEmpresa(rs.getString("empresa"));
				t.setTelefone(rs.getString("telefone"));
				t.setCelular(rs.getString("celular"));
				t.setEmail(rs.getString("email"));
				t.setWhatsapp(rs.getString("whatsapp"));
				t.setModal(rs.getString("modal"));
				t.setCep(rs.getString("cep"));
				t.setEstado(rs.getString("estado"));
				t.setCidade(rs.getString("cidade"));
				t.setBairro(rs.getString("bairro"));
				t.setRua(rs.getString("rua"));
				t.setNumero(rs.getInt("numero"));
				t.setLogo(rs.getString("logo"));
			            
				transportadora.add(t);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Erro em lista transportadora DAO");
		}
		
		return transportadora;
		
	}
	
	public void adicionarTransportadora(Transportadora transportadora) throws ProjetoException {
		
		String sql = "INSERT INTO transportadora (nome, cnpj, empresa, email, telefone, celular, whatsapp, modal, cep, estado, cidade, bairro, rua, numero, logo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, transportadora.getNome());
			ps.setString(2, transportadora.getCnpj());
			ps.setString(3, transportadora.getEmpresa());
			ps.setString(4, transportadora.getEmail());
			ps.setString(5, transportadora.getTelefone());
			ps.setString(6, transportadora.getCelular());
			ps.setString(7, transportadora.getWhatsapp());
			ps.setString(8, transportadora.getModal());
			ps.setString(9, transportadora.getCep());
			ps.setString(10, transportadora.getEstado());
			ps.setString(11, transportadora.getCidade());
			ps.setString(12, transportadora.getBairro());
			ps.setString(13, transportadora.getRua());
			ps.setInt(14, transportadora.getNumero());
			ps.setString(15, transportadora.getLogo());
			ps.executeUpdate();
			System.out.println("transportadora cadastrada!");
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("transportadora não cadastrada");
		}
		
	}
	
	public void alterarTransportadora(Transportadora transportadora) throws ProjetoException {
		String sql = "UPDATE transportadora SET nome=?, cnpj=?, empresa=?, email=?, telefone=?, celular=?, "
				+ "whatsapp=?, modal=?, cep=?, estado=?, cidade=?, bairro=?, rua=?, numero=?, logo=? WHERE id = ?";
		try {
			conn = ConnectFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
				
			ps.setString(1, transportadora.getNome());
			ps.setString(2, transportadora.getCnpj());
			ps.setString(3, transportadora.getEmpresa());
			ps.setString(4, transportadora.getEmail());
			ps.setString(5, transportadora.getTelefone());
			ps.setString(6, transportadora.getCelular());
			ps.setString(7, transportadora.getWhatsapp());
			ps.setString(8, transportadora.getModal());
			ps.setString(9, transportadora.getCep());
			ps.setString(10, transportadora.getEstado());
			ps.setString(11, transportadora.getCidade());
			ps.setString(12, transportadora.getBairro());
			ps.setString(13, transportadora.getRua());
			ps.setInt(14, transportadora.getNumero());
			ps.setString(15, transportadora.getLogo());
			ps.setInt(16, transportadora.getId());
			ps.executeUpdate();
			System.out.println("transportadora atualizada");
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("transportadora não atualizada");
		}
			
	}		
	
	public void deletarTransportadora(Integer id) throws ProjetoException {
		
		String sql = "DELETE FROM transportadora WHERE id = ?";
		
		try {
			conn = ConnectFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
			System.out.println("transportadora deletada");
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("não deletada transportadora");
		}
		
	}

	public Transportadora buscar(String nome) {
		
		String sql = "SELECT * FROM transportadora WHERE nome =?";
		
		Transportadora c = new Transportadora();
		
		try {
			conn = ConnectFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,nome);
			ResultSet rs = ps.executeQuery();
					
			while (rs.next()) {		
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCnpj(rs.getString("cnpj"));
				c.setEmpresa(rs.getString("empresa"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				c.setEmail(rs.getString("email"));
				c.setWhatsapp(rs.getString("whatsapp"));	
				c.setModal(rs.getString("modal"));
				c.setCep(rs.getString("cep"));
				c.setEstado(rs.getString("estado"));
				c.setCidade(rs.getString("cidade"));
				c.setBairro(rs.getString("bairro"));
				c.setRua(rs.getString("rua"));
				c.setNumero(rs.getInt("numero"));
				c.setLogo(rs.getString("logo"));
			}

		} 		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return c;
		
	}

	public List<Transportadora> listarPBox() {
		
		String sql = "SELECT * FROM transportadora ORDER BY nome";
		List<Transportadora> transportadora = new ArrayList<Transportadora>();
		
		try {
			conn = ConnectFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {				
				Transportadora t = new Transportadora();
				t.setId(rs.getInt("id"));
				t.setNome(rs.getString("nome"));        
				transportadora.add(t);				
			}

		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Erro em lista transportadora DAO");
		}
		
		return transportadora;
		
	}

}
