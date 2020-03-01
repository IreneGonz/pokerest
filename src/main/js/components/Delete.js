import React from "react";


export default class Delete extends React.Component {

	constructor(props) {
		super(props)
		this.state = { id: props.id }
    }
    
    delete(event){
        fetch('/api/v1/pokemon/delete/pokemon/?codigo='+this.state.codigo)
    }

	render() {
		return (
				<button onClick={this.delete}>
					borrar codigo
				</button>
			)
		

    
  }
}