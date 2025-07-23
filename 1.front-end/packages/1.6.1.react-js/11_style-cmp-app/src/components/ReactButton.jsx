import React from 'react';

export default function ReactButton({ children, className }) {
  const style = {
    color: 'white',
    backgroundColor: 'purple',
    border: 'none',
    borderRadius: '5px',
    padding: '10px 20px',
  };
  return (
    <div>
      <button style={style} className={className}>
        {children}
      </button>
    </div>
  );
}
