import { Header } from "@/components/Header";
import type { Product } from "@/types/productList.type";
import { createFileRoute, Link } from "@tanstack/react-router";
import axios from "axios";
import { useState } from "react";

export const Route = createFileRoute("/product/productSearch")({
  component: RouteComponent,
});

function RouteComponent() {
  const API_URL = import.meta.env.VITE_API_URL;

  const [isLoading, setIsLoading] = useState(false);
  const [prdResult, setPrdResult] = useState<Product[]>([]);

  const [searchType, setSearchType] = useState("");
  const [keyword, setKeyword] = useState("");

  const handleSearch = async (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();

    if (!searchType || !keyword) {
      alert("검색 조건과 키워드를 모두 입력해주세요.");
      return;
    }

    setIsLoading(true);

    try {
      const resp = await axios.post(`${API_URL}/product/searchProduct`, {
        type: searchType,
        keyword: keyword,
      });

      const data: Product[] = resp.data;

      setPrdResult(data);
    } catch (error) {
      console.error("Error fetching search results:", error);
      alert("검색 중 오류가 발생했습니다. 다시 시도해주세요.");
    } finally {
      setIsLoading(false);
    }
  };

  return isLoading ? (
    <div className="text-center">Loading...</div>
  ) : (
    <>
      <h3 className="text-center text-2xl font-bold">상품 검색</h3>
      <Header />
      <div
        id="prdSearchFrm1"
        className="mx-auto mt-2 mb-4 flex w-full max-w-4xl items-center bg-white px-4 py-2"
      >
        <select
          id="type"
          name="type"
          defaultValue=""
          className="mr-2 rounded border border-neutral-400 bg-white px-2 py-1"
          onChange={(e) => setSearchType(e.target.value)}
          value={searchType}
        >
          <option value="">검색 조건 선택</option>
          <option value="prdName">상품명</option>
          <option value="prdCompany">제조회사</option>
        </select>

        <label htmlFor="keyword"></label>
        <input
          type="text"
          name="keyword"
          id="keyword"
          className="mr-2 flex-1 rounded border border-neutral-400 bg-white px-2 py-1"
          onChange={(e) => setKeyword(e.target.value)}
          value={keyword}
        />

        <button
          onClick={handleSearch}
          className="w-20 rounded border border-neutral-400 bg-white px-2 py-1 hover:cursor-pointer hover:bg-neutral-200"
        >
          검색
        </button>
      </div>

      <div className="mx-auto w-full max-w-4xl overflow-hidden rounded-xl border border-neutral-600">
        <table className="w-full table-auto divide-y divide-neutral-600">
          <thead className="bg-neutral-300">
            <tr className="divide-x divide-neutral-400 [&>th]:px-6 [&>th]:py-3 [&>th]:font-medium [&>th]:tracking-wider">
              <th>상품번호</th>
              <th>상품명</th>
              <th>제조회사</th>
              <th>가격</th>
              <th>재고량</th>
              <th>제조일</th>
              <th>사진</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-neutral-300 [&>tr>td]:px-6 [&>tr>td]:py-2">
            {prdResult && prdResult.length === 0 ? (
              <tr className="text-center">
                <td colSpan={6}>검색 결과가 없습니다.</td>
              </tr>
            ) : (
              prdResult.map((product) => (
                <tr
                  key={product.prdNo}
                  className="divide-x divide-neutral-400 hover:bg-neutral-200/75"
                >
                  <td>
                    <Link
                      to="/product/productDetail/$prdNo"
                      params={{ prdNo: product.prdNo }}
                      className="text-blue-500 hover:cursor-pointer hover:text-cyan-500 hover:underline"
                    >
                      {product.prdNo}
                    </Link>
                  </td>
                  <td>{product.prdName}</td>
                  <td>{product.prdCompany}</td>
                  <td>{product.prdPrice}</td>
                  <td>{product.prdStock}</td>
                  <td>{product.prdDate}</td>
                  <td>
                    <img
                      src={`${API_URL}/product_images/${product.prdNo}.jpg`}
                      alt="Product Image"
                      width="100"
                    />
                  </td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>
    </>
  );
}
