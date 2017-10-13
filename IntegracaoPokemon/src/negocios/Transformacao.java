package negocios;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import conexoes.Conexao;
import objetos.Fraqueza;
import objetos.Pokemon;
import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;

public class Transformacao {
	
	private ArrayList<Pokemon> listaPokemon;
	
	public Transformacao(){
		listaPokemon = new ArrayList<Pokemon>();
	}
	
	public void getDadosXMLToPokemon(ArrayList<PokemonXML> listaXML){
		
		PokemonXML pokeXML = new PokemonXML();
		Pokemon poke = new Pokemon();
		
		for(int i = 0; i < listaXML.size(); i++){
			
			pokeXML = listaXML.get(i);		
			listaPokemon.add(new Pokemon(pokeXML.getNome(),pokeXML.getDescricao(),pokeXML.getPeso(),pokeXML.getSexo(),
					pokeXML.getCategoria(),pokeXML.getFraquezas()));			
		}
		
	}
	
	
	public void getDadosJSONToPokemon(ArrayList<PokemonJSON> listaJSON){
		
		PokemonJSON pokeJSON = new PokemonJSON();
		
		for(int i = 0; i < listaJSON.size(); i++){			
			listaPokemon.get(i).setTipos(listaJSON.get(i).getTipos());
		}
		
	}
	
	public void getDadosCSVToPokemon(ArrayList<PokemonCSV> listaCSV){
		
		PokemonJSON pokeJSON = new PokemonJSON();
		
		for(int i = 0; i < listaCSV.size(); i++){			
			listaPokemon.get(i).setAltura(listaCSV.get(i).getAltura());
			listaPokemon.get(i).setEvoluiDe(listaCSV.get(i).getEvoluide());
			listaPokemon.get(i).setHabilidade(listaCSV.get(i).getHabilidade());			
		}		
	}
	
	public ArrayList<Pokemon> getListaPokemon(){
		return listaPokemon;
	}
	
	public void inserirPokemon() throws Exception{
	
		Conexao conexao = new Conexao();
		PreparedStatement prepare;
		Connection conn = conexao.getConexao();
		
		String sql = "INSERT INTO Pokemons (nome,descricao,peso,sexo,categoria,fraquezas,tipos,altura,evoluiDe,habilidade)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?);";	
		String aux = "";
		
		for (int i=0; i< listaPokemon.size(); i++) {
			
			Pokemon p = listaPokemon.get(i);
			aux = "";
			
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, p.getNome());
			prepare.setString(2, p.getDescricao());
			prepare.setString(3, p.getPeso());
			prepare.setString(4, p.getSexo());
			prepare.setString(5, p.getCategoria());
			
			for(int j = 0; j < p.getFraquezas().size(); j++){
				aux += p.getFraquezas().get(j).getFraqueza();
				
				if(j < p.getFraquezas().size() - 1){
					aux += ";";
				}
			}
			
			prepare.setString(6, aux);
			
			aux = "";
			for(int j = 0; j < p.getTipos().size(); j++){
				aux += p.getTipos().get(j).getTipo();
				
				if(j < p.getTipos().size() - 1){
					aux += ";";
				}
			}
			
			prepare.setString(7, aux);
			prepare.setString(8, p.getAltura());
			prepare.setString(9, p.getEvoluiDe());
			prepare.setString(10, p.getHabilidade());
			
			prepare.executeUpdate();
			
		}	
	}
	
	
}
