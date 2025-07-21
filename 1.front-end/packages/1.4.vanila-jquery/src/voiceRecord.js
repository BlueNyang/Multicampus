function changeActiveColor(btn, color) {
  btn.classList.toggle(color);
  btn.classList.toggle("text-white");
  btn.classList.toggle("bg-gray-300");
  btn.classList.toggle("cursor-pointer");
  btn.disabled = !btn;
}

window.onload = () => {
  const recordBtn = document.getElementById("recordBtn");
  const stopBtn = document.getElementById("stopBtn");

  const soundClips = document.getElementById("sound-clips");

  function changeBtnColor() {
    changeActiveColor(recordBtn, "bg-red-300");
    changeActiveColor(stopBtn, "bg-blue-400");
  }

  if (navigator.mediaDevices) {
    const contraints = {
      audio: true,
    };

    let chunks = []; //녹인 데이터 저장 변수
    // mediaDevices: 카메라 마이크, 공유 화면 등 현재 연경된 미디어 입력장치로의 접근 방법을 제공하는 인터페이스
    navigator.mediaDevices
      .getUserMedia(contraints)
      .then((stream) => {
        const mediaRecorder = new MediaRecorder(stream);
        recordBtn.disabled = false;

        if (mediaRecorder.state === "recording") {
          changeBtnColor();
          recordBtn.disabled = true;
          stopBtn.disabled = false;
        } else {
          stopBtn.disabled = true;
        }

        recordBtn.onclick = () => {
          changeBtnColor();
          mediaRecorder.start();
        };

        stopBtn.onclick = () => {
          changeBtnColor();
          mediaRecorder.stop();
        };

        mediaRecorder.ondataavailable = (e) => {
          chunks.push(e.data);
        };

        mediaRecorder.onstop = () => {
          const clipContainer = document.createElement("article");
          clipContainer.classList.add(
            "bg-gray-200",
            "p-4",
            "rounded-2xl",
            "shadow-md",
            "mb-4",
            "flex",
            "flex-row",
            "gap-4"
          );

          const audio = document.createElement("audio");
          audio.setAttribute("controls", "");

          clipContainer.appendChild(audio);

          const blob = new Blob(chunks, {
            type: "audio/mp3; codecs=opus",
          });

          chunks = [];

          const audioURL = window.URL.createObjectURL(blob);
          audio.src = audioURL;

          const clipName = "volceRecord" + new Date().toLocaleTimeString();

          const a = document.createElement("a");
          a.href = audioURL;
          alert("녹음이 완료되었습니다.");
          a.download = clipName + ".mp3";
          a.classList.add("flex", "content-center", "items-center", "gap-2", "my-auto");
          a.innerHTML = `<i class="bi bi-cloud-arrow-down"></i>`;

          clipContainer.appendChild(a);

          const deleteButton = document.createElement("button");
          deleteButton.innerHTML = `<i class="bi bi-trash"></i>`;
          deleteButton.className = "delete";
          deleteButton.onclick = () => {
            clipContainer.parentNode.removeChild(clipContainer);
          };
          clipContainer.appendChild(deleteButton);

          soundClips.appendChild(clipContainer);
        };
      })
      .catch((err) => {
        console.error("The following error occurred: " + err);
        alert(`녹음 권한을 허용해주세요. ${err}`);
      });
  }
};
