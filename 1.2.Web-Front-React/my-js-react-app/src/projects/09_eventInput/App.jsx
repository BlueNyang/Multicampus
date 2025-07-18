import React from 'react';
import Contents from './components/Contents.jsx';
import style from './style.module.css';

export default function App() {
  return (
    <div className={style.app}>
      <Contents />
    </div>
  );
}
