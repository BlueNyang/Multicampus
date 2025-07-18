import React, { useState } from 'react';
import styles from '../style.module.css';

export default function Counter() {
  const [count, setCount] = useState(0);

  // React의 State Update는 Asynchronous하게 동작하기 때문에, 상태 업데이트가 즉시 반영되지 않을 수 있음.
  // 따라서, 이전 상태를 기반으로 새로운 상태를 설정할 때는 콜백 함수를 사용하는 것이 안전함.
  // setCount((prev) => prev + 1) 형태로 사용하면, 이전 상태를 정확히 참조하여 업데이트할 수 있음.
  return (
    <div>
      <hr />
      <h3>{count}</h3>
      <div className={styles.colorBtns}>
        <button onClick={() => setCount((prev) => prev - 1)}>-</button>
        <button onClick={() => setCount((prev) => prev + 1)}>+</button>
      </div>
    </div>
  );
}
