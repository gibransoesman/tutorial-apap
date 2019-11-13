import React from 'react';
import List from "./components/List";
import EmptyState from "./components/EmptyState";
import dummyItems from "./items.json";


export default class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            favItems: [],
            checked: false 
        };
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange() {
      this.setState({
        checked: !this.state.checked
      })
    }

    handleItemClick = item => {
      const newItems = [...this.state.favItems];
      const newItem = {...item};

      const targetInd = newItems.findIndex(it => it.id === newItem.id);
      if (targetInd <0) newItems.push(newItem);
      this.setState({ favItems: newItems});
    };

    handleItemClickDelete = item => {
      const newItems = [...this.state.favItems];
      const newItem = {...item};

      const targetInd = newItems.findIndex(it => it.id === newItem.id);
      newItems.splice(targetInd, 1);
      this.setState({ favItems: newItems});
    };
    
  render() {
    const {favItems} = this.state;
    const content = <div> <EmptyState title="Belum Ada"/> </div>;
    if (favItems.length >0) {
      content = this.state.checked ? <div> <List
      title="My Favorite"
      items={favItems}
      onItemClick={ this.handleItemClickDelete}
      /></div> : null;
    }
    return(
      <div className="container-fluid">
        <h1 className="text-center">
          Welcome!
          <small>Class-based</small>
        </h1>
        <div>
        <label>Show Favorit</label>
        <input 
          type="checkbox" 
          checked={ this.state.checked } 
          onChange={ this.handleChange } />
      </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="Our Menu"
                items={dummyItems}
                onItemClick={this.handleItemClick}
              />
            </div>
            <div className="col-sm">
            {content}
            </div>
          </div>
        </div>
      </div>
    )
  }
}

// export default App;
