package apresentacoes;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;
import negocios.Extracao;
import negocios.Transformacao;
import objetos.Categoria;
import objetos.Habilidade;
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
		ext.lerArquivoJSON();
		ext.lerArquivoCSV();
		ext.lerBancoDados();
		
		ArrayList<PokemonXML> listaXML =  ext.getListaXML();
		ArrayList<PokemonJSON> listaJSON =  ext.getListaJSON();
		ArrayList<PokemonCSV> listaCSV =  ext.getListaCSV();
		ArrayList<PokemonBD> listaBD =  ext.getListaBD();
		
		trans.getDadosXMLToPokemon(listaXML);
		trans.getDadosJSONToPokemon(listaJSON);
		trans.getDadosCSVToPokemon(listaCSV);
		trans.getDadosBDToPokemon(listaBD);
		
		
		ArrayList<Categoria> listaCategoria = trans.getListaCategoria();
		ArrayList<Habilidade> listaHabilidade = trans.getListaHabilidade();
		
		
		System.out.println(listaHabilidade.size());
		for(int i = 0; i < listaHabilidade.size(); i++){
			
			System.out.println(listaHabilidade.get(i).getNmHabilidade());			
		}
		
		//trans.inserirPokemon();

		System.out.println("Acabou");
		
	}

}
