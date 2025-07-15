$(function () {
  $("#tabMenu ul li").click(function () {
    // Remove 'selected' class from all tabs
    $("#tabMenu ul li").removeClass("selected");
    // Add 'selected' class to the clicked tab
    $(this).addClass("selected");

    // Hide all tab content
    $("#tabContent div").removeClass("selected");
    // Show the content corresponding to the clicked tab
    $("#tabContent div").eq($(this).index()).addClass("selected");
  });
});
