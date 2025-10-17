(() => {
  document.addEventListener("DOMContentLoaded", async () => {
    const resp = await fetch("/get/slides");
    const slides = await resp.json();

    const slideWrapper = document.querySelector(".swiper-wrapper");
    slides.forEach((slide) => {
      const slideDiv = document.createElement("div");
      slideDiv.classList.add("swiper-slide");
      slideDiv.innerHTML = `<img src="${slide.image}" alt="${slide.alt}" />`;
      slideWrapper.appendChild(slideDiv);
    });
  });
})();
