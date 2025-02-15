import React from 'react';
import Product from './Product';

const products = [
  {
    id: 1,
    name: 'Chocolate Negro',
    price: 5,
    image: '/th.jpeg',
  },
  {
    id: 2,
    name: 'Chocolate con Leche',
    price: 4,
    image: '/th2.jpeg',
  },
  {
    id: 3,
    name: 'Chocolate Blanco',
    price: 6,
    image: '/th3.jpeg',
  },
];

function ProductList() {
  return (
    <div className="product-list">
      {products.map(product => (
        <Product key={product.id} product={product} />
      ))}
    </div>
  );
}

export default ProductList;