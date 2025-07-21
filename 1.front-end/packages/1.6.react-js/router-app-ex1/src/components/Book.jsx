import React from 'react';
import { useParams } from 'react-router-dom';

export default function Book({ data }) {
  const { bookId } = useParams();
  console.log('Book component rendered with bookId:', bookId);
  const book = data.find((item) => item.id === parseInt(bookId));
  return (
    <div className='bookDetails'>
      <hr />
      {book ? (
        <>
          <h2>{book.title}</h2>
          <p>Author: {book.author}</p>
          <p>Year: {book.year}</p>
          <p>Publisher: {book.publisher}</p>
          <p>Price: {book.price.toLocaleString()}원</p>
          <p>Description: {book.description}</p>
        </>
      ) : (
        <p>Book not found</p>
      )}
      <a href='/'>Back to Home</a>
    </div>
  );
}
