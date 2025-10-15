import { createRootRoute, Outlet } from "@tanstack/react-router";
import "@/styles/root.css";

function RootLayout() {
  return <Outlet />;
}

export const Route = createRootRoute({
  component: RootLayout,
});
