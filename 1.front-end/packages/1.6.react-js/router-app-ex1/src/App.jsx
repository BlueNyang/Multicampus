import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import Content from './components/Content';
import Book from './components/Book';

export default function App() {
  const data = [
    {
      id: 1,
      title: '고도를 기다리며',
      author: '사뮈엘 베케트',
      year: 2012,
      publisher: '민음사',
      price: 9000,
      description:
        '고도를 기다리는 두 남자의 이야기로, 인간 존재의 의미와 삶의 부조리를 탐구하는 작품입니다.',
    },
    {
      id: 2,
      title: '설국',
      author: '가와바타 야스나리',
      year: 1954,
      publisher: '민음사',
      price: 8000,
      description:
        '일본의 설국을 배경으로 한 이 소설은 인간의 고독과 사랑, 그리고 삶의 덧없음을 그린 작품입니다.',
    },
    {
      id: 3,
      title: '변신',
      author: '프란츠 카프카',
      year: 2005,
      publisher: '문학동네',
      price: 9900,
      description:
        '주인공 그레고르 잠자가 어느 날 갑자기 거대한 벌레로 변해버리는 이야기로, 인간 존재의 소외와 고립을 다룬 작품입니다.',
    },
  ];

  return (
    <div className='app'>
      <ul className='menu'>
        <li>
          <Link to='/'>Home</Link>
        </li>
        <li>
          <Link to='/content'>Content</Link>
        </li>
      </ul>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/content' element={<Content data={data} />} />
        <Route path='/book/:bookId' element={<Book data={data} />} />
      </Routes>
    </div>
  );
}
