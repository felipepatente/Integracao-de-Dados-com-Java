package negocios;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

public class Extracao {
	
	private ArrayList<PokemonCSV> listaCSV;
	private ArrayList<PokemonJSON> listaJSON;
	
	public Extracao(){
		listaCSV = new ArrayList<PokemonCSV>();
		listaJSON = new ArrayList<PokemonJSON>();
	}
	
	public void lerArquivoCSV() throws JsonProcessingException, IOException{

		CsvMapper mapper = new CsvMapper();			
		mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
		CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader().withoutQuoteChar();
		File csvFile = new File("./pokebase.csv"); 
		MappingIterator<PokemonCSV> it = mapper.readerFor(PokemonCSV.class).with(schema).readValues(csvFile);
			
		while (it.hasNext()) {
			PokemonCSV csv = it.next();
			listaCSV.add(csv);
				
		}
	}
	
	public void lerArquivoJSON() throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		PokemonJSON[] poke = mapper.readValue(new File("./pokemon.json"), PokemonJSON[].class);
			
		for(int i = 0; i < poke.length; i++){
			System.out.print(poke[i].getCategoria() + "\t" + poke[i].getDescricao() + "\t" + poke[i].getNome() + "\t"
					+ poke[i].getPeso() + "\t" + poke[i].getSexo() + "\t");
				
			for(int j = 0; j < poke[i].getTipos().size(); j++){
				System.out.print(poke[i].getTipos().get(j).getTipo() + "\t");
			}
			System.out.println();
		}
		
	}
	
	public ArrayList<PokemonCSV> getListaCSV(){
		return listaCSV;
	}
	
	public ArrayList<PokemonJSON> getListaJSON(){
		return listaJSON;
	}
	
}
