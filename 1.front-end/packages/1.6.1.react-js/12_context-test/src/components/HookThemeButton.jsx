import { useContext } from 'react';
import { Button } from '@mui/material';
import ThemeContext from './ThemeContext';

export default function HookThemeButton() {
  const { mode, toggleMode } = useContext(ThemeContext);

  return (
    <>
      <Button onClick={toggleMode}>Switch to {mode === 'light' ? 'dark' : 'light'} mode</Button>
    </>
  );
}
