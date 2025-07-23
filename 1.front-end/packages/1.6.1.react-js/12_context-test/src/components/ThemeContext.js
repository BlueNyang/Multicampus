import { createContext } from 'react';

// 컨텍스트 초기화
export default createContext({
  mode: 'dark',
  toggleMode: () => {},
});
