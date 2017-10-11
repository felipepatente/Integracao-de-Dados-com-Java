package apresentacoes;

import java.io.File;
import java.io.IOException;

import objetos.PokemonCSV;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class Apresentacao {
	
	public static void main(String[] args){
		
		
		//exemplo de leitura de CSV
		System.out.println("Lendo Arquivo CSV");
		System.out.println("*************************");
		try {
			CsvMapper mapper = new CsvMapper();			
			mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);


			CsvSchema schema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader().withoutQuoteChar();
			File csvFile = new File("./pokebase.csv"); 
			MappingIterator<PokemonCSV> it = mapper.readerFor(PokemonCSV.class).with(schema).readValues(csvFile);
			while (it.hasNext()) {
				PokemonCSV csv = it.next();
				System.out.println(csv.getAltura() + "\t" + csv.getCategoria() + "\t" + csv.getDescricao() + "\t" + 
				csv.getHabilidade() + "\t" + csv.getNome() + "\t" + csv.getSexo());			
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*************************\n");
		
	}

}
