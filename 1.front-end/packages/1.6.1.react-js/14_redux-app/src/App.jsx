import React from 'react';
import Left1 from './components/Left1';
import Right1 from './components/Right1';

export default function App() {
  return (
    <div className='App'>
      <h3>Root</h3>
      <div className='container'>
        <Left1 />
        <Right1 />
      </div>
    </div>
  );
}
