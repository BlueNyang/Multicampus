import { createContext } from 'react';
import { HookContextChild } from './components/HookContextChild';

// 컨텍스트 초기화
export const MyAppContext = createContext();

// 컨텍스트에서 전달할 객체
const config = {
  title: 'React Project',
  lang: 'ko-KR',
};

export default function MainApp() {
  return (
    <MyAppContext.Provider value={config}>
      <div className='main-app'>
        <h1>Main Application</h1>
        <HookContextChild />
      </div>
    </MyAppContext.Provider>
  );
}
