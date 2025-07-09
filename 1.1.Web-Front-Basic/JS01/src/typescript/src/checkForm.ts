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
