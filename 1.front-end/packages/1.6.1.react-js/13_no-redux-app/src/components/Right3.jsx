import React from 'react';

export default function Right3({ onAdd, onSub }) {
  return (
    <div>
      <h3>Right 3</h3>
      <button onClick={onSub}>-</button>&nbsp;
      <button onClick={onAdd}>+</button>
    </div>
  );
}
