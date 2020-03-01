package es.salesianos.repository;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import es.salesianos.model.Pokemon;

@Component
public class PokemonRepository {

	private static Logger log = LogManager.getLogger(PokemonRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Pokemon pokeFormulario) {
		System.out.println("insertando pokemon");
		String sql = "INSERT INTO POKEMON (codigo,nombre)" + "VALUES ( :codigo, :nombre)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codig", pokeFormulario.getCodigo());
		params.addValue("nombre", pokeFormulario.getNombre());
		namedJdbcTemplate.update(sql, params);
	}

	public Optional<Pokemon> search(Pokemon poke) {
		String sql = "SELECT * FROM POKEMON WHERE codigo = ?";
		System.out.println("ejecutando consulta " + sql);
		Pokemon pokAux = null;
		try {
			pokAux = (Pokemon) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Pokemon.class),
					poke.getCodigo());
		} catch (EmptyResultDataAccessException e) {
			log.error("error", e);
		}
		return Optional.ofNullable(pokAux);

	}

	public void update(Pokemon poke) {
		String sql = "UPDATE pokemon SET " + "nombre = ? WHERE codigo = ?";
		System.out.println("actualizando pokemon " + sql);
		jdbcTemplate.update(sql, poke.getNombre(), poke.getCodigo());
	}

	public List<Pokemon> listAllPokemon() {
		String sql = "SELECT * FROM POKEMON";
		List<Pokemon> pokes = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Pokemon.class));
		return pokes;
	}

	public void delete(String tablename, Integer id) {
		System.out.println("tablename " + tablename);
		String sql = "DELETE FROM " + tablename + " WHERE codigo = '?'";
		System.out.println("consulta " + sql);
	}

}
