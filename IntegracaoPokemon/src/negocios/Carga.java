package negocios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import conexoes.Conexao;
import objetos.Categoria;
import objetos.Habilidade;
import objetos.HabilidadePokemon;
import objetos.Pokemon;
import objetos.Sexo;
import objetos.Tipo;
import objetos.bdPokemon;

public class Carga {
	
	private Conexao conexao;
	private PreparedStatement prepare;
	private Connection conn;
	
	public Carga() throws Exception{
		conexao = new Conexao();
		conn = conexao.getConexao();
	}
	
	
	public void inserirCategoria(ArrayList<Categoria> listaCategoria) throws Exception{
		
		String sql = "INSERT INTO Categoria (nmCategoria)"
				+ " VALUES(?);";	
		
		for (int i=0; i< listaCategoria.size(); i++) {
			
			Categoria c = listaCategoria.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setString(1, c.getNmCategoria());			
			prepare.executeUpdate();
			
		}	
	}
	
	public void inserirHabilidade(ArrayList<Habilidade> listaHabilidade) throws SQLException{
		
		String sql = "INSERT INTO Habilidade (nmHabilidade,descricao)"
				+ " VALUES(?,?);";	
		
		for (int i=0; i< listaHabilidade.size(); i++) {
			
			Habilidade h = listaHabilidade.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setString(1, h.getNmHabilidade());
			prepare.setString(2, h.getDescricao());
			prepare.executeUpdate();
			
		}
		
	}
	
	public void inserirSexo(ArrayList<Sexo> listaSexo) throws SQLException{
		
		String sql = "INSERT INTO Sexo (sexo,tipoSexo)"
				+ " VALUES(?,?);";	
		
		for (int i=0; i< listaSexo.size(); i++) {
			
			Sexo s = listaSexo.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setInt(1, s.getSexo());
			prepare.setString(2, s.getTipoSexo());
			prepare.executeUpdate();
			
		}
		
	}

	public void inserirTipo(ArrayList<Tipo> listaTipo) throws SQLException{
		
		String sql = "INSERT INTO Tipo (nmTipo)"
				+ " VALUES(?);";	
		
		for (int i=0; i< listaTipo.size(); i++) {
			
			Tipo t = listaTipo.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setString(1, t.getNmTipo());			
			prepare.executeUpdate();
			
		}
		
	}
	
	public void inserirPokemon(ArrayList<bdPokemon> listaPokemon) throws SQLException{
		
		for (int i=0; i< listaPokemon.size(); i++) {
			
			String sql = "INSERT INTO Pokemon (codPokemon,nome,descricao,altura,peso,sexo,codCategoria)"
					+ " VALUES(?,?,?,?,?,?,?);";
			
			bdPokemon p = listaPokemon.get(i);	
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, p.getCodPokemon());
			prepare.setString(2, p.getNome());
			prepare.setString(3, p.getDescricao());
			prepare.setString(4, p.getAltura());
			prepare.setString(5, p.getPeso());
			prepare.setInt(6, p.getSexo());
			prepare.setInt(7, p.getCodCategoria());										
			prepare.executeUpdate();
		}		
	}

	public void inserirHabilidadePokemon(ArrayList<HabilidadePokemon> listaHabPoke) throws SQLException{
		
		String sql = "INSERT INTO habilidadePokemon (codHabilidade,codPokemon)"
				+ " VALUES(?,?);";	
		
		for (int i=0; i< listaHabPoke.size(); i++) {
			
			HabilidadePokemon hp = listaHabPoke.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setInt(1, hp.getCodHabilidade());
			prepare.setInt(2, hp.getCodPokemon());
			prepare.executeUpdate();
			
		}
		
	}
	
	
}
