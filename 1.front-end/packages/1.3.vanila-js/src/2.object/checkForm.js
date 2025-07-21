// 폼의 유효성 검사를 위한 설정
const FORM_SETTINGS = {
  // 비밀번호의 길이와 정규 표현식
  PASSWORD: {
    MIN_LENGTH: 10,
    MAX_LENGTH: 20,
    // 영문, 숫자, 특수문자를 하나 이상씩 포함하고, 길이가 10자 이상 20자 이하인 비밀번호 정규 표현식
    REGEX: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d!@#$%^&*]{10,20}$/,
  },
  // 생년월일의 길이 설정
  BIRTH_YEAR: {
    LENGTH: 4,
  },
  // 유효성 검사에서 제외할 필드
  SKIP: ["address2"],
  // 라디오 버튼 그룹 이름
  RADIO_GROUPS: ["solar", "sex", "emailRcv"],
};

// 각 필드의 이름을 한국어로 매핑
const FIELD_NAME_MAP = {
  name: "이름",
  id: "아이디",
  password: "비밀번호",
  passwordConfirm: "비밀번호 확인",
  birthYear: "생년",
  birthMonth: "생월",
  birthDay: "생일",
  solar: "양력/음력",
  tel1: "전화번호 앞자리",
  tel2: "전화번호 중간자리",
  tel3: "전화번호 뒷자리",
  hp1: "휴대폰 앞자리",
  hp2: "휴대폰 중간자리",
  hp3: "휴대폰 뒷자리",
  zipcode: "우편번호",
  address1: "주소",
  sex: "성별",
  job: "직업",
  email1: "이메일",
  email: "이메일 도메인",
  emailRcv: "이메일 수신 여부",
};

// 필드 이름을 한국어로 변환하는 함수
function nameToKorean(name) {
  return FIELD_NAME_MAP[name] || name;
}

// 유효성 검사 실패 시 에러 메시지를 표시하고 포커스를 맞추는 함수
function showError(message, element) {
  // alert로 에러 메시지를 표시
  alert(message);
  // 해당 요소에 포커스를 맞춤
  element?.focus();
  // 유효성 검사 실패 결과를 반환
  return { isValid: false, message, focusElement: element };
}

// 유효성 검사 성공 시 결과를 반환하는 함수
function showSuccess() {
  return { isValid: true };
}

// 비밀번호와 비밀번호 확인을 검사하는 함수
function validatePassword(pw, pwConfirm) {
  // 입력된 비밀번호와 비밀번호 확인 값을 가져옴
  const passwordValue = pw.value.trim();
  const passwordConfirmValue = pwConfirm.value.trim();

  // 비밀번호와 비밀번호 확인이 비어있는지 검사
  if (!passwordValue) {
    return showError("비밀번호를 입력하세요.", pw);
  }
  // 비밀번호 확인이 비어있는지 검사
  if (!passwordConfirmValue) {
    return showError("비밀번호 확인을 입력하세요.", pwConfirm);
  }
  // 비밀번호가 설정된 정규 표현식에 맞는지 검사
  if (!FORM_SETTINGS.PASSWORD.REGEX.test(passwordValue)) {
    const message = `비밀번호는 ${FORM_SETTINGS.PASSWORD.MIN_LENGTH}자 이상 ${FORM_SETTINGS.PASSWORD.MAX_LENGTH}자 이하로, 영문, 숫자, 특수문자를 포함해야 합니다.`;
    return showError(message, pw);
  }
  // 비밀번호와 비밀번호 확인이 일치하는지 검사
  if (passwordValue !== passwordConfirmValue) {
    return showError("비밀번호와 비밀번호 확인이 일치하지 않습니다.", pwConfirm);
  }
  // 모든 검사를 통과하면 성공 결과를 반환
  return showSuccess();
}

// 텍스트 입력 필드의 유효성을 검사하는 함수
function validateTextInputs() {
  // 모든 텍스트 입력 필드를 선택
  const inputElements = document.querySelectorAll("input[type='text']");
  // 각 입력 필드를 순회하며 유효성 검사
  for (const input of inputElements) {
    // 유효성 검사에서 제외할 필드 목록에 있는지 확인
    if (FORM_SETTINGS.SKIP.includes(input.name)) {
      continue;
    }
    // 입력 필드가 비어있는지 검사
    if (!input.value.trim()) {
      // 비어있다면 해당 필드의 이름을 한국어로 변환하고 에러 메시지를 표시
      const fieldName = nameToKorean(input.name);
      return showError(`${fieldName}을 입력하세요.`, input);
    }
  }
  // 모든 입력 필드가 유효하면 성공 결과를 반환
  return showSuccess();
}

