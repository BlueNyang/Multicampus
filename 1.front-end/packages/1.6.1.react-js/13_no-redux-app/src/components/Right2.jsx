import React from 'react';
import Right3 from './Right3';

export default function Right2({ onAdd, onSub }) {
  return (
    <div>
      <h3>Right 2</h3>
      <Right3 onAdd={onAdd} onSub={onSub} />
    </div>
  );
}
