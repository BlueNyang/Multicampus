let swiper;

(() => {
  const addBannerItems = (slideImgs) => {
    const slideWrapper = document.querySelector(".swiper-wrapper");

    slideImgs.forEach((slideImg) => {
      const slideDiv = document.createElement("div");
      slideDiv.classList.add("swiper-slide");
      slideDiv.dataset.title = slideImg.imageTitle;
      slideDiv.dataset.alt = slideImg.imageAlt;

      const a = document.createElement("a");
      a.href = slideImg.linkUrl || "#";
      a.innerHTML = `<img src="${slideImg.imageUrl}" alt="[${slideImg.imageTitle}] ${slideImg.imageAlt}" />`;

      slideDiv.appendChild(a);
      slideWrapper.appendChild(slideDiv);
    });
  };

  document.addEventListener("DOMContentLoaded", async () => {
    const resp = await fetch("/get/slides");
    if (resp.status === 200) {
      const slideImgs = await resp.json();

      addBannerItems(slideImgs);
      if (slideImgs.length <= 3) {
        addBannerItems(slideImgs);
      }
    }

    swiper = new Swiper(".swiper", {
      loop: true,

      autoplay: {
        delay: 3000,
      },

      slidesPerView: "auto",
      centeredSlides: true,
      spaceBetween: 0,

      on: {
        slideChange: function () {
          const realIndex = this.realIndex;
          const currentSlide = this.slides.find(
            (slide) =>
              parseInt(slide.getAttribute("data-swiper-slide-index")) ===
              realIndex
          );

          if (currentSlide) {
            const title = currentSlide.dataset.title;
            const alt = currentSlide.dataset.alt;

            document.querySelector(".alt-title").textContent = title;
            document.querySelector(".alt-desc").textContent = alt;
          }
        },

        init: function () {
          this.emit("slideChange");
        },
      },
    });
  });
})();
