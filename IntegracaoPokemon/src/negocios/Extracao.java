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
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Extracao {
	
	private ArrayList<PokemonCSV> listaCSV;
	private ArrayList<PokemonJSON> listaJSON;
	private ArrayList<PokemonXML> listaXML;
	
	public Extracao(){
		listaCSV = new ArrayList<PokemonCSV>();
		listaJSON = new ArrayList<PokemonJSON>();
		listaXML = new ArrayList<PokemonXML>();
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
			listaJSON.add(new PokemonJSON(poke[i].getNome(),poke[i].getDescricao(),poke[i].getPeso(),poke[i].getSexo(),
					poke[i].getCategoria(),poke[i].getTipos()));			
		}
		
	}
	
	public void lerArquivoXML() throws JsonParseException, JsonMappingException, IOException{
	
		ObjectMapper xmlMapper = new XmlMapper();
		PokemonXML[] poke = xmlMapper.readValue(new File("./pokemon.xml"), PokemonXML[].class);
			
		for(int i = 0; i < poke.length; i++){
			
			listaXML.add(new PokemonXML(poke[i].getNome(),poke[i].getDescricao(),poke[i].getPeso(),poke[i].getPeso(),
					poke[i].getCategoria(),poke[i].getFraquezas()));			
		}
	}
	
	public void lerBancoDados(){
		
	}
	
	public ArrayList<PokemonCSV> getListaCSV(){
		return listaCSV;
	}
	
	public ArrayList<PokemonJSON> getListaJSON(){
		return listaJSON;
	}
	
	public ArrayList<PokemonXML> getListaXML(){
		return listaXML;
	}
	
}
