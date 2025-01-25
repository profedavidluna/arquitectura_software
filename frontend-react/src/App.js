import React from 'react';
import CustomNavbar from './components/CustomNavBar';
import ProductList from './components/ProductList';
import { Container } from 'react-bootstrap';

function App() {
    return (
        <>
            <CustomNavbar />
            <Container className="mt-4">
                <h1 className="text-center mb-4">Lista de Productos</h1>
                <ProductList />
            </Container>
        </>
    );
}

export default App;
