$(function () {
  // 새 비밀번호와 비밀번호 확인이 일치하는지 간단히 확인하는 스크립트
  const $newPwdInput = $('#newPwd');
  const $newPwdConfirmInput = $('#newPwdConfirm');
  const $pwdMatchMsg = $('#pwdMatchMsg');
  const $changePwdForm = $('#changePwdForm');

  function checkPasswordMatch() {
    const newPwd = $newPwdInput.val();
    const confirmPwd = $newPwdConfirmInput.val();

    if (newPwd && confirmPwd) { // 두 필드 모두 값이 있을 때만 비교
      if (newPwd === confirmPwd) {
        $pwdMatchMsg.text('비밀번호가 일치합니다.');
        $pwdMatchMsg.addClass("text-success").removeClass("text-danger");
      } else {
        $pwdMatchMsg.text('비밀번호가 일치하지 않습니다.');
        $pwdMatchMsg.addClass('text-danger')
                    .removeClass('text-success');
      }
    } else {
      $pwdMatchMsg.val(''); // 둘 중 하나라도 비어있으면 메시지 제거
      $pwdMatchMsg.removeClass('text-success text-danger');
    }
  }

  $newPwdInput.on('keyup', checkPasswordMatch);
  $newPwdConfirmInput.on('keyup', checkPasswordMatch);

  // 폼 제출 시 비밀번호 일치 여부 최종 확인
  $changePwdForm.on('submit', function (e) {
    e.preventDefault();
    if ($newPwdInput.val() !== $newPwdConfirmInput.val()) {
      alert('새 비밀번호와 비밀번호 확인이 일치하지 않습니다.');
    }

    // 일치할 경우 폼 제출
    $.ajax(
      "/auth/changePwd",
      {
        type: "POST",
        data: {
          memId: $("#memId").val(),
          currentPwd: $("#currentPwd").val(),
          newPwd: $newPwdInput.val()
        },
        dataType: "text",
        success: function (resp) {
          console.log(resp);
          if (resp === "success") {
            alert("비밀번호가 성공적으로 변경되었습니다. 다시 로그인 해주세요.");
            window.location.href = "/auth/loginForm";
          } else {
            alert("비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
          }
        }
      }
    )
  });
})