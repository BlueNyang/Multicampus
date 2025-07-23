import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Content from './components/Content';
import Book from './components/Book';
import data from './data/BookList';

export default function App() {
  const books = data.map((book_sub) => ({
    id: book_sub.id,
    title: book_sub.title,
    author: book_sub.author,
    year: book_sub.year,
    categories: book_sub.categories,
  }));

  return (
    <div className='app'>
      <ul className='menu'>
        <li>
          <Link to='/'>Home</Link>
        </li>
        <li>
          <Link to='/about'>About</Link>
        </li>
        <li>
          <Link to='/contents'>Content</Link>
        </li>
      </ul>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/about' element={<About />} />
        <Route path='/contents' element={<Content data={books} />} />
        <Route path='/book/:bookId' element={<Book data={books} />} />
      </Routes>
    </div>
  );
}
