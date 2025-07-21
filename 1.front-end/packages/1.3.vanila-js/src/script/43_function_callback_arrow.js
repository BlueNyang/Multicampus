// 화살표 함수 선언 형식
// 화살표 함수는 function 키워드를 사용하지 않고, 매개변수와 함수 본문을 화살표(=>)로 연결하여 정의
// 문법
// (매개변수) => { 함수 본문 }
// x => { 함수 본문 } // 매개변수가 하나일 때는 괄호를 생략할 수 있음
// (x, y) => { return x + y; } // 매개변수가 여러 개일 때는 괄호를 사용
// x => x * x // 매개변수가 하나일 때는 중괄호 없이 표현식만 작성 가능
// () => { console.log("Hello, World!"); } // 매개변수가 없을 때는 빈 괄호 사용
const sayHi = () => alert("안녕하세요!");
const sayHi2 = function () {
    alert("안녕하세요!");
};
sayHi();
sayHi2();
let number = [1, 2, 3, 4, 5];
number.forEach((x) => {
    console.log(x * x);
});
