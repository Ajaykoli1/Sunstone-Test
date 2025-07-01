
const products = {
  'apple': 1.2,
  'banana': 0.5,
  'orange': 0.8
};

function getProductPrice(productId) {
  return new Promise(function(resolve, reject) {
    setTimeout(function() {
      if (products.hasOwnProperty(productId)) {
        resolve(products[productId]);
      } else {
        reject("Product not found");
      }
    }, 1000); 
  });
}


getProductPrice('banana')
  .then(function(price) {
    console.log("Price:", price);
  })
  .catch(function(error) {
    console.log("Error:", error);
  });

getProductPrice('mango')
  .then(function(price) {
    console.log("Price:", price);
  })
  .catch(function(error) {
    console.log("Error:", error);
  });
