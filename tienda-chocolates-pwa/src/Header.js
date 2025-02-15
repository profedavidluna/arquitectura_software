import React from 'react';

function Header({ onOpenSidebar, children }) {
  return (
    <header>
      <button onClick={onOpenSidebar}>Abrir menú</button>
      <h1>Mi Tienda PWA</h1>
      {children} {/* Aquí se renderiza el botón de instalación */}
    </header>
  );
}

export default Header;