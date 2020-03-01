package es.salesianos.connection;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import es.salesianos.model.Pokemon;

public interface ConnectionManager {

	public Connection open(String jdbcUrl);

	public void close(Connection conn);

	void insert(Pokemon pokemon);

	Optional<Pokemon> search(Pokemon pokemon);

	void update(Pokemon pokemon);

	List<Pokemon> listAllUsers();

}
