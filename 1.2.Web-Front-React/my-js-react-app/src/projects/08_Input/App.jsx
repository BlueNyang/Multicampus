import React, { useState } from 'react';
// import InputEvent from './component/InputEvent';
import styles from './style.module.css';
import Login from './component/Login';

export default function App() {
  return (
    <div class={styles.app}>
      <Login />
    </div>
  );
}
