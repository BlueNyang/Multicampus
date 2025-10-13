$(function () {
  const $loginForm = $('#loginForm');
  $loginForm.on(
    "submit",
    function (e) {
      e.preventDefault();

      $.ajax(
        {
          type: "POST",
          url: "/auth/login",
          data: {
            "memId": $("#id").val(),
            "memPwd": $("#pwd").val()
          },
          dataType: "text",
          success: function (resp) {
            console.log(resp);
            if (resp === "success") {
              alert("로그인에 성공했습니다.\n 메인 페이지로 이동합니다.");
              window.location.href = "/";
            } else {
              alert("아이디 또는 비밀번호가 일치하지 않습니다.");
            }
          },
          error: function (err) {
            console.error(err.responseText);
            alert("로그인 처리 중 오류가 발생했습니다. 잠시 후 다시 시도하세요.");
          }
        }
      );
    }
  );
});