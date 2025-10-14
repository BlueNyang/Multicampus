$(function () {
  let qty = 1;

  const $plusBtn = $('#plusBtn');
  const $minusBtn = $('#minusBtn');

  $plusBtn.on("click", function () {
    qtyChange(1);
  });

  $minusBtn.on("click", function () {
    qtyChange(-1);
  });

  function qtyChange(num) {
    qty += num;
    if (qty < 1) qty = 1;
    calAmount();
  }

  function calAmount() {
    const $cartQty = $('#cartQty');
    const $amount = $('#amount');

    const price = $("#price").data("price");
    const total = Number(price) * qty;

    $cartQty.val(qty);
    $amount.html(total.toLocaleString());
  }
});