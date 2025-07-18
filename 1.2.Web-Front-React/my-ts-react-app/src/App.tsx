import type { JSX } from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import App01 from '@/projects/01_reactBasics/App.tsx';
import App02 from '@/projects/02_jsxApp/App';
import TestApp from '@/projects/test/App';

function Routers(): JSX.Element {
  const PageList = ['01_reactBasics', '02_jsxApp', 'test'];
  return (
    <div id='routerPage' className='flex flex-col items-center justify-center'>
      <h1>Welcome to the Router Page</h1>
      {PageList.map((page) => (
        <Link key={page} to={`/${page}`}>
          {page}
        </Link>
      ))}
    </div>
  );
}

export default function App(): JSX.Element {
  return (
    <Routes>
      <Route path='/' element={<Routers />} />
      <Route path='/01_reactBasics' element={<App01 />} />
      <Route path='/02_jsxApp' element={<App02 />} />
      <Route path='/test' element={<TestApp />} />
    </Routes>
  );
}
