SELECT p
  FROM product p
 WHERE ( :type = 'prdName'
   AND p.prdname LIKE concat(
   '%',
   :keyword,
   '%'
) )
    OR ( :type = 'prdCompany'
   AND p.prdcompany LIKE concat(
   '%',
   :keyword,
   '%'
) )