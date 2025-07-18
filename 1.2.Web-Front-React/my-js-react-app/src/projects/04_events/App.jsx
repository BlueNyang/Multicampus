import React from 'react';
import style from './style.module.css';

function Header(props) {
  console.log('props', props.title);
  return (
    <header>
      <h1>
        <a
          href='/04_events'
          onClick={(e) => {
            e.preventDefault();
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
  const lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li key={t.id}>
        <a
          href={'/04_events/read/' + t.id}
          onClick={(e) => {
            e.preventDefault();
            props.onChangeMode(t.id);
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
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

export default function App() {
  const topics = [
    { id: 1, title: 'html', body: 'html is ...' },
    { id: 2, title: 'css', body: 'css is ...' },
    { id: 3, title: 'javascript', body: 'javascript is ...' },
  ];
  return (
    <div className={style.app}>
      <Header
        title='WEB'
        onChangeMode={() => {
          alert('Header onChangeMode');
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(id) => {
          const topic = topics.find((t) => t.id === id);
          if (topic) {
            alert(`Selected topic: ${topic.title}`);
          } else {
            alert('Topic not found');
          }
        }}
      ></Nav>
      <Article title='Welcome' body='Hello, Web'></Article>
    </div>
  );
}
