import { createFileRoute, Link, useRouter } from "@tanstack/react-router";
import axios from "axios";
import moment from "moment";
import { useState } from "react";

export const Route = createFileRoute("/product/productInsert")({
  component: RouteComponent,
});

function RouteComponent() {
  const API_URL = import.meta.env.VITE_API_URL;

  const router = useRouter();

  const [dateInput, setDateInput] = useState<string>("");

  const handleSumit = async (event: React.FormEvent<HTMLFormElement>) => {
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
      const resp = await axios.post(
        `${API_URL}/product/insertProduct`,
        formValues
      );

      if (resp.data === "success") {
        alert("상품 정보가 성공적으로 등록되었습니다.");
        router.navigate({ to: "/product/productList", replace: true });
      } else if (resp.data === "exists") {
        alert("이미 존재하는 상품 번호입니다. 다른 번호를 입력해주세요.");
      }
    } catch (error) {
      console.error("Error inserting product details:", error);
      alert("상품 정보 등록 중 오류가 발생했습니다.");
    }
  };

  return (
    <>
      <h3 className="text-center text-2xl font-bold">상품 정보 등록</h3>
      <div className="mb-2 inline-flex w-full max-w-lg items-center justify-between">
        <Link
          to="/product/productList"
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
        id="prdForm"
        method="post"
        action="/product/insertProduct"
        onSubmit={handleSumit}
        className="mx-auto max-w-xl border border-neutral-600"
      >
        <table className="w-full table-auto">
          <tbody className="divide-y divide-neutral-600 [&>tr]:divide-x [&>tr]:divide-neutral-600 [&>tr>th]:bg-neutral-400">
            <tr>
              <td>
                <label htmlFor="prdNo">상품</label> 번호
              </td>
              <td>
                <input
                  type="text"
                  name="prdNo"
                  id="prdNo"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="prdName">상품명</label>
              </td>
              <td>
                <input
                  type="text"
                  name="prdName"
                  id="prdName"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="prdPrice">가격</label>
              </td>
              <td>
                <input
                  type="text"
                  name="prdPrice"
                  id="prdPrice"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="prdCompany">제조사</label>
              </td>
              <td>
                <input
                  type="text"
                  name="prdCompany"
                  id="prdCompany"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="prdStock">재고</label>
              </td>
              <td>
                <input
                  type="text"
                  name="prdStock"
                  id="prdStock"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label htmlFor="prdDate">제조일</label>
              </td>
              <td>
                <input
                  type="text"
                  name="prdDate"
                  id="prdDate"
                  className="w-full cursor-text bg-white px-4 py-2 focus:bg-cyan-50"
                  value={dateInput}
                  onChange={(e) => setDateInput(e.target.value)}
                  placeholder="YYYY-MM-DD"
                />
              </td>
            </tr>
            <tr>
              <td colSpan={2}>
                <div className="flex items-center justify-center gap-8 py-4">
                  <input
                    type="submit"
                    value="등록"
                    id="prdNoCheckBtn"
                    className="cursor-pointer rounded bg-blue-500 px-4 py-2 font-bold text-white hover:bg-blue-600"
                  />
                  <input
                    type="reset"
                    value="초기화"
                    className="cursor-pointer rounded bg-gray-300 px-4 py-2 font-bold text-black hover:bg-gray-400"
                  />
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </>
  );
}
