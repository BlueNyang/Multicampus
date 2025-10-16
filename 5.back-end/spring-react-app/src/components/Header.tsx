import { Link } from "@tanstack/react-router";

export function Header() {
  return (
    <div className="mx-auto my-4 w-full max-w-6xl">
      <ul className="mx-auto flex max-w-3xl justify-between gap-8 text-base">
        <li className="flex w-20 justify-center gap-8">
          <Link
            to="/"
            className="text-blue-500 hover:cursor-pointer hover:text-cyan-500 hover:underline"
          >
            [홈]
          </Link>
        </li>
        <li className="flex w-20 justify-center gap-8">
          <Link
            to="/product/productList"
            className="text-blue-500 hover:cursor-pointer hover:text-cyan-500 hover:underline"
          >
            [상품 목록]
          </Link>
        </li>
        <li className="flex w-20 justify-center gap-8">
          <Link
            to="/product/productInsert"
            className="text-blue-500 hover:cursor-pointer hover:text-cyan-500 hover:underline"
          >
            [상품 등록]
          </Link>
        </li>
        <li className="flex w-20 justify-center gap-8">
          <Link
            to="/product/productSearch"
            className="text-blue-500 hover:cursor-pointer hover:text-cyan-500 hover:underline"
          >
            [상품 검색]
          </Link>
        </li>
      </ul>
    </div>
  );
}
