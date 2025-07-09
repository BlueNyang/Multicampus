const callback: () => void = function () {
  console.log("Callback function executed");
};

function show(callback: () => void): void {
  callback(); // Call the callback function
}

console.log("Show function started");
show(callback);
console.log("Show function ended");

export {};
