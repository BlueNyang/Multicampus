import React, { useState } from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { amber, grey } from '@mui/material/colors';
import { CssBaseline } from '@mui/material';
import ThemeContext from './ThemeContext';

export default function MyThemeProvider({ children }) {
  const [mode, setMode] = useState('dark');

  // 컨텍스트에 전달할 값 구성
  const themeConfig = {
    mode,
    toggleMode: () => {
      setMode((prev) => {
        return prev === 'light' ? 'dark' : 'light';
      });
    },
  };

  // MUI 테마 생성
  const theme = createTheme({
    palette: {
      mode,
      ...(mode === 'light'
        ? {
            primary: amber,
          }
        : {
            primary: {
              main: grey[500],
              contrastText: '#fff',
            },
            background: {
              default: grey[900],
              paper: grey[900],
            },
          }),
    },
  });

  return (
    <ThemeContext.Provider value={themeConfig}>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        {children}
      </ThemeProvider>
    </ThemeContext.Provider>
  );
}
