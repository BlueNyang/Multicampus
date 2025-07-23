import React from 'react';
import Left2 from './Left2';

export default function Left1({ count }) {
  return (
    <div>
      <h3>Left 1</h3>
      <Left2 count={count} />
    </div>
  );
}
