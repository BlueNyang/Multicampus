$(function () {
  const $allCheck = $("#allCheck");
  const $chkDelete = $(".chkDelete");

  $allCheck.on("click", function () {
    const chk = $allCheck.prop("checked");

    if (chk) {
      $chkDelete.prop("checked", true);
    } else {
      $chkDelete.prop("checked", false);
    }
  }); // end of click for $allCheck

  $chkDelete.each(function () {
    $(this).on("click", function () {
      const total = $(".chkDelete").length;
      const checked = $(".chkDelete:checked").length;

      if (total !== checked) {
        $allCheck.prop("checked", false);
      } else {
        $allCheck.prop("checked", true);
      }
    });
  });

  const $deleteCartBtn = $("#deleteCartBtn");
  $deleteCartBtn.on("click", function () {
    const $checkedDelete = $(".chkDelete:checked");
    if ($checkedDelete.length === 0) {
      alert("삭제할 상품을 선택하세요.");
      return;
    }

    if (confirm("선택한 상품을 삭제하시겠습니까?")) {
      const checkArr = [];
      $checkedDelete.each(function () {
        checkArr.push($(this).val());
      });

      const count = checkArr.length;

      $.ajax(
        "/cart/deleteFromCart",
        {
          type: "POST",
          data: {"chkBoxArr": checkArr},
          dataType: "text",
          success: function (result) {
            const deletedCount = Number(result);

            if (deletedCount !== count) {
              alert(`일부 상품이 삭제되지 않았습니다. 삭제된 상품 수: ${deletedCount}`);
            } else {
              alert("선택한 상품이 모두 삭제되었습니다.");
            }
            location.reload();
          },
          error: function () {
            alert("삭제 중 오류가 발생했습니다. 다시 시도해주세요.");
          }
        }
      ); // end of ajax
    } // end of if confirm
  }); // end of click for $deleteCartBtn

  const $total = $("#total");
  let totalPrice = 0;
  $(".itemPrice").each(function () {
    totalPrice += $(this).data("price");
  });

  $total.text(totalPrice.toLocaleString("ko-KR"));
});