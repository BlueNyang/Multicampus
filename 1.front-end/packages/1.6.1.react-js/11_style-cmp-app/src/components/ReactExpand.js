import styled from 'styled-components';
import ReactButton from './ReactButton';

export const ReactLargeButton = styled(ReactButton)`
  font-size: 50px;
  cursor: pointer;
  transition: background-color 0.3s;
  &:focus {
    outline: none;
  }
  &:hover {
    background-color: darkviolet;
  }
`;
