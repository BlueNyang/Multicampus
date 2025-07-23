import React from 'react';
import { useSelector } from 'react-redux';

export default function Left3() {
  const count = useSelector((state) => state.counter.count);

  return (
    <div>
      <h3>Left 3</h3>
      <p>Count: {count}</p>
    </div>
  );
}
