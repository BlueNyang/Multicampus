import React, { useState } from 'react';

export default function Message() {
  const [message, setMessage] = useState('message');
  const [color, setColor] = useState('black');

  const onClickEnterHandler = () => {
    setMessage('Hello!');
  };

  const onClickExiteHandler = () => {
    setMessage('Goodbye!');
  };
  const onClickResetHandler = () => {
    setMessage('message');
  };

  return (
    <div>
      <h3>{message}</h3>
      <p />
      <div className='colorBtns'>
        <button onClick={onClickEnterHandler}>Enter</button>
        <button onClick={onClickExiteHandler}>Exit</button>
        <button onClick={onClickResetHandler}>Reset</button>
      </div>
      <hr />
      <h3 style={{ color }}>{color}</h3>
      <div className='colorBtns'>
        <button onClick={() => setColor('red')}>Red</button>
        <button onClick={() => setColor('blue')}>Blue</button>
        <button onClick={() => setColor('green')}>Green</button>
        <button onClick={() => setColor('black')}>Black</button>
      </div>
    </div>
  );
}