// 생년월일 입력 필드의 유효성을 검사하는 함수
function validateBirthYear() {
  // 생년월일 입력 필드를 선택
  const birthYear = document.getElementById("birthYear");
  // 입력된 생년월일 값을 가져옴
  const birthYearValue = birthYear.value.trim();

  // 생년월일 값이 설정된 길이와 범위에 맞는지 검사
  // 생년월일은 4자리 숫자여야 하며, 현재 연도보다 작거나 같아야 함
  if (
    birthYearValue.length !== FORM_SETTINGS.BIRTH_YEAR.LENGTH ||
    isNaN(Number(birthYearValue)) ||
    Number(birthYearValue) < 0 ||
    Number(birthYearValue) > new Date().getFullYear()
  ) {
    // 유효하지 않다면 에러 메시지 표시
    return showError("생년월일을 올바르게 입력하세요.", birthYear);
  }
  // 유효하다면 성공
  return showSuccess();
}

// 드롭다운 선택 필드의 유효성을 검사하는 함수
function validateDropdowns() {
  // 모든 드롭다운 선택 필드를 선택
  const dropdowns = document.querySelectorAll("select");
  // 각 드롭다운을 순회하며 유효성 검사
  for (const dropdown of dropdowns) {
    // 드롭다운의 선택 값이 비어있는지 검사
    if (dropdown.value === "") {
      // 비어있다면 해당 드롭다운에 대해 에러 메시지를 표시
      const fieldName = nameToKorean(dropdown.name);
      // 드롭다운 요소에 포커스를 맞추고 에러 메시지 표시
      return showError(`${fieldName}을 선택하세요.`, dropdown);
    }
  }
  // 모든 드롭다운이 유효하면 성공 결과를 반환
  return showSuccess();
}

function validateRadioGroups() {
  // 라디오 버튼 그룹을 순회하며 유효성 검사
  for (const group of FORM_SETTINGS.RADIO_GROUPS) {
    // 해당 그룹의 모든 라디오 버튼을 선택
    const radios = document.querySelectorAll(`input[name='${group}']`);
    // 각 라디오 버튼의 선택 상태를 배열로 변환
    const isChecked = Array.from(radios).map((radio) => radio.checked);
    // 선택된 라디오 버튼이 없는 경우
    if (!isChecked) {
      const fieldName = nameToKorean(group);
      const firstRadio = document.querySelector(`input[name='${group}']`);
      // 에러 메시지를 표시
      return showError(`${fieldName}을 선택하세요.`, firstRadio);
    }
  }
  // 모든 라디오 그룹이 유효하면 성공 결과를 반환
  return showSuccess();
}

// 체크박스의 유효성을 검사하는 함수
function validateCheckboxes() {
  // 모든 체크박스를 선택
  const checkBoxes = document.querySelectorAll("input[type='checkbox']");
  // 각 체크박스를 순회하며 유효성 검사
  for (const checkbox of checkBoxes) {
    // 체크박스가 선택되지 않은 경우 에러
    if (!checkbox.checked) {
      return showError(`${checkbox.value}을 확인하세요.`, checkbox);
    }
  }
  // 모든 체크박스가 선택되었다면 성공 결과를 반환
  return showSuccess();
}

// 폼의 유효성을 검사하는 함수
function checkValidation() {
  // 유효성 검사 함수들을 배열로 정의
  const validations = [
    validateTextInputs,
    () => {
      const pw = document.getElementById("password");
      const pwConfirm = document.getElementById("passwordConfirm");
      return validatePassword(pw, pwConfirm);
    },
    validateBirthYear,
    validateDropdowns,
    validateRadioGroups,
    validateCheckboxes,
  ];

  // 각 유효성 검사 함수를 실행하고 결과를 확인
  for (const validate of validations) {
    const result = validate();
    if (!result.isValid) {
      return false; // 유효성 검사 실패
    }
  }
  return true; // 모든 유효성 검사 통과
}

// DOMContentLoaded 이벤트가 발생하면 폼 제출 이벤트를 설정
document.addEventListener("DOMContentLoaded", () => {
  // joinForm 요소를 선택
  const joinForm = document.getElementById("joinForm");
  if (joinForm) {
    // 폼 제출 이벤트 리스너를 추가
    joinForm.addEventListener("submit", (event) => {
      if (!checkValidation()) {
        // 유효성 검사 실패 시 폼 제출을 막음
        event.preventDefault();
      }
    });
  }
});

