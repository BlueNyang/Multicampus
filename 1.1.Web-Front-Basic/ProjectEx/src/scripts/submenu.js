$(function () {
  $("#showAllMenu").click(function (e) {
    e.preventDefault();

    const $subMenuBox = $("#subMenuBox");

    $(this).toggleClass("fade-out");
    $subMenuBox.toggleClass("show");

    setTimeout(() => {
      const isShow = $subMenuBox.hasClass("show");

      const newHtml = isShow
        ? `메뉴닫기<i class="bi bi-caret-up"></i>`
        : `전체보기<i class="bi bi-caret-down-fill"></i>`;

      const newColor = isShow ? "blue" : "";

      $(this).html(newHtml).toggleClass("fade-out").css({
        color: newColor,
      });
    }, 300);
  });
});
