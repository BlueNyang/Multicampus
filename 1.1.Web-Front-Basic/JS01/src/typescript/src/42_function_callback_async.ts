function callback(): void {
  console.log("Callback function executed");
}

console.log("Show function started");
setTimeout(callback, 1000); // Call the callback function after 1 second
console.log("Show function ended");

export {};
