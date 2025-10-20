(() => {
  document.addEventListener("DOMContentLoaded", async () => {
    const iconMeta = await fetch("/meta/icon-meta.json")
      .then(async (response) => await response.json())
      .catch((error) => {
        console.error("Error fetching icon meta:", error);
        return {};
      });

    const iconElements = document.querySelectorAll("[data-icon]");
    iconElements.forEach(async (element) => {
      const iconType = element.dataset.icon; // join, login, cart
      const iconFile = iconMeta[iconType];

      if (iconFile) {
        await fetch(`${iconFile}`)
          .then(async (response) => await response.text())
          .then((svgContent) => {
            element.insertAdjacentHTML("afterbegin", svgContent);
          })
          .catch((error) => {
            console.error(`Error fetching icon (${iconFile}):`, error);
          });
      }
    });
  });
})();
