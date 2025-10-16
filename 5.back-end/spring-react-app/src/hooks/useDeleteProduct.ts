import { useRouter } from "@tanstack/react-router";
import axios from "axios";
import { useState } from "react";

export function useDeleteProduct() {
  const API_URL = import.meta.env.VITE_API_URL;

  const [isLoading, setIsLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const deleteProduct = async (prdNo: string) => {
    if (!API_URL) {
      setError("API URL is not defined.");
      return;
    }

    if (!window.confirm("정말 삭제하시겠습니까?")) {
      return;
    }

    setIsLoading(true);
    setError(null);

    try {
      await axios.delete(`${API_URL}/product/deleteProduct/${prdNo}`);
      alert("삭제되었습니다.");
      useRouter().navigate({ to: "/product/productList", replace: true });
    } catch (error) {
      setError("상품 삭제에 실패했습니다.");
    } finally {
      setIsLoading(false);
    }
  };

  return { isLoading, error, deleteProduct };
}
