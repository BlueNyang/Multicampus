import React, { useState } from 'react';
import Create from './components/Create';
import Update from './components/Update';

function Header(props) {
  return (
    <header>
      <h1>
        <a
          href='/'
          onClick={(event) => {
            event.preventDefault();
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
          id={t.id}
          href={'/read/' + t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(Number(event.target.id));
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
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  const [topics, setTopics] = useState([
    { id: 1, title: 'html', body: 'html is ...' },
    { id: 2, title: 'css', body: 'css is ...' },
    { id: 3, title: 'javascript', body: 'javascript is ...' },
  ]);

  let content = null;
  let contextControl = null;

  if (mode === 'WELCOME') {
    content = <Article title='Welcome' body='Hello, Web'></Article>;
  } else if (mode === 'READ') {
    let title,
      body = null;
    for (let i = 0; i < topics.length; i++) {
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
    contextControl = (
      <>
        <li>
          <a
            href={`update/${id}`}
            onClick={(e) => {
              e.preventDefault();
              setMode('UPDATE');
            }}
          >
            Update
          </a>
        </li>
        <li>
          <a
            href={`delete/${id}`}
            onClick={(e) => {
              e.preventDefault();
              const updatedTopics = topics.filter((topic) => topic.id !== id);
              setTopics(updatedTopics);
              setMode('WELCOME');
              setId(null);
            }}
          >
            Delete
          </a>
        </li>
      </>
    );
  } else if (mode === 'CREATE') {
    content = (
      <Create
        onCreate={(title, body) => {
          const newTopic = {
            id: topics.length + 1,
            title: title,
            body: body,
          };
          setTopics([...topics, newTopic]);
          setMode('READ');
          setId(newTopic.id);
        }}
      />
    );
  } else if (mode === 'UPDATE') {
    content = (
      <Update
        title={topics.find((topic) => topic.id === id)?.title || ''}
        body={topics.find((topic) => topic.id === id)?.body || ''}
        onUpdate={(title, body) => {
          const updatedTopics = topics.map((topic) => {
            if (topic.id === id) {
              return { ...topic, title, body };
            }
            return topic;
          });
          setTopics(updatedTopics);
          setMode('READ');
        }}
      />
    );
  }

  return (
    <div className='app'>
      <Header
        title='WEB'
        onChangeMode={() => {
          setMode('WELCOME');
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode('READ');
          setId(_id);
        }}
      ></Nav>
      {content}
      <div className='actions'>
        <ul>
          <li>
            {' '}
            <a
              href='/create'
              onClick={(e) => {
                e.preventDefault();
                setMode('CREATE');
              }}
            >
              Create
            </a>{' '}
          </li>
          {contextControl}
        </ul>
      </div>
    </div>
  );
}
