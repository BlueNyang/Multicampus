import React, { useEffect, useState } from 'react';

function Header(props) {
  // 클릭 이벤트 핸들러를 통해 모드 변경
  return (
    <header>
      <h1>
        <a
          href='/05_state'
          onClick={(event) => {
            // 기본 동작 방지
            event.preventDefault();
            // props.onChangeMode를 호출하여 모드 변경
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}
function Nav(props) {
  // props.topics를 순회하여 각 topic에 대한 링크를 생성
  const lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    // 각 topic의 id와 title을 사용하여 링크를 생성
    let t = props.topics[i];

    // 각 링크에 onClick 이벤트 핸들러를 추가하여 모드 변경
    // event.target.id를 통해 클릭된 링크의 id를 가져와 props.onChangeMode를 호출
    lis.push(
      <li key={t.id}>
        <a
          id={t.id}
          href={'/read/' + t.id}
          onClick={(event) => {
            // 기본 동작 방지
            event.preventDefault();
            // props.onChangeMode를 호출하여 모드 변경
            // event.target.id를 통해 클릭된 링크의 id를 가져옴
            props.onChangeMode(event.target.id);
          }}
        >
          {t.title}
        </a>
      </li>,
    );
  }
  return (
    <nav>
      <ol>{lis}</ol>
    </nav>
  );
}
function Article(props) {
  // props.title과 props.body를 사용하여 아티클을 렌더링
  // props.title은 제목을 나타내고, props.body는 본문 내용을 나타냄
  // props.body는 JSX로 전달되어 렌더링
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}
export default function App() {
  // 초기값 설정
  const initialValue = { id: 0, title: 'Welcome', body: 'Hello, Web' };

  // Topics
  const topics = [
    { id: 1, title: 'html', body: 'html is ...' },
    { id: 2, title: 'css', body: 'css is ...' },
    { id: 3, title: 'javascript', body: 'javascript is ...' },
  ];

  // useState를 사용하여 상태를 관리하고, 초기값을 설정
  // context는 현재 선택된 topic을 나타내며, 초기값은 'Welcome'
  const [context, setContext] = useState(initialValue);

  return (
    <div className='app'>
      <Header
        title='WEB'
        onChangeMode={() => {
          // 초기값으로 설정
          setContext(initialValue);
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(id) => {
          // id가 숫자형으로 변환된 후, topics 배열에서 해당 id를 가진 topic을 찾음
          const topic = topics.find((t) => t.id === parseInt(id));

          // id가 일치하는 topic을 찾지 못했을 경우
          if (!topic) {
            // 콘솔에 경고 메시지를 출력하고 초기값으로 설정
            console.warn('Topic not found:', id);
            setContext(initialValue);
            return;
          }

          // id가 일치하는 topic을 찾았을 경우, context를 해당 topic으로 설정
          setContext(topic);
        }}
      ></Nav>
      <Article title={context.title} body={context.body}></Article>
    </div>
  );
}
