$(function () {
  $("#moveToTopBox").click(function () {
    $("html, body").animate({ scrollTop: 0 }, 500);
  });
});
