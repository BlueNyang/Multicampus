import { configureStore } from '@reduxjs/toolkit';
import counterReducer from './reducer/counter.js';

const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});

export default store;
