import React, { useState } from 'react';

export default function InputEvent() {
  const [title, setTitle] = useState('Now out school is');
  const [inputValue, setInputValue] = useState('');

  const handleChange = (e) => {
    setInputValue(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setTitle(inputValue);
    setInputValue(''); // Clear input after submission
  };

  return (
    <div>
      <hr />
      <h2>{title}</h2>
      <input
        type='text'
        value={inputValue}
        onChange={handleChange}
        onKeyDown={(e) => {
          if (e.key === 'Enter') {
            handleSubmit(e);
          }
        }}
      />
      <button onClick={handleSubmit}>Change</button>
    </div>
  );
}
