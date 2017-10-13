package negocios;

import java.util.ArrayList;

import objetos.Pokemon;
import objetos.PokemonXML;

public class Transformacao {
	
	private ArrayList<Pokemon> listaPokemon;
	
	public Transformacao(){
		listaPokemon = new ArrayList<Pokemon>();
	}
	
	public void transformarXML(ArrayList<PokemonXML> listaXML){
		
		PokemonXML pokeXML = new PokemonXML();
		Pokemon poke = new Pokemon();
		
		for(int i = 0; i < listaXML.size(); i++){
			
			pokeXML = listaXML.get(i);
			poke.setNome(pokeXML.getNome());
			poke.setDescricao(pokeXML.getDescricao());
			poke.setPeso(poke.getPeso());
			poke.setSexo(poke.getSexo());
			poke.setCategoria(poke.getCategoria());
			poke.setFraquezas(poke.getFraquezas());
			listaPokemon.add(poke);
		}
		
	}
	
	public ArrayList<Pokemon> getListaPokemon(){
		return listaPokemon;
	}
}
