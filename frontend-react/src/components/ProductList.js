import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Card, Button, Row, Col } from 'react-bootstrap';

const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/products')
      .then(response => setProducts(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <Row>
        {products.map(product => (
            <Col key={product.id} md={4} className="mb-4">
                <Card>
                    <Card.Body>
                        <Card.Title>{product.name}</Card.Title>
                        <Card.Text>Precio: ${product.price}</Card.Text>
                        <Button variant="primary">Comprar</Button>
                    </Card.Body>
                </Card>
            </Col>
        ))}
    </Row>
);
};

export default ProductList;