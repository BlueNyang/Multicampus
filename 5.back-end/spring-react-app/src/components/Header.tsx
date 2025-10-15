import { Link } from "@tanstack/react-router";

export function Header() {
  return (
    <div>
      <ul>
        <li className="flex justify-center gap-8">
          <Link to="/">홈</Link>
          <Link to="/product/productList">상품 목록</Link>
          <Link to="/productInsert">상품 등록</Link>
        </li>
      </ul>
    </div>
  );
}
