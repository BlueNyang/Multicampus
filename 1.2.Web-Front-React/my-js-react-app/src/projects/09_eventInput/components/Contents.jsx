import React, { useState, useRef } from 'react';
import style from '../style.module.css';

export default function Contents() {
  const [contents, setContents] = useState(['지금 우리 학교는', '오징어 게임']);
  const [inputValue, setInputValue] = useState('');

  const inputRef = useRef(null);

  const onItemAdd = () => {
    if (checkValid(inputValue)) {
      // 빈 문자열 방지

      setContents((prev) => [...prev, inputValue]);
      setInputValue(''); // 입력 필드 초기화
    }
    if (inputRef.current) {
      inputRef.current.focus(); // 입력 필드에 포커스
    }
  };

  const onInputChange = (e) => {
    setInputValue(e.target.value);
  };

  const checkValid = (input) => {
    if (input.trim() === '') {
      alert('입력값이 비어있습니다.');
      return false;
    }
    if (contents.includes(input)) {
      alert('이미 존재하는 콘텐츠입니다.');
      return false;
    }
    return true;
  };

  const ItemRemove = (index) => {
    setContents((prev) => prev.filter((_, i) => i !== index));
    alert(`콘텐츠 ${index}가 삭제되었습니다.`);
    if (inputRef.current) {
      inputRef.current.focus(); // 입력 필드에 포커스
    }
  };

  return (
    <div>
      <div className={style.header}>
        <h3>인기컨텐츠</h3>
      </div>
      <div className={style.contents}>
        {contents.map((content, index) => (
          <div key={index}>
            <p>
              {index}: {content} &nbsp;&nbsp;
              <button onClick={() => ItemRemove(index)}>삭제</button>
            </p>
            <hr />
          </div>
        ))}
        <input
          type='text'
          placeholder='새로운 콘텐츠를 입력하세요'
          value={inputValue}
          onChange={onInputChange}
          ref={inputRef}
        />
        <button onClick={onItemAdd}>항목추가</button>
      </div>
    </div>
  );
}
