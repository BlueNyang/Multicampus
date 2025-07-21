import React from 'react';
import { useParams } from 'react-router-dom';

export default function Topic({ contents }) {
  const params = useParams();
  console.log('Current Params:', params);

  if (!contents) {
    return <h3>Topics not found</h3>;
  }

  const content = contents.find((c) => c.id === parseInt(params.topicId));
  if (!content) {
    return <h3>Topic not found</h3>;
  }

  if (params.topicId && parseInt(params.topicId) !== content.id) {
    return <h3>Topic ID does not match</h3>;
  }
  if (params.topicId && parseInt(params.topicId) === content.id) {
    console.log('Matched Topic ID:', params.topicId);
  }
  return (
    <div>
      <h3>{content.title}</h3>
      <p>{content.desc}</p>
    </div>
  );
}
