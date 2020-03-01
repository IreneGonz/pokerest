import React from "react";
import { addPokemon } from "../actions/pokemonActions"

export default class AddPokemonForm extends React.Component {

  constructor() {
    super();
    this.state = {

      codigo: "",
      nombre: "",
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
      this.addPokemon();
      console.log("item inserted")
    }
  }

  addPokemon() {
    addPokemon(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
    <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
      <div>
        <input type="text" class="form-control"
          name="codigo"
          placeholder="Add a new pokemon codigo..."
          value={this.state.codigo}
          onChange={handleChange.bind(this)}
          onKeyDown={keyPressed.bind(this)} />
        <input type="text" class="form-control"
          name="nombre"
          placeholder="Add a new pokemon nombre..."
          value={this.state.nombre}
          onChange={handleChange.bind(this)}
          onKeyDown={keyPressed.bind(this)} />
      </div>
      <div>
        <button className="btn btn-default" type="button" onClick={this.addPokemon.bind(this)}>Insertar Pokemon</button>
      </div>
    </div>
>
      );
  }
}