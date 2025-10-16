import { Header } from "@/components/Header";
import { ProductListItem } from "@/components/ProductListItem";
import type { Product } from "@/types/productList.type";
import { createFileRoute } from "@tanstack/react-router";
import axios from "axios";
import { useEffect, useState } from "react";

export const Route = createFileRoute("/product/productList")({
  component: RouteComponent,
});

function RouteComponent() {
  const API_URL = import.meta.env.VITE_API_URL;

  const [products, setProducts] = useState<Product[]>([]);

  const fetchProducts = async () => {
    try {
      const response = await axios.get(`${API_URL}/product/productList`);

      setProducts(response.data);
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <>
      <h3 className="text-center text-2xl font-bold">상품 조회</h3>
      <Header />
      <div className="mx-auto w-fit overflow-hidden rounded-xl border border-neutral-600">
        <table className="table-auto divide-y divide-neutral-600">
          <thead className="bg-neutral-300">
            <tr className="divide-x divide-neutral-400">
              <th className="px-6 py-3 font-medium tracking-wider">
                상품 번호
              </th>
              <th className="px-6 py-3 font-medium tracking-wider">상품명</th>
              <th className="px-6 py-3 font-medium tracking-wider">
                상품 가격
              </th>
              <th className="px-6 py-3 font-medium tracking-wider">제조사</th>
              <th className="px-6 py-3 font-medium tracking-wider">재고</th>
              <th className="px-6 py-3 font-medium tracking-wider">제조일</th>
              <th className="px-6 py-3 font-medium tracking-wider">수정</th>
              <th className="px-6 py-3 font-medium tracking-wider">삭제</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-neutral-300">
            {products.map((product) => (
              <ProductListItem
                product={product}
                onDelete={async () => {
                  await fetchProducts();
                }}
              />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}
