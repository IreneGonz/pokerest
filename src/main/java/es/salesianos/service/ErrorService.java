package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import es.salesianos.assembler.PokemonAssembler;
import es.salesianos.model.Pokemon;
import es.salesianos.repository.PokemonRepository;

@Component
@Profile("huesca")
public class ErrorService implements Service {

	@Autowired
	private PokemonAssembler assembler;
	@Autowired
	private PokemonRepository repository;

	public void createNewUserFromRequest(HttpServletRequest req) {
		throw new RuntimeException("he reventado");
	}

	public void insertOrupdatePokemon(Pokemon poke) {
		throw new RuntimeException("he reventado");
	}

	@Override
	public List<Pokemon> listAllPokemon() {
		throw new RuntimeException("he reventado");
	}

	public PokemonAssembler getAssembler() {
		return assembler;
	}

	public void setAssembler(PokemonAssembler assembler) {
		this.assembler = assembler;
	}

	public PokemonRepository getRepository() {
		return repository;
	}

	public void setRepository(PokemonRepository repository) {
		this.repository = repository;
	}

	@Override
	public void delete(Integer id) {
		throw new RuntimeException("he reventado");
	}

	@Override
	public void delete(String tablename, Integer id) {
		throw new RuntimeException("he reventado");

	}
}
