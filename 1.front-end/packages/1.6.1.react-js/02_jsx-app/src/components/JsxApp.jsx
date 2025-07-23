export default function JsxApp() {
  const number = 0;
  const num = 2;
  const name = 'React';

  const person = {
    name: 'ReactJS',
    age: 12,
  };

  function getPerson() {
    return `${person.name}, ${person.age}`;
  }

  return (
    <div>
      <h1>JSX입니다</h1>
      <h2>name 안녕!</h2>
      <h3>{name} 안녕!</h3>
      {name === 'React' ? <h3>React 입니다.</h3> : <h3>React가 아닙니다.</h3>}
      {name === 'Vue' && <h3>Vue 입니다.</h3>}
      {number || '오리'}
      {number && '오리'}

      <div
        style={{
          margin: '0 auto',
          width: '50%',
          backgroundColor: 'red',
          color: 'white',
          fontSize: '36px',
          fontweight: 'bold',
          padding: 10,
          marginTop: '20px',
        }}
      ></div>
      <div className='rect'>className 속성 사용</div>
      {(() => {
        if (num === 1) return <div>value=1</div>;
        if (num === 2) return <div>value=2</div>;
        if (num === 3) return <div>value=3</div>;
      })()}

      <div>getPerson()</div>
      <div>{getPerson()}</div>
    </div>
  );
}
