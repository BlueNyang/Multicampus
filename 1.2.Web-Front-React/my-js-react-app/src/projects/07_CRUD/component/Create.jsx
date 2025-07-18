import React from 'react';

export default function Create({ onCreate }) {
  return (
    <article>
      <h2>Create</h2>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          const title = e.target.title.value;
          const body = e.target.body.value;
          onCreate(title, body);
        }}
      >
        <p>
          <input type='text' name='title' placeholder='Title' />
        </p>
        <p>
          <textarea name='body' placeholder='Body'></textarea>
        </p>
        <p>
          <input type='submit' value='Create' />
        </p>
      </form>
    </article>
  );
}
