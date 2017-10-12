package apresentacoes;

import java.io.File;
import java.io.IOException;

import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;

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
		
		
		//exemplo de leitura de CSV
//		System.out.println("Lendo Arquivo CSV");
//		System.out.println("*************************");
//		try {
//			CsvMapper mapper = new CsvMapper();			
//			mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
//
//
//			CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader().withoutQuoteChar();
//			File csvFile = new File("./pokebase.csv"); 
//			MappingIterator<PokemonCSV> it = mapper.readerFor(PokemonCSV.class).with(schema).readValues(csvFile);
//			
//			while (it.hasNext()) {
//				PokemonCSV csv = it.next();
//				System.out.println(csv.getAltura() + "\t" + csv.getCategoria() + "\t" + csv.getDescricao() + "\t" + 
//				csv.getHabilidade() + "\t" + csv.getNome() + "\t" + csv.getSexo());
//				
//			}
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*************************\n");
		
		
		
//		System.out.println("Lendo Arquivo JSON");
//		System.out.println("*************************");
//		try {
//			ObjectMapper mapper = new ObjectMapper();
//			PokemonJSON[] poke = mapper.readValue(new File("./pokemon.json"), PokemonJSON[].class);
//			
//			for(int i = 0; i < poke.length; i++){
//				System.out.print(poke[i].getCategoria() + "\t" + poke[i].getDescricao() + "\t" + poke[i].getNome() + "\t"
//						+ poke[i].getPeso() + "\t" + poke[i].getSexo() + "\t");
//				
//				for(int j = 0; j < poke[i].getTipos().size(); j++){
//					System.out.print(poke[i].getTipos().get(j).getTipo() + "\t");
//				}
//				System.out.println();
//			}
//			
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("*************************\n");
//		
		
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
