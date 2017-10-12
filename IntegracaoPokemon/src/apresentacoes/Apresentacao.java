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
	
	public static void main(String[] args){
		
		//Lendo CSV
//		try {
//			
//			ArrayList<PokemonCSV> csv = new ArrayList<PokemonCSV>();
//			Extracao extracao = new Extracao();
//			PokemonCSV pokeCsv = new PokemonCSV();
//			
//			extracao.lerArquivoCSV();
//			csv = extracao.getListaCSV();
//			
//			
//			for(int i = 0; i < csv.size(); i++){			
//				
//				pokeCsv = csv.get(i);				
//				System.out.println(pokeCsv.getAltura() + "\t" + pokeCsv.getCategoria() + "\t" + pokeCsv.getDescricao() + "\t" + 
//						pokeCsv.getHabilidade() + "\t" + pokeCsv.getNome() + "\t" + pokeCsv.getSexo());				
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		//Lendo JSON
//		try {
//			
//			ArrayList<PokemonJSON> json = new ArrayList<PokemonJSON>();
//			Extracao extracao = new Extracao();
//			PokemonJSON pokeJson = new PokemonJSON();
//			
//			extracao.lerArquivoJSON();
//			json = extracao.getListaJSON();
//			
//			
//			for(int i = 0; i < json.size(); i++){			
//				
//				pokeJson = json.get(i);				
//				
//				System.out.print(pokeJson.getCategoria() + "\t" + pokeJson.getDescricao() + "\t" + pokeJson.getNome() + "\t"
//						+ pokeJson.getPeso() + "\t" + pokeJson.getSexo() + "\t");
//					
//				for(int j = 0; j < pokeJson.getTipos().size(); j++){
//					System.out.print(pokeJson.getTipos().get(j).getTipo() + "\t");
//				}
//				
//				System.out.println();
//								
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		//Lendo XML
//		try {
//			
//			ArrayList<PokemonXML> xml = new ArrayList<PokemonXML>();
//			Extracao extracao = new Extracao();
//			PokemonXML pokeXml = new PokemonXML();
//			
//			extracao.lerArquivoXML();
//			xml = extracao.getListaXML();
//			
//			
//			for(int i = 0; i < xml.size(); i++){			
//				
//				pokeXml = xml.get(i);				
//				
//				System.out.print(pokeXml.getCategoria() + "\t" + pokeXml.getDescricao() + "\t" + pokeXml.getNome() + "\t"
//						+ pokeXml.getPeso() + "\t" + pokeXml.getSexo() + "\t");
//				
//				for(int j = 0; j < pokeXml.getFraquezas().size(); j++){
//					System.out.print(pokeXml.getFraquezas().get(j).getFraqueza() + "\t");
//				}
//				
//				System.out.println();
//								
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}

}
