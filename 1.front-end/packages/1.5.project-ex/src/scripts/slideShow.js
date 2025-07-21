$(function () {
  // SlidePanel object
  const $slidePanel = $("#slidePanel");
  // Control buttons
  const $controlButtons = $("#controlPanel .controlButton");

  // Constants
  const SLIDE_WIDTH = 1280;
  const slide_count = $slidePanel.children().length;

  // Interval for automatic slide change
  let startInterval;
  // Current index of the slide
  let currentIndex = 0;

  /**
   * Sets the control button appearance based on the current slide index.
   * The button corresponding to the current slide is highlighted.
   * @param {number} index - The current slide index.
   * @param {boolean} isActive - Whether the button should be active or not.
   * @returns {void}
   */
  function setControlButtons(index, isActive) {
    $controlButtons
      .eq(index)
      .attr("src", isActive ? "./src/image/controlButton2.png" : "./src/image/controlButton1.png");
  }

  /**
   * Changes the slide to the specified index.
   * The index is wrapped around if it exceeds the number of slides.
   * @param {number} index
   */
  function slideShow(index) {
    // Deactivate the current button
    setControlButtons(currentIndex, false);

    // Wrap the index around if it exceeds the number of slides
    currentIndex = (index + slide_count) % slide_count;
    setControlButtons(currentIndex, true); // Activate new button

    // Animate the slide panel to the new position
    $slidePanel.animate({ left: -SLIDE_WIDTH * currentIndex }, 500);
    // Update the control buttons
    setControlButtons();
  }

  /**
   * Starts the slideshow by changing slides every 5 seconds.
   * It uses setInterval to call slideShow with the next index.
   * The slideshow can be stopped by hovering over the slideShowBox.
   * @returns {void}
   */
  function startSlideShow() {
    startInterval = setInterval(function () {
      slideShow(currentIndex + 1);
    }, 5000); // Change slide every 5 seconds
  }

  /**
   * Stops the slideshow by clearing the interval.
   * @returns {void}
   */
  function stopSlideShow() {
    clearInterval(startInterval);
  }

  // Next button click event
  $("#nextBtn").click(function () {
    slideShow(currentIndex + 1);
  });

  // Previous button click event
  $("#prevBtn").click(function () {
    slideShow(currentIndex - 1);
  });

  // Control button click event
  // Each button corresponds to a slide, clicking it will show that slide
  $controlButtons.click(function () {
    slideShow($controlButtons.index(this));
  });

  // Hover events to stop and start the slideshow
  $("#slideShowBox").hover(stopSlideShow, startSlideShow);

  // Initialize the slideshow on page load
  startSlideShow(); // Start the slideshow on page load
  setControlButtons(0, true); // Initialize control buttons
});
