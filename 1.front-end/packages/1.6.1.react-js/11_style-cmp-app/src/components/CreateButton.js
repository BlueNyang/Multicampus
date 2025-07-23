import styled from 'styled-components';

export const SimpleButton = styled.button`
  color: white;
  background-color: purple;
  border: none;
  border-radius: 5px;
  padding: 5px 10px;
  cursor: pointer;
  transition: background-color 0.3s;
  &:focus {
    outline: none;
  }
  &:hover {
    background-color: darkviolet;
  }
`;

// SimpleButton을 확장하여 LargeButton을 생성
export const LargeButton = styled(SimpleButton)`
  font-size: 50px;
`;
