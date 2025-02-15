import React from 'react';

function Product({ product }) {
  return (
    <div className="product">
      <img src={product.image} alt={product.name} className="product-image" />
      <h2>{product.name}</h2>
      <p>Precio: ${product.price}</p>
      <button>Agregar al carrito</button>
    </div>
  );
}

export default Product;