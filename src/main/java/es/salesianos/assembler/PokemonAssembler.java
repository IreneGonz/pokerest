package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import es.salesianos.model.Pokemon;

@Component
public class PokemonAssembler {

	public Pokemon createPokemonFromRequest(HttpServletRequest request) {
		Pokemon poke = new Pokemon();
		poke.setCodigo(request.getParameter("codigo"));
		poke.setNombre(request.getParameter("nombre"));
		return poke;
	}

}