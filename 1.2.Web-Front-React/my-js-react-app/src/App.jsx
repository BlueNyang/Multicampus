import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import App01 from '@/projects/01_reactBasics/App';
import App02 from '@/projects/02_jsxApp/App';
import App03 from '@/projects/03_props/App';
import App04 from '@/projects/04_events/App';
import App05 from '@/projects/05_state/App';
import App06 from '@/projects/06_state2/App';
import App07 from '@/projects/07_CRUD/App';
import App08 from '@/projects/08_Input/App';
import App09 from '@/projects/09_eventInput/App';
import AppJsxEx from '@/projects/jsxEx/App';
import './style.css';

function Routers() {
  const PageList = [
    '01_reactBasics',
    '02_jsxApp',
    '03_props',
    '04_events',
    '05_state',
    '06_state2',
    '07_CRUD',
    '08_Input',
    '09_eventInput',
    'jsxEx',
  ];
  return (
    <div className='routerPage'>
      <h1>Welcome to the Router Page</h1>
      {PageList.map((page) => (
        <Link key={page} to={`/${page}`}>
          {page}
        </Link>
      ))}
    </div>
  );
}

export default function App() {
  return (
    <Routes>
      <Route path='/' element={<Routers />} />
      <Route path='/01_reactBasics' element={<App01 />} />
      <Route path='/02_jsxApp' element={<App02 />} />
      <Route path='/03_props' element={<App03 />} />
      <Route path='/04_events' element={<App04 />} />
      <Route path='/05_state' element={<App05 />} />
      <Route path='/06_state2' element={<App06 />} />
      <Route path='/07_CRUD' element={<App07 />} />
      <Route path='/08_Input' element={<App08 />} />
      <Route path='/09_eventInput' element={<App09 />} />
      <Route path='/jsxEx' element={<AppJsxEx />} />
    </Routes>
  );
}
