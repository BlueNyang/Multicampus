document.addEventListener("DOMContentLoaded", () => {
  const manageForm = document.getElementById("manageForm");
  if (manageForm) {
    manageForm.addEventListener("submit", function (e) {
      const actionValue = e.submitter.value;
      if (actionValue === "withdraw" && !confirm("정말 탈퇴하시겠습니까?")) {
        e.preventDefault();
      }
    });
  }
})