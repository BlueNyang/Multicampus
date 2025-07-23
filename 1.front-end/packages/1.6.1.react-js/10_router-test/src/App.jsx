import React from 'react';
import { Routes, Route, NavLink } from 'react-router-dom';
import Home from './components/Home';
import Topics from './components/Topics';
import Contact from './components/Contact';

export default function App() {
  return (
    <>
      <div className='app'>
        <h1>Hello React Router DOM</h1>
        <ul>
          <li>
            <NavLink to='/home'>Home</NavLink>
          </li>
          <li>
            <NavLink to='/topics'>Topics</NavLink>
          </li>
          <li>
            <NavLink to='/contact'>Contact</NavLink>
          </li>
        </ul>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/home' element={<Home />} />
          <Route path='/topics/*' element={<Topics />} />
          <Route path='/contact' element={<Contact />} />
          <Route path='/*' element={<h2>404 Not Found</h2>} />
        </Routes>
      </div>
    </>
  );
}
