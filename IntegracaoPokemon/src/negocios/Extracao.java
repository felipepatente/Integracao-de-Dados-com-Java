package negocios;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.PokemonBD;
import objetos.PokemonCSV;
import objetos.PokemonJSON;
import objetos.PokemonXML;
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

public class Extracao {
	
	private ArrayList<PokemonCSV> listaCSV;
	private ArrayList<PokemonJSON> listaJSON;
	private ArrayList<PokemonXML> listaXML;
	private ArrayList<PokemonBD> listaBD;
	
	public Extracao(){
		listaCSV = new ArrayList<PokemonCSV>();
		listaJSON = new ArrayList<PokemonJSON>();
		listaXML = new ArrayList<PokemonXML>();
		listaBD = new ArrayList<PokemonBD>();
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
	
	public void lerBancoDados() throws Exception{
			
		Conexao conexao = new Conexao();
		Connection conn = conexao.getConexao();
		PreparedStatement ps = 
				conn.prepareStatement("SELECT [Numero Pokedex], Nome, Descrição, Categoria, Sexo, [Evolui De] FROM pokebase;");
		ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listaBD.add(new PokemonBD(rs.getString("Numero Pokedex"),rs.getString("Nome"),rs.getString("descrição"),
						rs.getString("Categoria"),rs.getString("sexo"),rs.getString("Evolui De")));
			
			}
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
	
	public ArrayList<PokemonBD> getListaBD(){
		return listaBD;
	}
	
}
