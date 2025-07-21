import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import MovieInfo from './components/MovieInfo';
import MovieDetail from './components/MovieDetail';

export default function App() {
  const data = {
    spider: {
      title: '스파이더맨 노 웨이 홈',
      director: '존 왓츠',
      actor: '톰 홀랜드',
      date: '2021-12-15',
      genre: '액션',
    },
    king: {
      title: '킹스맨 : 퍼스트 에이전트',
      director: '메튜 본',
      actor: '랄프 파인즈',
      date: '2021-12-22',
      genre: '액션',
    },
  };
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
          <Link to='/moveInfo'>Movie Info</Link>
        </li>
        <li>
          <a href='https://movie.naver.com/' target='_blank' rel='noopener noreferrer'>
            Naver Movie
          </a>
        </li>
      </ul>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/about' element={<About />} />
        <Route path='/moveInfo' element={<MovieInfo data={data} />} />
        <Route path='/movieDetail/:keyword' element={<MovieDetail data={data} />} />
      </Routes>
    </div>
  );
}
