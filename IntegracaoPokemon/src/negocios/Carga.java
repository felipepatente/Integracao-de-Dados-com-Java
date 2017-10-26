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
import objetos.bdFraqueza;
import objetos.bdPokemon;
import objetos.bdTipoPokemon;

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
	
	public void inserirPokemon(ArrayList<bdPokemon> listaPokemon, ArrayList<Pokemon> pokemon) throws SQLException{
		
		String sql = "INSERT INTO Pokemon (codPokemon,nome,descricao,altura,peso,sexo,codCategoria)"
				+ " VALUES(?,?,?,?,?,?,?);";
		
		for (int i=0; i< listaPokemon.size(); i++) {
			
			bdPokemon p = listaPokemon.get(i);	
			prepare = conn.prepareStatement(sql);
			prepare.setInt(1, p.getCodPokemon());
			prepare.setString(2, p.getNome());
			prepare.setString(3, p.getDescricao());
			prepare.setDouble(4, p.getAltura());
			prepare.setDouble(5, p.getPeso());
			prepare.setInt(6, p.getSexo());
			prepare.setInt(7, p.getCodCategoria());										
			prepare.executeUpdate();
		}	
		
//		Transformacao trans = new Transformacao();		
		inserirEvoluiDe(listaPokemon, pokemon);
		
	}
	
	private void inserirEvoluiDe(ArrayList<bdPokemon> listaPokemon, ArrayList<Pokemon> pokemon) throws SQLException{
		
		String sql = "UPDATE Pokemon SET evoluiDe = ? WHERE codPokemon = ?";

		for (int i=0; i < listaPokemon.size(); i++) {
			
			bdPokemon p = listaPokemon.get(i);
			Pokemon po = pokemon.get(i);
			
			prepare = conn.prepareStatement(sql);	
			listaPokemon.get(i).setEvoluiDe(getEvoluiDe(po.getEvoluiDe(), pokemon));
			
			if(p.getEvoluiDe() != 0){

				prepare.setInt(1, p.getEvoluiDe());
				prepare.setInt(2, p.getCodPokemon());													
				prepare.executeUpdate();
			}
		}
		
	}
	
	private int getEvoluiDe(String evouiDe,ArrayList<Pokemon> pokemon){
				
		for(int i = 0; i < pokemon.size(); i++){
			
			Pokemon po = pokemon.get(i);

			if(evouiDe.trim().equals(po.getNome().trim())){				
				float aux = Float.parseFloat(po.getNumeroPokedex());
				return (int) aux;
			}			
		}
		
		return 0;
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
	
	public void inserirFraqueza(ArrayList<bdFraqueza> listaFraqueza) throws SQLException{
		
		String sql = "INSERT INTO fraqueza (codPokemon,CodTipo)"
				+ " VALUES(?,?);";	
		
		for (int i=0; i< listaFraqueza.size(); i++) {
			
			bdFraqueza f = listaFraqueza.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setInt(1, f.getCodPokemon());
			prepare.setInt(2, f.getCodTipo());
			prepare.executeUpdate();			
		}		
	}
	
	public void inserirTipoPokemon(ArrayList<bdTipoPokemon> listaTipoPokemon) throws SQLException{
		
		String sql = "INSERT INTO tipoPokemon (codPokemon,CodTipo)"
				+ " VALUES(?,?);";	
		
		for (int i=0; i< listaTipoPokemon.size(); i++) {
			
			bdTipoPokemon tp = listaTipoPokemon.get(i);		
			prepare = conn.prepareStatement(sql);			
			prepare.setInt(1, tp.getCodPokemon());
			prepare.setInt(2, tp.getCodTipo());
			prepare.executeUpdate();			
		}		
	}	
}
