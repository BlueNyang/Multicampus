$(function () {
  const $unregisterBtn = $('#unregisterBtn');
  $unregisterBtn.on('click', function () {
    if (!confirm("정말로 탈퇴하시겠습니까? 탈퇴 시 모든 회원 정보가 삭제되며, 복구할 수 없습니다.")) {
      console.log("[unregister] Unregister cancelled by user.");
      return;
    }

    const memId = $('#memId').val().trim();
    const memPwd = $('#memPwd');
    const memPwdVal = memPwd.val()?.trim() || "";

    if (memPwdVal === "") {
      alert("회원 탈퇴를 위해 현재 비밀번호를 입력해주세요.");
      memPwd.focus();
      return;
    }

    const unregisterData = {
      memId: memId,
      memPwd: memPwdVal
    }

    console.log("[unregister] Request Unregister.");

    // AJAX 요청
    $.ajax(
      "/auth/unregister",
      {
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(unregisterData),
        success: function (resp) {
          if (resp === 'success') {
            alert("회원 탈퇴가 성공적으로 처리되었습니다. 그동안 이용해주셔서 감사합니다.");
            window.location.href = '/auth/logout';
          } else if (resp === 'no_such_member') {
            alert("존재하지 않는 회원입니다.");
            window.location.href = '/';
          } else if (resp === 'incorrect_password') {
            alert("비밀번호가 일치하지 않습니다. 탈퇴가 취소됩니다.");
          } else {
            alert("회원 탈퇴에 실패했습니다. 다시 시도해주세요.");
          }
        },
        error: function () {
          alert("회원 탈퇴 중 오류가 발생했습니다. 다시 시도해주세요.");
        }
      }
    );
  });

  const $editForm = $('#editForm');
  $editForm.on('submit', function (e) {
    e.preventDefault();

    // 현재 비밀번호 입력 확인
    const $memPwd = $('#memPwd');
    const currentPassword = $memPwd.val()?.trim() || "";
    if (currentPassword === "") {
      alert("현재 비밀번호를 입력해주세요.");
      $memPwd.focus();
      return;
    }

    // 이름 입력 확인
    const $memName = $('#memName');
    const name = $memName.val()?.trim() || "";
    if (name === "") {
      alert("이름을 입력해주세요.");
      $memName.focus();
      return;
    }

    const memHp = $("#memHp1").val()?.trim() + "-" + $("#memHp2").val()?.trim() + "-" + $("#memHp3").val()?.trim();

    // 폼 데이터 객체 생성
    const memData = {
      memId: $("#memId").val().trim(),
      memPwd: currentPassword,
      memName: name,
      memEmail: $("#memEmail").val()?.trim() || "",
      memHp: memHp,
      memZipCode: $("#memZipCode").val()?.trim() || "",
      memAddress1: $("#memAddress1").val()?.trim() || "",
      memAddress2: $("#memAddress2").val()?.trim() || ""
    }

    // AJAX 요청
    $.ajax({
             url: '/auth/edit',
             type: 'POST',
             contentType: 'application/json',
             data: JSON.stringify(memData),
             success: function (resp) {
               if (resp === 'success') {
                 alert("정보가 성공적으로 수정되었습니다.");
                 window.location.href = '/';
               } else if (resp === 'no_such_member') {
                 alert("존재하지 않는 회원입니다.");
                 window.location.href = '/';
               } else if (resp === 'incorrect_password') {
                 alert("현재 비밀번호가 일치하지 않습니다.");
                 $memPwd.focus();
               } else {
                 alert("정보 수정에 실패했습니다. 다시 시도해주세요.");
               }
             },
             error: function (xhr) {
               if (xhr.status === 400) {
                 alert(xhr.responseText || "Invalid request.");
               } else if (xhr.status === 401) {
                 alert("현재 비밀번호가 일치하지 않습니다.");
                 $memPwd.focus();
               } else {
                 alert("An error occurred while updating your information. Please try again later.");
               }
             }
           }); // end of ajax
  }); // end of submit

  $editForm.on('reset', (e) => {
    e.preventDefault();
    if (confirm("정말로 취소하시겠습니까? 입력한 내용이 모두 사라집니다.")) {
      window.location.href = '/';
    }
  }); // end of reset

  $("#changePwd").on('click', function () {
    window.location.href = '/auth/changePwdForm';
  })
});