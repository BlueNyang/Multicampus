import React from 'react';

const Nav2 = ({ topics }) => {
  return (
    <div>
      <h2>Topics</h2>
      <ul>
        {topics.map((topic) => (
          <li key={topic.id}>
            <a href={`#${topic.title}`}>{topic.title}</a>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Nav2;
