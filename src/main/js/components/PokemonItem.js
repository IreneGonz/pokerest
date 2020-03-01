import React from "react";
import Delete from "./Delete"
export default class PokemonItem extends React.Component {

	constructor(props) {
		super(props)
	}

  render() {

    const { poke } = this.props;
  
    return (
      <div class="well col-md-4 col-md-offset-4" key={poke.codigo}>
        codigo: {poke.nombre} nombre: {poke.nombre}<br/>
        <Delete codigo={poke.codigo}/>
      </div> 
    );
  }
}
