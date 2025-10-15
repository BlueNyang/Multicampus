import type { Product } from "@/types/productList.type";
import { createFileRoute, Link } from "@tanstack/react-router";
import axios from "axios";
import { useEffect, useState } from "react";

export const Route = createFileRoute("/product/productDetail/$prdNo")({
  component: ProductDetailPage,
});

function ProductDetailPage() {
  const { prdNo } = Route.useParams();

  const [isLoading, setIsLoading] = useState<boolean>(false);
  const [prd, setPrd] = useState<Product | null>(null);

  async function fetchProductDetails(prdNo: string) {
    try {
      setIsLoading(true);
      const resp = await axios.get(
        `http://localhost:8080/product/productDetail/${prdNo}`
      );
      setPrd(resp.data);
    } catch (error) {
      console.error("Error fetching product details:", error);
    } finally {
      setIsLoading(false);
    }
  }

  // Fetch product details based on prdNo
  useEffect(() => {
    if (prdNo) {
      fetchProductDetails(prdNo);
    }
  }, [prdNo]);

  return (
    <>
      <h3>상품 상세 정보 조회</h3>
      <br />
      {isLoading ? (
        <p>Loading product details...</p>
      ) : !prd ? (
        <p>Product not found.</p>
      ) : (
        <>
          <div className="mb-2 inline-flex w-[60%] items-center justify-between">
            <Link to="/product/listAllProduct">[목록으로 이동]</Link>
            <Link to={`/product/updateProductForm/${prd.prdNo}`}>
              [상품 정보 수정]
            </Link>
            <a href="javascript:deleteCheck();">[상품 정보 삭제]</a>
          </div>
          <div className="mx-auto w-6/10 border border-neutral-600">
            <table className="w-full table-auto divide-y divide-neutral-600">
              <thead className="bg-neutral-300">
                <tr>
                  <td colSpan={2} className="bg-white">
                    <img
                      className="mx-auto h-60 w-auto"
                      src={`http://localhost:8080/product_images/${prd.prdNo}.jpg`}
                      alt="상품 이미지"
                    />
                  </td>
                </tr>
                <tr>
                  <th className="px-4 py-2 font-bold tracking-wider">구분</th>
                  <th className="px-4 py-2 font-bold tracking-wider">내용</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-neutral-200 [&>tr]:divide-x [&>tr]:divide-neutral-300 [&>tr:nth-child(even)]:bg-neutral-200">
                <tr>
                  <td className="px-4 py-1">상품번호</td>
                  <td className="px-4 py-1">{prd.prdNo}</td>
                </tr>
                <tr>
                  <td className="px-4 py-1">상품명</td>
                  <td className="px-4 py-1">{prd.prdName}</td>
                </tr>
                <tr>
                  <td className="px-4 py-1">가격</td>
                  <td className="px-4 py-1">{prd.prdPrice}</td>
                </tr>
                <tr>
                  <td className="px-4 py-1">제조회사</td>
                  <td className="px-4 py-1">{prd.prdCompany}</td>
                </tr>
                <tr>
                  <td className="px-4 py-1">재고</td>
                  <td className="px-4 py-1">{prd.prdStock}</td>
                </tr>
                <tr>
                  <td className="px-4 py-1">제조일</td>
                  <td className="px-4 py-1">{prd.prdDate}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </>
      )}
    </>
  );
}
