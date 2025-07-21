import React from 'react';
import { Routes, Route, NavLink, useParams } from 'react-router-dom';
import Topic from './Topic';

export default function Topics() {
  const contents = [
    { id: 1, title: 'Politics', desc: 'Politics is ...' },
    { id: 2, title: 'Economy', desc: 'Economy is ...' },
    { id: 3, title: 'Society', desc: 'Society is ...' },
  ];

  const params = useParams();
  console.log('Current Params:', params);

  return (
    <div>
      <h2>Topics</h2>
      <ul>
        {contents.map((content) => (
          <li key={content.id}>
            <NavLink to={`/topics/${content.id}`}>{content.title}</NavLink>
          </li>
        ))}
      </ul>
      <Routes>
        <Route path={`/:topicId`} element={<Topic contents={contents} />} />
      </Routes>
    </div>
  );
}
