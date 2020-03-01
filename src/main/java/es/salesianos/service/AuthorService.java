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
@Profile("zaragoza")
public class AuthorService implements Service {

	@Autowired
	private PokemonAssembler assembler;
	@Autowired
	private PokemonRepository repository;

	public void createNewUserFromRequest(HttpServletRequest req) {
		Pokemon poke = assembler.createPokemonFromRequest(req);

		insertOrupdatePokemon(poke);
	}

	public void insertOrupdatePokemon(Pokemon poke) {
		if (!repository.search(poke).isPresent()) {
			repository.insert(poke);
		} else {
			repository.update(poke);
		}
	}

	@Override
	public List<Pokemon> listAllPokemon() {
		return repository.listAllPokemon();
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
		String defaultTableName = "pokemon";
		this.delete(defaultTableName, id);
	}

	@Override
	public void delete(String tablename, Integer id) {
		repository.delete(tablename, id);
	}
}
