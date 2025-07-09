function inputEmail() {
    const email = prompt("이메일을 입력하세요:");
    if (email === null || email.trim() === "") {
        alert("아무것도 입력하지 않았습니다.");
        return "잘못된 입력 값";
    }
    const regax = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!regax.test(email)) {
        alert("잘못된 이메일 형식입니다.");
        return "잘못된 입력 값";
    }
    return `입력한 이메일: ${email}`;
}
function main() {
    const p = document.createElement("p");
    p.textContent = inputEmail();
    document.body.appendChild(p);
}
main();
