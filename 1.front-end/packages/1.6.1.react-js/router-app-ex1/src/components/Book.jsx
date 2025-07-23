import React from 'react';
import { useParams } from 'react-router-dom';

export default function Book({ data }) {
  const { bookId } = useParams();
  console.log('Book component rendered with bookId:', bookId);
  const book = data.find((item) => item.id === bookId);

  return (
    <div className='bookDetails'>
      <a href='/contents'>Back to Contents</a>
      <hr />
      {book ? (
        <>
          <h2>{book.title}</h2>
          <p>ID: {book.id}</p>
          <p>Author: {book.author}</p>
          <p>Categories:</p>
          <ul>
            {book.categories
              .split(/,(?=(?:[^']*'[^']*')*[^']*$)/)
              .map((cat) => {
                if (cat.startsWith("'") && cat.endsWith("'")) {
                  return cat.slice(1, -1).trim();
                }
                return cat.trim();
              })
              .map((cat, index) => {
                return <li key={index}>{cat}</li>;
              })}
          </ul>
          <p>Year: {book.year === '0' ? 'Unknown' : book.year}</p>
        </>
      ) : (
        <p>Book not found</p>
      )}
    </div>
  );
}
