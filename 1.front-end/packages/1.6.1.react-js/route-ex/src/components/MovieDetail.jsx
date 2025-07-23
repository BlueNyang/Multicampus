import React from 'react';
import { useParams } from 'react-router-dom';

export default function MovieDetail({ data }) {
  const { keyword } = useParams();
  const movie = data[keyword];

  return (
    <div>
      {movie ? (
        <>
          <hr />
          <h3>
            {keyword} : {movie.title}
          </h3>
          <p>Director: {movie.director}</p>
          <p>Actor: {movie.actor}</p>
          <p>Date: {movie.date}</p>
          <p>Genre: {movie.genre}</p>
        </>
      ) : (
        <h2>Movie not found</h2>
      )}
    </div>
  );
}
