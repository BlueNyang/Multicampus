import React from 'react';
import { useDispatch } from 'react-redux';
import { increment, decrement } from '../store/reducer/counter.js';

export default function Right3() {
  const dispatch = useDispatch();

  return (
    <div>
      <h3>Right 3</h3>
      <button onClick={() => dispatch(decrement())}>-</button>&nbsp;
      <button onClick={() => dispatch(increment())}>+</button>
    </div>
  );
}
