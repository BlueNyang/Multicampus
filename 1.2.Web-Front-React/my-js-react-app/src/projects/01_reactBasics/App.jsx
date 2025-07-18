import React from 'react';
import Content from './components/Content';

function Header() {
  return <h1>React</h1>;
}

function Nav() {
  return <h2>Navigation</h2>;
}

function Article() {
  return <p>This is an article.</p>;
}

function Footer() {
  return <footer>Footer content</footer>;
}

const App = () => {
  return (
    <div>
      <Header />
      <Nav />
      <Article />
      <Content />
      <Footer />
    </div>
  );
};

export default App;
