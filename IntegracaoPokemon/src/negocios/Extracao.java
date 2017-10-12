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
	
	public Extracao(){
		listaCSV = new ArrayList<PokemonCSV>();
	}
	
	public void extrairArquivoCSV() throws JsonProcessingException, IOException{

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
}
