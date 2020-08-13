import React from 'react';
import logo from './logo.svg';
import './App.css';
import Clock from './Clock';
import Calculator from './Calculator';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          <Clock />
        </p>
        <Calculator />
      </header>
    </div>
  );
}

export default App;
