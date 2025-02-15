import React from 'react';
import './Sidebar.css';

function Sidebar({ isOpen, onClose }) {
  return (
    <div className={`sidebar ${isOpen ? 'open' : ''}`}>
      <button className="close-btn" onClick={onClose}>
        &times;
      </button>
      <h2>Menú</h2>
      <ul>
        <li>Inicio</li>
        <li>Productos</li>
        <li>Carrito</li>
        <li>Contacto</li>
      </ul>
    </div>
  );
}

export default Sidebar;