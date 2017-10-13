package apresentacoes;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;
import negocios.Extracao;
import negocios.Transformacao;
import objetos.Pokemon;
import objetos.PokemonBD;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import conexoes.Conexao;

public class Apresentacao {
	
	public static void main(String[] args) throws Exception{
		
		Extracao ext = new Extracao();
		Transformacao trans = new Transformacao();
		
		ext.lerArquivoXML();
		ArrayList<PokemonXML> listaXML =  ext.getListaXML();
		trans.getDadosXMLToPokemon(listaXML);
		ArrayList<Pokemon> listaPoke =  trans.getListaPokemon();
		Pokemon poke = new Pokemon();
		
//		for(int i = 0; i < listaPoke.size(); i++){
//			
//			poke = listaPoke.get(i);
//			System.out.println(listaPoke.get(i).getCategoria());
//		}
		
		trans.inserirPokemon();
		System.out.println("Acabou");
		
	}

}
