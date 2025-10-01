$(function () {
  const $imageFileFrm = $("#imageFileFrm");
  $imageFileFrm.on(
    "submit",
    function (e) {
      e.preventDefault();

      const formData = new FormData($imageFileFrm[0]);
      const fileName = $("#uploadFile").val().replace(/\\/g, "/").split("/").pop();

      $.ajax({
        type: "POST",
        url: "/file/imageFileUpload",
        encType: "multipart/form-data",
        processData: false,
        contentType: false,
        data: formData,
        success: (resp) => {
          if (resp === "success") {
            const image = `<img src="/images/${fileName}" width=400 height=300 alt="">`;
            console.log(image);
            $("#imageBox").html(image);
          }
        },
        error: (err) => {
          console.log(err);
          alert("File upload failed.");
        },
        // complete: () => {
        //   alert("File upload process completed.");
        // },
      });
    }
  );
});