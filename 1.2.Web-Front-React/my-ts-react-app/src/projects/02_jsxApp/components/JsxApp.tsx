import type { JSX } from 'react';

export default function JsxApp(): JSX.Element {
  const name: string = 'React';
  return (
    <div>
      <h1>JSX입니다</h1>
      <h2>name 안녕!</h2>
      <h3>{name} 안녕!</h3>
    </div>
  );
}
