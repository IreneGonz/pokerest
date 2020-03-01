package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Pokemon;

public interface Service {

	void createNewUserFromRequest(HttpServletRequest req);

	void insertOrupdatePokemon(Pokemon poke);

	List<Pokemon> listAllPokemon();

	void delete(Integer id);

	void delete(String tablename, Integer id);

}
