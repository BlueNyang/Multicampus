import React, { useState } from 'react';

export default function Update({ title, body, onUpdate }) {
  const [formTitle, setFormTitle] = useState(title);
  const [formBody, setFormBody] = useState(body);
  return (
    <article>
      <h2>Update</h2>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          onUpdate(formTitle, formBody);
        }}
      >
        <p>
          <input
            type='text'
            name='title'
            placeholder='Title'
            value={formTitle}
            onChange={(e) => setFormTitle(e.target.value)}
          />
        </p>
        <p>
          <textarea
            name='body'
            placeholder='Body'
            value={formBody}
            onChange={(e) => setFormBody(e.target.value)}
          ></textarea>
        </p>
        <p>
          <input type='submit' value='Update' />
        </p>
      </form>
    </article>
  );
}
