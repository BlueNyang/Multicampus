import typescript from "@rollup/plugin-typescript";
import { glob } from "glob";

export default {
  input: glob.sync("./src/**/*.ts"),
  output: {
    dir: "../script",
    format: "es",
    preserveModules: true,
    sourcemap: false,
  },
  plugins: [
    typescript({
      tsconfig: "./tsconfig.json",
    }),
  ],
};
