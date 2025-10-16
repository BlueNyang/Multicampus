import { useDeleteProduct } from "@/hooks/useDeleteProduct";
import type { Product } from "@/types/productList.type";
import { Link } from "@tanstack/react-router";

interface ProductListItemProps {
  product: Product;
  onDelete: () => void;
}

export function ProductListItem({ product, onDelete }: ProductListItemProps) {
  const { isLoading, error, deleteProduct } = useDeleteProduct();

  return (
    <tr
      className="divide-x divide-neutral-300 hover:bg-neutral-100"
      key={product.prdNo}
    >
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        {product.prdNo}
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        <Link
          to="/product/productDetail/$prdNo"
          params={{ prdNo: product.prdNo }}
          className="text-blue-500 hover:underline"
        >
          {product.prdName}
        </Link>
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        {product.prdPrice.toLocaleString()}원
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        {product.prdCompany}
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        {product.prdStock}
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        {product.prdDate}
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        <Link
          to="/product/productUpdate/$prdNo"
          params={{ prdNo: product.prdNo }}
          className="text-rose-500 hover:text-rose-700 hover:underline"
        >
          수정
        </Link>
      </td>
      <td className="px-6 py-3 font-normal whitespace-nowrap">
        <Link
          to="/"
          onClick={async (e) => {
            e.preventDefault();
            await deleteProduct(product.prdNo);
            onDelete();

            if (error) {
              alert(error);
            }
          }}
          className={`text-rose-500 ${isLoading ? "disabled cursor-not-allowed" : "hover:text-rose-700 hover:underline"}`}
        >
          {isLoading ? "삭제중..." : "삭제"}
        </Link>
      </td>
    </tr>
  );
}
