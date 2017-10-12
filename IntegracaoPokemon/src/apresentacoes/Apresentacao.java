package apresentacoes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;

import negocios.Extracao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
		
		
		
//		System.out.println("Lendo Arquivo XML");
//		System.out.println("*************************");
//		
//		try {
//			ObjectMapper xmlMapper = new XmlMapper();
//			
//			PokemonXML[] poke = xmlMapper.readValue(new File("./pokemon.xml"), PokemonXML[].class);
//			
//			for(int i = 0; i < poke.length; i++){
//				System.out.print(poke[i].getNome() + "\t" + poke[i].getDescricao() + "\t" + poke[i].getCategoria()
//				+ "\t" + poke[i].getPeso()+ "\t");
//				
//				for(int j = 0; j < poke[i].getFraquezas().size(); j++){
//					System.out.print(poke[i].getFraquezas().get(j).getFraqueza()+ "\t");
//				}
//				
//				System.out.println();
//			}
//			
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*************************\n");
//		
	}

}
