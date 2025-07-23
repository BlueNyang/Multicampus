import React from 'react';
import Left1 from './components/Left1';
import Right1 from './components/Right1';
import { useState } from 'react';

export default function App() {
  const [state, setState] = useState(0);

  const onAdd = () => setState((prev) => prev + 1);
  const onSub = () => setState((prev) => prev - 1);

  return (
    <div className='App'>
      <h3>Root</h3>
      <div className='container'>
        <Left1 count={state} />
        <Right1 onAdd={onAdd} onSub={onSub} />
      </div>
    </div>
  );
}
