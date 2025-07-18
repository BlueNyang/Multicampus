import type { JSX } from 'react';
import Header from '@/projects/01_reactBasics/components/Header.tsx';
import Nav from '@/projects/01_reactBasics/components/Nav.tsx';
import Content from '@/projects/01_reactBasics/components/Content.tsx';
import Footer from '@/projects/01_reactBasics/components/Footer.tsx';
import './style.css';

export default function App01(): JSX.Element {
  return (
    <div>
      <Header />
      <Nav />
      <Content />
      <Footer />
    </div>
  );
}
