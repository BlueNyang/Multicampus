//function showInfo(name: string, year: number = 4, score: number): string {
//  return `Name: ${name}, Year: ${year}, Score: ${score}`;
//}
//console.log(showInfo()); // name은 값이 없고, year은 디폴트 매개변수 사용, score는 값이 없음(undefined)
//console.log(showInfo("홍길동")); // name은 전달된 값, year은 디폴트 매개변수 사용, score 값 없음
//console.log(showInfo("홍길동", 80));
function showInfo(name, score, year = 4) {
    // 매개변수 name, year, score
    // name : 이름 (값을 전달하지 않으면 undefined)
    // year : 학년 (값을 전달하지 않으면 4학년으로 디폴트 매개변수 사용)
    // score : 점수 (값을 전달하지 않으면 undefined)
    return `name: ${name}, year: ${year}, score: ${score}`;
}
//console.log(showInfo()); // name은 값이 없고, year은 디폴트 매개변수 사용, score는 값이 없음(undefined)
//console.log(showInfo("홍길동")); // name은 전달된 값, year은 디폴트 매개변수 사용, score 값 없음
console.log(showInfo("홍길동", 80)); // year은 디폴트 매개변수 값 사용
console.log(showInfo("홍길동", 80, 1)); // year도 전달된 값 사용
