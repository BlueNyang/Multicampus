import { createFileRoute } from "@tanstack/react-router";
import { Header } from "@/components/Header";

export const Route = createFileRoute("/")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <div className="text-center">
      <h1 className="my-4 text-4xl font-bold">홈 입니다</h1>
      <p className="mb-4 text-xl">방문을 환영합니다</p>
      <Header />
    </div>
  );
}
