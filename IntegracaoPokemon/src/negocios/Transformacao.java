package negocios;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import objetos.Pokemon;
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
			poke.setNome(pokeXML.getNome());
			poke.setDescricao(pokeXML.getDescricao());
			poke.setPeso(pokeXML.getPeso());
			poke.setSexo(pokeXML.getSexo());
			poke.setCategoria(pokeXML.getCategoria());
			poke.setFraquezas(pokeXML.getFraquezas());
			listaPokemon.add(poke);			
		}
		
	}
	
	public ArrayList<Pokemon> getListaPokemon(){
		return listaPokemon;
	}
	
	public void imprimir() throws JsonParseException, JsonMappingException, IOException{
		
		for(int i = 0; i < listaPokemon.size(); i++){			
			System.out.println(listaPokemon.get(i).getNome() + "\t" + listaPokemon.get(i).getCategoria());
		}
	}
}
