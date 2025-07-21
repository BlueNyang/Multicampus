$(function () {
  function drawCanvas(result, src) {
    const canvas = document.getElementById("poseCanvas");
    const context = canvas.getContext("2d");

    const posImage = new Image();
    posImage.src = src;
    posImage.width = canvas.width;
    posImage.height = canvas.height;

    posImage.onload = () => {
      context.drawImage(posImage, 0, 0, canvas.width, canvas.height);

      const colors = [
        "red",
        "blue",
        "yellow",
        "yellow",
        "yellow",
        "green",
        "green",
        "green",
        "skyblue",
        "skyblue",
        "skyblue",
        "white",
        "white",
        "white",
        "brown",
        "gold",
      ];

      const position = [
        "코",
        "목",
        "오른쪽 어깨",
        "오른쪽 팔꿈치",
        "오른쪽 손목",
        "왼쪽 어깨",
        "왼쪽 팔꿈치",
        "왼쪽 손목",
        "오른쪽 엉덩이",
        "오른쪽 무릎",
        "오른쪽 발목",
        "왼쪽 엉덩이",
        "왼쪽 무릎",
        "왼쪽 발목",
        "왼쪽 눈",
        "왼쪽 귀",
      ];

      let value = "";

      $.each(result, function (i) {
        if (this.x != 0 || this.y != 0) {
          context.strokeStyle = colors[i];
          context.strokeRect(this.x * canvas.width, this.y * canvas.height, 2, 2);
          const text = `${this.x.toFixed(2)}, ${this.y.toFixed(2)}`;
          context.font = "18px";
          context.strokeText(text, this.x * canvas.width + 5, this.y * canvas.height - 5);
        }
        value += `${position[i]}: ${this.x.toFixed(2)}, ${this.y.toFixed(2)}<br>`;
      });
      $("#resultDivBox").html(value);
    };
  }

  $("#showBtn").click(function () {
    // 서버에서 포즈 인식 진행 후, 결과 값은 반환 받았다고 가정
    const result = {
      points: [
        { x: 0.42, y: 0.2 },
        { x: 0.49, y: 0.22 },
        { x: 0.42, y: 0.27 },
        { x: 0.3, y: 0.33 },
        { x: 0.32, y: 0.22 },
        { x: 0.52, y: 0.25 },
        { x: 0.65, y: 0.31 },
        { x: 0.72, y: 0.41 },
        { x: 0.61, y: 0.51 },
        { x: 0.65, y: 0.69 },
        { x: 0.81, y: 0.82 },
        { x: 0.51, y: 0.51 },
        { x: 0.29, y: 0.51 },
        { x: 0.35, y: 0.72 },
        { x: 0.44, y: 0.17 },
        { x: 0.49, y: 0.18 },
      ],
    };

    const src = "image/run.jpg";

    drawCanvas(result.points, src);
    console.log(value);
  });
});
