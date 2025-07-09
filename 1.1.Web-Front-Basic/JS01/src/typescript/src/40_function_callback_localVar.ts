const globalVar: number = 100;

function show(localVar: number): void {
  console.log(`Global Variable: ${globalVar}`);
  console.log(`Local Variable: ${localVar}`);
}

function call(callback: (n: number) => void): void {
  let localVar: number = 1;
  callback(localVar);
}

call(show);

export {};
