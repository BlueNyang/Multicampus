$(document).ready(function () {
  $(":text, :password").focus(function () {
    $(this).css({
      backgroundColor: "#f2f2f2",
    });
  });

  $(":text, :password").blur(function () {
    $(this).css({
      backgroundColor: "#fff",
    });
  });

  $("#hp1").keyup(function () {
    if ($(this).val().length === 3) {
      $("#hp2").focus();
    }
  });

  $("#hp2").keyup(function () {
    if ($(this).val().length === 4) {
      $("#hp3").focus();
    }
  });

  $("#hp3").keyup(function () {
    if ($(this).val().length === 4) {
      $("#department").focus();
    }
  });

  $("#newMemberForm").submit(function (e) {
    if ($("#id").val() === "") {
      alert("아이디를 입력하세요.");
      $("#id").focus();
      e.preventDefault();
    } else if ($("#pwd").val() === "") {
      alert("비밀번호를 입력하세요.");
      $("#name").focus();
      e.preventDefault();
    } else if ($("#hp1").val() === "" || $("#hp2").val() === "" || $("#hp3").val() === "") {
      alert("휴대폰 번호를 입력하세요.");
      $("#hp1").focus();
      e.preventDefault();
    } else if (!$(":radio").is(":checked")) {
      alert("학년을 선택하세요.");
      e.preventDefault();
    } else if (!$(":checkbox").is(":checked")) {
      alert("관심분야를 입력하세요.");
      e.preventDefault();
    } else if ($("#passwordConfirm").val() !== $("#password").val()) {
      alert("비밀번호가 일치하지 않습니다.");
      $("#passwordConfirm").focus();
      e.preventDefault();
    } else if ($("#department").val() === "") {
      alert("학과를 선택하세요.");
      $("#department").focus();
      e.preventDefault();
    }
  });

  $("#id").focus();
});
