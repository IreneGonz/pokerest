import React from "react"
import { addPokemon } from "../actions/pokemonActions"
import AddPokemonForm from "./AddPokemonForm"
import PokemonList from "./PokemonList"

export default class Layout extends React.Component {

  render() {
   
    return (
      <div class="text-center">
        <AddPokemonForm />
        <PokemonList />
      </div>
    )
  }
}
