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
import objetos.Categoria;
import objetos.Fraqueza;
import objetos.Habilidade;
import objetos.Pokemon;
import objetos.PokemonBD;
import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;
import objetos.Sexo;

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
	
	public void getDadosBDToPokemon(ArrayList<PokemonBD> listaBD){
		
		PokemonJSON pokeJSON = new PokemonJSON();		
		for(int i = 0; i < listaBD.size(); i++){			
			listaPokemon.get(i).setNumeroPokedex(listaBD.get(i).getNumero());			
		}		
	}
	
	public ArrayList<Pokemon> getListaPokemon(){
		return listaPokemon;
	}
	
	//Depois excluir esse método
	public void inserirPokemon() throws Exception{
	
		Conexao conexao = new Conexao();
		PreparedStatement prepare;
		Connection conn = conexao.getConexao();
		
		String sql = "INSERT INTO Pokemons (nome,descricao,peso,sexo,categoria,fraquezas,tipos,altura,evoluiDe,habilidade,numeroPokedex)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?);";	
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
			prepare.setString(11, p.getNumeroPokedex());
			
			prepare.executeUpdate();
			
		}	
	}
	
	
	public ArrayList<Categoria> getListaCategoria(){
		
		ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
		boolean temCategoria;
		int codCategoria = 1;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			temCategoria = true;
			
			for(int j = 0; j < listaCategoria.size(); j++){
				
				if(listaPokemon.get(i).getCategoria().equals(listaCategoria.get(j).getNmCategoria())){
					temCategoria = false;
					break;
				}				
			}
			
			if(temCategoria){
				listaCategoria.add(new Categoria(codCategoria,listaPokemon.get(i).getCategoria()));
				codCategoria++;
			}		
		}
		
		return listaCategoria;
	}
	
	
	public ArrayList<Habilidade> getListaHabilidade(){
		
		ArrayList<Habilidade> listaHabilidade = new ArrayList<Habilidade>();
		boolean temHabilidade;
		int codHabilidade = 1;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			temHabilidade = true;
			String[] fraquezas = listaPokemon.get(i).getHabilidade().split(",");
			
			for(int j = 0; j < fraquezas.length; j++){
				
				for(int m = 0; m < listaHabilidade.size(); m++){
					
					if(fraquezas[j].toLowerCase().equals(listaHabilidade.get(m).getNmHabilidade())){
						temHabilidade = false;
						break;
					}					
				}
				
				if(temHabilidade){
					listaHabilidade.add(new Habilidade(codHabilidade,fraquezas[j].trim().toLowerCase(),listaPokemon.get(i).getDescricao()));
				}			
			}			
		}
		
		return listaHabilidade;		
	}
	
	
	public ArrayList<Sexo> getListaSexo(){
		
		ArrayList<Sexo> listaSexo = new ArrayList<Sexo>();
		boolean temSexo;
		int sexo = 1;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			temSexo = true;
			
			for(int j = 0; j < listaSexo.size(); j++){				
				if(listaPokemon.get(i).getSexo().equals(listaSexo.get(j).getTipoSexo())){
					temSexo = false;
					break;
				}				
			}
			
			if(temSexo){
				listaSexo.add(new Sexo(sexo,listaPokemon.get(i).getSexo()));
				sexo++;
			}
			
		}
		
		return listaSexo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
