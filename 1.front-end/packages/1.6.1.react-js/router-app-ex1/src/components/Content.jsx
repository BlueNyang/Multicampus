import React from 'react';
import { Link } from 'react-router-dom';

export default function Content({ data }) {
  return (
    <div>
      <h2>Book List</h2>
      <table className='contentTable'>
        <thead>
          <tr>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Year</th>
            <th>Categories</th>
          </tr>
        </thead>
        <tbody>
          {data.map((book) => (
            <tr key={book.id}>
              <td>{book.id}</td>
              <td>
                <Link to={`/book/${book.id}`}>{book.title}</Link>
              </td>
              <td>{book.author}</td>
              <td>{book.year === '0' ? 'Unknown' : book.year}</td>
              <td>{book.categories}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
