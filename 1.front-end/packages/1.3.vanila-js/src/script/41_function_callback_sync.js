const callback = function () {
    console.log("Callback function executed");
};
function show(callback) {
    callback(); // Call the callback function
}
console.log("Show function started");
show(callback);
console.log("Show function ended");
