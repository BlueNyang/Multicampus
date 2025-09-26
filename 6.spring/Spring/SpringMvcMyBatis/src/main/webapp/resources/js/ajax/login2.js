$(function () {
  $('#frmLogin2').on('submit', function (event) {
    event.preventDefault();

    const user_id = $('#user_id').val();
    const user_pw = $('#user_pw').val();

    $.ajax({
      type: 'post',
      url: "/SpringMvcMyBatis/ajax/login",
      data: {
        "id": user_id,
        "pw": user_pw
      },
      dataType: 'text',
      success: function (response) {
        if (response === 'success') {
          alert('Login successful!\nRedirecting to the product list page.');
          window.location.href = '/SpringMvcMyBatis/product/listAllProduct';
        } else {
          alert('Login failed: ' + response);
        }
      },
      error: function (_data) {
        alert('An error occurred while processing your request.');
      },
      complete: function () {
        alert('Login successful!');
      }
    })
  })
});