import styled from 'styled-components';

const StyledButton = styled.button`
  color: white;
  background-color: purple;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
  &:focus {
    outline: none;
  }
  &:hover {
    background-color: darkviolet;
  }
`;

export default StyledButton;
