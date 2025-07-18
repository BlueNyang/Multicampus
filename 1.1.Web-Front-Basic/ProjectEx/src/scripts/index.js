$(function () {
  const $nav = $("#mainMenu");
  const navTop = $nav.offset().top;

  $(window).scroll(function () {
    const scrollTop = $(this).scrollTop();

    $nav.toggleClass("isSticky", scrollTop > navTop);
  });
});
