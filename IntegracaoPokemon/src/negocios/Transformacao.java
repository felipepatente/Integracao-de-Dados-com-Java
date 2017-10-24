package negocios;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.StyleSheet.ListPainter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import conexoes.Conexao;
import objetos.Categoria;
import objetos.Fraqueza;
import objetos.Habilidade;
import objetos.HabilidadePokemon;
import objetos.Pokemon;
import objetos.PokemonBD;
import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;
import objetos.Sexo;
import objetos.Tipo;
import objetos.TipoPokemon;
import objetos.bdFraqueza;
import objetos.bdPokemon;
import objetos.bdTipoPokemon;

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
			
		for(int i = 0; i < listaBD.size(); i++){			

			for(int j = 0; j < listaPokemon.size(); j++){
				
				if(listaBD.get(i).getNome().equals(listaPokemon.get(j).getNome())){
					listaPokemon.get(j).setNumeroPokedex(listaBD.get(i).getNumero());
					System.out.println(listaPokemon.get(j).getNome() + "\t" + listaBD.get(i).getNome());
				}
				
			}
			
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
			String[] habilidades = listaPokemon.get(i).getHabilidade().split(",");
			
			for(int j = 0; j < habilidades.length; j++){
								
				for(int m = 0; m < listaHabilidade.size(); m++){
					
					if(habilidades[j].toLowerCase().trim().equals(listaHabilidade.get(m).getNmHabilidade())){
						temHabilidade = false;
						break;
					}					
				}
				
				if(temHabilidade){
					listaHabilidade.add(new Habilidade(codHabilidade,habilidades[j].trim().toLowerCase(),listaPokemon.get(i).getDescricao()));
					codHabilidade++;
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
	
	
	public ArrayList<Tipo> getListaTipo(){
		
		ArrayList<Tipo> listaTipo = new ArrayList<Tipo>();
		boolean temTipo;
		int codTipo = 1;
		
		for(int i = 0; i < listaPokemon.size(); i++){
						
			for(int j = 0; j < listaPokemon.get(i).getTipos().size(); j++){
				
				temTipo = true;
				for(int m = 0; m < listaTipo.size(); m++){
					
					if(listaPokemon.get(i).getTipos().get(j).getTipo().trim().equals(listaTipo.get(m).getNmTipo())){						
						temTipo = false;
						break;
					}
					
				}
				
				if(temTipo){
					listaTipo.add(new Tipo(codTipo,listaPokemon.get(i).getTipos().get(j).getTipo().trim()));
					codTipo++;
				}
			}			
		}
		
		return listaTipo;
	}
	
	
	public ArrayList<bdPokemon> getListaPokemonbd(){
		
		ArrayList<bdPokemon> listaPoke = new ArrayList<bdPokemon>();
		ArrayList<Sexo> listaSexo = getListaSexo();
		Pokemon pokemon = new Pokemon();
		ArrayList<Categoria> listaCategoria = this.getListaCategoria();
		int codPokemon = 0;
		int sexo = 0;
		float aux = 0f;
		int codCategoria = 0;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			for(int j = 0; j < listaCategoria.size(); j++){
				
				if(listaPokemon.get(i).getCategoria().equals(listaCategoria.get(j).getNmCategoria())){
					 codCategoria = listaCategoria.get(j).getCodCategoria();		
					 break;
				}							
			}
			pokemon = listaPokemon.get(i);
			
			aux = Float.parseFloat(listaPokemon.get(i).getNumeroPokedex());
			codPokemon = (int) aux;
			
			for(int n = 0; n < listaSexo.size(); n++){
				
				if(listaPokemon.get(i).getSexo().equals(listaSexo.get(n).getTipoSexo())){					
					sexo = listaSexo.get(n).getSexo();
				}
			}
			
			listaPoke.add(new bdPokemon(codPokemon, listaPokemon.get(i).getNome(), listaPokemon.get(i).getDescricao(), 
					listaPokemon.get(i).getAltura(), listaPokemon.get(i).getPeso(), sexo,codCategoria, GetEvolucao(pokemon))); 
					
		}
		
		return listaPoke;
	}
	
	private int GetEvolucao(Pokemon pokemon){
		
		int numeroPokemon = 0;
		float aux = 0f;
		
		if(!(pokemon.getEvoluiDe().equals(""))){

			for(int i = 0; i < listaPokemon.size(); i++){
				
				if(pokemon.getEvoluiDe().equals(listaPokemon.get(i).getNome())){												
					aux = Float.parseFloat(listaPokemon.get(i).getNumeroPokedex());
					numeroPokemon = (int) aux;
					return numeroPokemon;
				}
				
			}
		}			
		
		return numeroPokemon;
	}
	
	
	public ArrayList<HabilidadePokemon> getListaHabPoke(){
		
		ArrayList<HabilidadePokemon> listaHabPoke = new ArrayList<HabilidadePokemon>();
		ArrayList<Habilidade> listaHabilidade = getListaHabilidade();
		boolean pokemonTemHabilidade;
		int codHabilidade = 0;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			String[] habilidades = listaPokemon.get(i).getHabilidade().split(",");
			
			for(int j = 0; j < habilidades.length; j++){
				
				pokemonTemHabilidade = false;
				
				for(int m = 0; m < listaHabilidade.size(); m++){
					
					if(habilidades[j].toLowerCase().trim().equals(listaHabilidade.get(m).getNmHabilidade())){						
						codHabilidade = listaHabilidade.get(m).getCodHabilidade();
						pokemonTemHabilidade = true;
						//break;
					}					
				}
				
				if(pokemonTemHabilidade){
					
					float aux = Float.parseFloat(listaPokemon.get(i).getNumeroPokedex());
					int numeroPokemon = (int) aux;					
					listaHabPoke.add(new HabilidadePokemon(codHabilidade, numeroPokemon));
				}
				
			}
			
		}
		
		return listaHabPoke;
	}
	
	
	//Depois ajustar este método para se adequar a tabela fraqueza do banco
	public ArrayList<bdTipoPokemon> getListaFraqueza(){
		
		ArrayList<bdTipoPokemon> listaTpPokemon = new ArrayList<bdTipoPokemon>();
		ArrayList<Tipo> listaTipo = getListaTipo();
		
		boolean pokemonTemTipo;
		int codTipo = 0;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			for(int j = 0; j < listaPokemon.get(i).getTipos().size(); j++){
				
				pokemonTemTipo = false;
				
				for(int m = 0; m < listaTipo.size(); m++){
					
					if(listaPokemon.get(i).getTipos().get(j).getTipo().trim().equals(listaTipo.get(m).getNmTipo())){						
						codTipo = listaTipo.get(m).getCodTipo();
						pokemonTemTipo = true;
					}
								
				}
				
				if(pokemonTemTipo){
					
					float aux = Float.parseFloat(listaPokemon.get(i).getNumeroPokedex());
					int numeroPokemon = (int) aux;					
					listaTpPokemon.add(new bdTipoPokemon(numeroPokemon, codTipo));
				}			
			}		
		}
			
		return listaTpPokemon;
	}
	
	public ArrayList<bdTipoPokemon> getListaTipoPokemon(){
		
		ArrayList<bdTipoPokemon> listaTpPokemon = new ArrayList<bdTipoPokemon>();
		ArrayList<Tipo> listaTipo = getListaTipo();
		
		boolean pokemonTemTipo;
		int codTipo = 0;
		
		for(int i = 0; i < listaPokemon.size(); i++){
			
			for(int j = 0; j < listaPokemon.get(i).getTipos().size(); j++){
				
				pokemonTemTipo = false;
				
				for(int m = 0; m < listaTipo.size(); m++){
					
					if(listaPokemon.get(i).getTipos().get(j).getTipo().trim().equals(listaTipo.get(m).getNmTipo())){						
						codTipo = listaTipo.get(m).getCodTipo();
						pokemonTemTipo = true;
					}
								
				}
				
				if(pokemonTemTipo){
					
					float aux = Float.parseFloat(listaPokemon.get(i).getNumeroPokedex());
					int numeroPokemon = (int) aux;					
					listaTpPokemon.add(new bdTipoPokemon(numeroPokemon, codTipo));
				}			
			}		
		}
			
		return listaTpPokemon;
	}	
}
