import styled from 'styled-components';

export const PrimaryButton = styled.button`
  color: ${function ({ primary }) {
    return primary ? 'white' : 'gray';
  }};
`;
