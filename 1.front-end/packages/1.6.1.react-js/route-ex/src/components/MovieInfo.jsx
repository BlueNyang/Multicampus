import React from 'react';
import { Link } from 'react-router-dom';

export default function MovieInfo({ data }) {
  return (
    <div>
      <hr />
      <h2>Movie Information</h2>
      <table>
        <thead>
          <tr>
            <th>Title</th>
            <th>Director</th>
            <th>Actor</th>
            <th>Release Year</th>
            <th>Genre</th>
          </tr>
        </thead>
        <tbody>
          {Object.entries(data).map(([key, movie]) => (
            <tr key={key}>
              <td>
                <Link to={`/movieDetail/${key}`}>{movie.title}</Link>
              </td>
              <td>{movie.director}</td>
              <td>{movie.actor}</td>
              <td>{movie.date}</td>
              <td>{movie.genre}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
