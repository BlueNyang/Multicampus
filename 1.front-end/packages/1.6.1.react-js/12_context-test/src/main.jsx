import { createRoot } from 'react-dom/client';
import './index.css';
import App from './MainApp';
import MyThemeProvider from './components/MyThemeProvider';
import HookThemeButton from './components/HookThemeButton';

createRoot(document.getElementById('root')).render(
  <MyThemeProvider>
    <HookThemeButton />
  </MyThemeProvider>,
);
