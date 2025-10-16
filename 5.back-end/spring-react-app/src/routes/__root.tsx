import { createRootRoute, Outlet } from "@tanstack/react-router";

function RootLayout() {
  return (
    <div className="mx-auto max-w-7xl p-8 text-center">
      <Outlet />
    </div>
  );
}

export const Route = createRootRoute({
  component: RootLayout,
});
