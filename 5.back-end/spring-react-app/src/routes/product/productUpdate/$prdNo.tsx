import type { Product } from "@/types/productList.type";
import { createFileRoute, Link, useRouter } from "@tanstack/react-router";
import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";

const API_URL = import.meta.env.VITE_API_URL;

export const Route = createFileRoute("/product/productUpdate/$prdNo")({
  component: RouteComponent,
});

function RouteComponent() {
  const API_URL = import.meta.env.VITE_API_URL;

  const { prdNo } = Route.useParams();
  const router = useRouter();

  const [dateInput, setDateInput] = useState<string>("");

  const [isLoading, setIsLoading] = useState<boolean>(false);
  const [prd, setPrd] = useState<Product | null>(null);

  function onInputChange(data: Partial<Product>) {
    setPrd((prevPrd) => (prevPrd ? { ...prevPrd, ...data } : prevPrd));
  }

  async function fetchProductDetails(prdNo: string) {
    try {
      setIsLoading(true);
      const resp = await axios.get(
        `${API_URL}/product/productUpdateInfo/${prdNo}`
      );
      setPrd(resp.data);
      setDateInput(resp.data.prdDate);
    } catch (error) {
      console.error("Error fetching product update info:", error);
    } finally {
      setIsLoading(false);
    }
  }

  async function updateProductDetails(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();

    const momentDate = moment(dateInput);

    if (!momentDate.isValid()) {
      alert("유효한 날짜를 입력해주세요 (YYYY-MM-DD 형식)");
      return;
    }

    const formData = new FormData(event.currentTarget);
    const formValues = Object.fromEntries(formData.entries());

    formValues.prdDate = momentDate.format("YYYY-MM-DD");

    try {
      await axios.post(`${API_URL}/product/updateProduct`, formValues);

      alert("상품 정보가 성공적으로 수정되었습니다.");
      router.navigate({ to: "/product/productList", replace: true });
    } catch (error) {
      console.error("Error inserting product details:", error);
      alert("상품 정보 등록 중 오류가 발생했습니다.");
    }
  }

  useEffect(() => {
    if (prdNo) {
      fetchProductDetails(prdNo);
    }
  }, [prdNo]);

  return isLoading ? (
    <div>Loading...</div>
  ) : prd ? (
    <>
      <h3 className="mb-4 border-b-2 border-neutral-600 pb-2 text-2xl font-bold">
        상품 정보 수정
      </h3>
      <div className="mb-2 inline-flex w-full max-w-lg items-center justify-between">
        <Link
          to="/product/productDetail/$prdNo"
          params={{ prdNo: prdNo }}
          className="text-blue-600 hover:cursor-pointer hover:text-sky-500 hover:underline"
        >
          [나가기]
        </Link>
        <Link
          to="/"
          className="text-blue-600 hover:cursor-pointer hover:text-sky-500 hover:underline"
        >
          [홈으로 이동]
        </Link>
      </div>
      <form
        method="post"
        action="/product/updateProduct"
        onSubmit={updateProductDetails}
        className="mx-auto max-w-xl border border-neutral-600"
      >
        <table className="w-full table-auto">
          <tbody className="divide-y divide-neutral-600 [&>tr]:divide-x [&>tr]:divide-neutral-600 [&>tr>th]:bg-neutral-400">
            <tr>
              <th>
                <label htmlFor="prdNo">상품 번호</label>
              </th>
              <td>
                <input
                  type="text"
                  name="prdNo"
                  id="prdNo"
                  value={prd.prdNo}
                  readOnly
                  className="w-full cursor-not-allowed bg-gray-200 px-4 py-2 focus:bg-gray-200"
                />
              </td>
            </tr>
            <tr>
              <th>
                <label htmlFor="prdName">상품명</label>
              </th>
              <td>
                <input
                  type="text"
                  name="prdName"
                  id="prdName"
                  value={prd.prdName}
                  onChange={(e) => onInputChange({ prdName: e.target.value })}
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <th>
                <label htmlFor="prdPrice">가격</label>
              </th>
              <td>
                <input
                  type="text"
                  name="prdPrice"
                  id="prdPrice"
                  value={prd.prdPrice}
                  onChange={(e) =>
                    onInputChange({ prdPrice: Number(e.target.value) })
                  }
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <th>
                <label htmlFor="prdCompany">제조회사</label>
              </th>
              <td>
                <input
                  type="text"
                  name="prdCompany"
                  id="prdCompany"
                  value={prd.prdCompany}
                  onChange={(e) =>
                    onInputChange({ prdCompany: e.target.value })
                  }
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <th>
                <label htmlFor="prdStock">재고</label>
              </th>
              <td>
                <input
                  type="text"
                  name="prdStock"
                  id="prdStock"
                  value={prd.prdStock}
                  onChange={(e) =>
                    onInputChange({ prdStock: Number(e.target.value) })
                  }
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <th>
                <label htmlFor="prdDate">제조일</label>
              </th>
              <td>
                <input
                  type="text"
                  name="prdDate"
                  id="prdDate"
                  value={dateInput}
                  onChange={(e) => setDateInput(e.target.value)}
                  placeholder="YYYY-MM-DD"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <td colSpan={2}>
                <div className="flex items-center justify-center gap-8 py-4">
                  <input
                    type="submit"
                    value="수정"
                    className="cursor-pointer rounded bg-blue-500 px-4 py-2 font-bold text-white hover:bg-blue-600"
                  />
                  <input
                    type="reset"
                    value="취소"
                    onClick={() => {
                      router.history.back();
                    }}
                    className="cursor-pointer rounded bg-gray-300 px-4 py-2 font-bold text-black hover:bg-gray-400"
                  />
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </>
  ) : (
    <div>상품 정보를 불러오는 중 오류가 발생했습니다.</div>
  );
}
