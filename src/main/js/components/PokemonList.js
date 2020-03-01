import React from "react";
import PokemonItem from "./PokemonItem"
import PokemonCount from "./PokemonCount"

export default class PokemonList extends React.Component {

	constructor(props) {
		super(props)
		this.state = { pokemons: [] }
	}

	render() {
		if (this.state.pokemons.length == 0) {	
			fetch('/api/v1/pokemon/list/')
			.then((response) => {
				var pokemon = response.json(); 
				this.state = { pokemons: [...this.state.pokemons, pokemon] }
			})			
		}

		if (this.state.pokemons.length > 0) {
		
			var pokemonItems = [];
			this.state.pokemons.forEach(
				(poke) => {
					pokemonItems.push(<PokemonItem pokemon={poke} />)
				}
			)
		return (
				<div>
					{pokemonItems}
					<PokemonCount  count={pokemonItems.length}/>
				</div>
			)
		} else {
			return <p className="text-center">Loading pokemons...</p>
		}
    
	}
}