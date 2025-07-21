$(document).ready(function () {
  $("#chatForm").submit(function (e) {
    e.preventDefault();

    const message = $("#message").val();
    if (message.trim() === "") {
      return;
    }

    $("#chatBox").append(`<div class="msgBox send"><span>${message}</span></div>`);
    $("#message").val("");

    loadingResponse();
    setTimeout(() => {
      getResponse();
    }, 1000);
  });

  $("#closeBtn").click(function () {
    window.close();
  });
});

function loadingResponse() {
  $("#chatBox").append(`<div class="msgBox receive"><br>챗봇<br><span>...</span></div><br>`);
  // 마지막에 추가된 메시지가 보이도록 위로 스크롤
  $("#chatBox").scrollTop($("#chatBox").prop("scrollHeight"));
}

function getResponse() {
  const result = "저는 챗봇입니다. 응답 메시지를 길게 작성합니다. 줄바꿈을 확인하기 위해서 입니다.";

  //$("#chatBox").append(`<div class="msgBox receive"><br>챗봇<br><span>${result}</span></div><br>`);
  $("#chatBox").find(".receive span").last().text(`${result}`);

  // 마지막에 추가된 메시지가 보이도록 위로 스크롤
  $("#chatBox").scrollTop($("#chatBox").prop("scrollHeight"));
}
