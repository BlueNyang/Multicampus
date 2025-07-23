import Student from './components/Student';
import imgBlack from './images/black.png';

function Header(props) {
  console.log('props', props.title);
  return (
    <header>
      <h1>
        <a href='/'>{props.title}</a>
      </h1>
      <h1>
        <a href='/'>props.title</a>
      </h1>
    </header>
  );
}

function Nav(props) {
  const lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li key={t.id}>
        <a href={'/read/' + t.id}>{t.title}</a>
      </li>,
    );
  }
  return (
    <nav>
      <ol>{lis}</ol>
    </nav>
  );
}

function Article() {
  return (
    <article>
      <h2>welcome</h2>
      HelloWeb
    </article>
  );
}

const App = () => {
  const title = 'React with Props';
  const content = 'This is an article demonstrating the use of props in React.';

  const topics = [
    { id: 1, title: 'html', body: 'html is...' },
    { id: 2, title: 'css', body: 'css is...' },
    { id: 3, title: 'javascript', body: 'javascript is...' },
  ];

  const studentInfo = {
    name: 'Gildong Hong',
    age: 20,
    year: 4,
    address: 'Seoul',
  };

  return (
    <div className='container'>
      <Header title={title} />
      <Nav topics={topics} />
      <Article content={content} />
      <Student studentInfo={studentInfo} />
      <p>
        <img src={imgBlack} alt='black' width='100px' height='100px' />
      </p>
      <p>
        <img src='/assets/apple.png' alt='apple' />
      </p>
    </div>
  );
};

export default App;
