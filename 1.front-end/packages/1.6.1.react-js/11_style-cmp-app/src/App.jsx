import ReactButton from './components/ReactButton';
import StyledButton from './components/StyledButton';
import { SimpleButton, LargeButton } from './components/CreateButton';
import { ReactLargeButton } from './components/ReactExpand';
import { PrimaryButton } from './components/DynamicStyle';

function App() {
  return (
    <div class='App'>
      <ReactButton>React Button</ReactButton>
      <StyledButton>Styled Button</StyledButton>
      <SimpleButton>Simple Button</SimpleButton>
      <LargeButton>Large Button</LargeButton>
      <ReactLargeButton>React Large Button</ReactLargeButton>
      <PrimaryButton primary={true}>Dynamic Style Button</PrimaryButton>
    </div>
  );
}

export default App;
