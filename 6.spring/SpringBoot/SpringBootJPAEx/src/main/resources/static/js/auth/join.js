$(function () {
  // 아이디 중복 체크
  const $idCheck = $("#idCheck");
  const $userId = $("#memId");

  // 아이디 중복 체크 여부를 추적하는 변수
  let isIdChecked = false;

  // 아이디 입력 필드 내용이 변경되면, 중복 체크 상태를 초기화
  $userId.on("change", () => {
    isIdChecked = false;
  });

  // 아이디 중복 체크 버튼 클릭 이벤트 핸들러
  $idCheck.on("click", (event) => {
    event.preventDefault();

    console.log("[join] Check is id duplicated");

    // 입력된 아이디 값 가져오기
    const userId = $userId.val().trim();

    // 아이디가 비어있는지 확인
    if (userId === "") {
      alert("아이디를 입력하세요.");
      $userId.focus();
      return;
    }

    // AJAX 요청을 통해 아이디 중복 체크
    $.ajax(
      "/auth/idDupCheck",
      {
        type: "POST",
        url: "/auth/idDupCheck",
        data: {
          "userId": userId
        },
        dataType: "text",
        success: function (resp) {
          // 서버 응답 처리
          if (resp === "available") {
            isIdChecked = true;
            alert("사용 가능한 아이디입니다.");
          } else {
            isIdChecked = false;
            alert("이미 사용 중인 아이디입니다.");
            $userId.val("").focus();
          }
        },
        error: function () {
          alert("아이디 중복 체크 실패. 잠시 후 다시 시도하세요.");
        }
      }
    ); // ajax end
  }); // idCheck click end

  // 우편번호 찾기
  // https://postcode.map.daum.net/guide

  // 우편번호 찾기 버튼
  const $searchZipBtn = $("#searchZipBtn");

  // 우편번호 찾기 버튼 클릭 이벤트 핸들러
  $searchZipBtn.on("click", (e) => {
    e.preventDefault();
    // 다음 우편번호 서비스 호출
    new daum.Postcode(
      {
        oncomplete: (data) => {
          let addr = ''; // 주소 변수

          // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져옴
          // R: 도로명 주소, J: 지번 주소
          if (data.userSelectedType === 'R') {
            addr = data.roadAddress;
          } else {
            addr = data.jibunAddress;
          }

          // 우편번호와 주소 정보를 해당 필드에 입력
          $("#memZipCode").val(data.zonecode);
          $("#memAddress1").val(addr);

          // 상세 주소 필드에 포커스 설정
          $("#memAddress2").val("").focus();
        }
      }
    ).open();
  }); // searchZipBtn click end

  // 회원가입 폼
  const $joinForm = $('#joinForm');

  // 회원가입 폼 제출 이벤트 핸들러
  $joinForm.on("submit", function (e) {
    // 기본 폼 제출 동작 방지
    e.preventDefault();

    // 아이디 중복 체크 여부 확인
    if (!isIdChecked) {
      alert("아이디 중복 체크를 해주세요.");
      $userId.focus();
      return;
    }

    // 비밀번호와 비밀번호 확인 일치 여부 확인
    // 비밀번호와 비밀번호 확인 필드
    const $pwd = $("#memPwd");
    const $pwdConfirm = $("#memPwdConfirm");

    // 입력된 비밀번호 값 가져오기
    const pwd = $pwd.val()?.trim() || "";
    const pwdConfirm = $pwdConfirm.val()?.trim() || "";

    // 비밀번호가 일치하는지 확인
    if (pwd !== pwdConfirm) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
      $pwd.val("").focus();
      $pwdConfirm.val("");
      return;
    }

    // 이름 입력 여부 확인
    const $memName = $("#memName");
    const name = $memName.val()?.trim() || "";
    if (name === "") {
      alert("이름을 입력하세요.");
      $memName.focus();
      return;
    }

    // 모든 검증이 통과되었으므로, 폼 데이터를 서버로 전송
    console.log("[join] Submit join form");

    // 폼 데이터 객체 생성
    const joinData = {
      memId: $userId.val().trim(),
      memPwd: pwd,
      memName: name,
      memEmail: $("#memEmail").val()?.trim() || "",
      memHp1: $("#memHp1").val()?.trim() || "",
      memHp2: $("#memHp2").val()?.trim() || "",
      memHp3: $("#memHp3").val()?.trim() || "",
      memZipCode: $("#memZipCode").val()?.trim() || "",
      memAddress1: $("#memAddress1").val()?.trim() || "",
      memAddress2: $("#memAddress2").val()?.trim() || ""
    }

    // AJAX 요청을 통해 회원가입 처리
    $.ajax(
      "/auth/join",
      {
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(joinData),
        dataType: "text",
        success: (resp) => {
          // 서버 응답 처리
          if (resp === "success") {
            alert("회원가입에 성공했습니다.\n로그인 페이지로 이동합니다.");
            window.location.href = "/auth/loginForm";
          } else {
            alert("회원가입에 실패했습니다. 잠시 후 다시 시도하세요.");
          }
        },
        error: () => {
          alert("회원가입 처리 중 오류가 발생했습니다. 잠시 후 다시 시도하세요.");
        }
      }
    ); // ajax end
  }); // joinForm submit end

  // 회원가입 폼 리셋(취소) 이벤트 핸들러
  $joinForm.on("reset", (e) => {
    e.preventDefault();
    if (confirm("회원가입을 취소하고 로그인 페이지로 이동하시겠습니까?")) {
      window.location.href = "/auth/loginForm";
    }
  }); // joinForm reset end
}); // jQuery end