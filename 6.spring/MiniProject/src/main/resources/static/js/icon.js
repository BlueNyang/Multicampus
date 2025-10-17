(() => {
  document.addEventListener("DOMContentLoaded", async () => {
    const iconMeta = await fetch("/meta/icon-meta.json")
      .then(async (response) => await response.json())
      .catch((error) => {
        console.error("Error fetching icon meta:", error);
        return {};
      });

    const utils = document.querySelectorAll("a[data-icon]");
    utils.forEach(async (util) => {
      const iconType = util.attributes["data-icon"].value; // join, login, cart
      const iconFile = iconMeta[iconType];

      if (iconFile) {
        await fetch(`${iconFile}`)
          .then(async (response) => await response.text())
          .then((svgContent) => {
            util.insertAdjacentHTML("afterbegin", svgContent);
          })
          .catch((error) => {
            console.error(`Error fetching icon (${iconFile}):`, error);
          });
      }
    });
  });
})();