/* TypeScript 코드(Rollup으로 변환됨)
interface FieldNameMap {
  readonly [key: string]: string;
}

interface ValidationResult {
  isValid: boolean;
  message?: string;
  focusElement?: HTMLElement;
}

const FORM_SETTINGS = {
  PASSWORD: {
    MIN_LENGTH: 10,
    MAX_LENGTH: 20,
    REGEX: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d!@#$%^&*]{10,20}$/,
  },
  BIRTH_YEAR: {
    LENGTH: 4,
  },
  SKIP: ["address2"],
  RADIO_GROUPS: ["solar", "sex", "emailRcv"],
} as const;

const FIELD_NAME_MAP: FieldNameMap = {
  name: "이름",
  id: "아이디",
  password: "비밀번호",
  passwordConfirm: "비밀번호 확인",
  birthYear: "생년",
  birthMonth: "생월",
  birthDay: "생일",
  solar: "양력/음력",
  tel1: "전화번호 앞자리",
  tel2: "전화번호 중간자리",
  tel3: "전화번호 뒷자리",
  hp1: "휴대폰 앞자리",
  hp2: "휴대폰 중간자리",
  hp3: "휴대폰 뒷자리",
  zipcode: "우편번호",
  address1: "주소",
  sex: "성별",
  job: "직업",
  email1: "이메일",
  email: "이메일 도메인",
  emailRcv: "이메일 수신 여부",
} as const;

function nameToKorean(name: string): string {
  return FIELD_NAME_MAP[name] || name;
}

function showError(message: string, element?: HTMLElement): ValidationResult {
  alert(message);
  element?.focus();
  return { isValid: false, message, focusElement: element };
}

function showSuccess(): ValidationResult {
  return { isValid: true };
}

function validatePassword(pw: HTMLInputElement, pwConfirm: HTMLInputElement): ValidationResult {
  const passwordValue: string = pw.value.trim();
  const passwordConfirmValue: string = pwConfirm.value.trim();

  if (!passwordValue) {
    return showError("비밀번호를 입력하세요.", pw);
  }

  if (!passwordConfirmValue) {
    return showError("비밀번호 확인을 입력하세요.", pwConfirm);
  }

  if (!FORM_SETTINGS.PASSWORD.REGEX.test(passwordValue)) {
    const message: string = `비밀번호는 ${FORM_SETTINGS.PASSWORD.MIN_LENGTH}자 이상 ${FORM_SETTINGS.PASSWORD.MAX_LENGTH}자 이하로, 영문, 숫자, 특수문자를 포함해야 합니다.`;
    return showError(message, pw);
  }

  if (passwordValue !== passwordConfirmValue) {
    return showError("비밀번호와 비밀번호 확인이 일치하지 않습니다.", pwConfirm);
  }

  return showSuccess();
}

function validateTextInputs(): ValidationResult {
  const inputElements: NodeListOf<HTMLInputElement> =
    document.querySelectorAll<HTMLInputElement>("input[type='text']");

  for (const input of inputElements) {
    if (FORM_SETTINGS.SKIP.includes(input.name as "address2")) {
      continue;
    }

    if (!input.value.trim()) {
      const fieldName: string = nameToKorean(input.name);
      return showError(`${fieldName}을 입력하세요.`, input);
    }
  }

  return showSuccess();
}

function validateBirthYear(): ValidationResult {
  const birthYear = document.getElementById("birthYear") as HTMLInputElement;
  const birthYearValue: string = birthYear.value.trim();

  if (
    birthYearValue.length !== FORM_SETTINGS.BIRTH_YEAR.LENGTH ||
    isNaN(Number(birthYearValue)) ||
    Number(birthYearValue) < 0 ||
    Number(birthYearValue) > new Date().getFullYear()
  ) {
    return showError("생년월일을 올바르게 입력하세요.", birthYear);
  }
  return showSuccess();
}

function validateDropdowns(): ValidationResult {
  const dropdowns: NodeListOf<HTMLSelectElement> =
    document.querySelectorAll<HTMLSelectElement>("select");

  for (const dropdown of dropdowns) {
    if (dropdown.value === "") {
      const fieldName: string = nameToKorean(dropdown.name);
      return showError(`${fieldName}을 선택하세요.`, dropdown);
    }
  }

  return showSuccess();
}

function validateRadioGroups(): ValidationResult {
  for (const group of FORM_SETTINGS.RADIO_GROUPS) {
    const radios: NodeListOf<HTMLInputElement> = document.querySelectorAll<HTMLInputElement>(
      `input[name='${group}']`
    );

    const isChecked: Array<boolean> = Array.from(radios).map((radio) => radio.checked);

    if (!isChecked) {
      const fieldName: string = nameToKorean(group);
      const firstRadio = document.querySelector(`input[name='${group}']`) as HTMLInputElement;
      return showError(`${fieldName}을 선택하세요.`, firstRadio);
    }
  }

  return showSuccess();
}

function validateCheckboxes(): ValidationResult {
  const checkBoxes: NodeListOf<HTMLInputElement> =
    document.querySelectorAll<HTMLInputElement>("input[type='checkbox']");

  for (const checkbox of checkBoxes) {
    if (!checkbox.checked) {
      return showError(`${checkbox.value}을 확인하세요.`, checkbox);
    }
  }

  return showSuccess();
}

function checkValidation(): boolean {
  const validations: Array<() => ValidationResult> = [
    validateTextInputs,
    () => {
      const pw = document.getElementById("password") as HTMLInputElement;
      const pwConfirm = document.getElementById("passwordConfirm") as HTMLInputElement;
      return validatePassword(pw, pwConfirm);
    },
    validateBirthYear,
    validateDropdowns,
    validateRadioGroups,
    validateCheckboxes,
  ];

  for (const validate of validations) {
    const result: ValidationResult = validate();
    if (!result.isValid) {
      return false; // 유효성 검사 실패
    }
  }
  return true; // 모든 유효성 검사 통과
}

document.addEventListener("DOMContentLoaded", (): void => {
  const joinForm: HTMLElement | null = document.getElementById("joinForm");

  if (joinForm) {
    joinForm.addEventListener("submit", (event: Event): void => {
      if (!checkValidation()) {
        event.preventDefault();
      }
    });
  }
});
// */
