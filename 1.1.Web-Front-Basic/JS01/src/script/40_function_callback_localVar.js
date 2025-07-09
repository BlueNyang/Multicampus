const globalVar = 100;
function show(localVar) {
    console.log(`Global Variable: ${globalVar}`);
    console.log(`Local Variable: ${localVar}`);
}
function call(callback) {
    let localVar = 1;
    callback(localVar);
}
call(show);
