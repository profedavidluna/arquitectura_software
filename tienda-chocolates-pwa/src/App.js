import React, { useState, useEffect } from 'react';
import Sidebar from './Sidebar'; // Asegúrate de importar tus componentes
import Header from './Header';
import ProductList from './ProductList';
import Cart from './Cart';
import './App.css'; // Asegúrate de importar tus estilos

function App() {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);
  const [deferredPrompt, setDeferredPrompt] = useState(null);
  const [isAppInstalled, setIsAppInstalled] = useState(false);

  // Función para abrir el sidebar
  const openSidebar = () => {
    setIsSidebarOpen(true);
  };

  // Función para cerrar el sidebar
  const closeSidebar = () => {
    setIsSidebarOpen(false);
  };

  // Escuchar el evento beforeinstallprompt
  useEffect(() => {
    window.addEventListener('beforeinstallprompt', (e) => {
      e.preventDefault();
      setDeferredPrompt(e);
    });

    // Escuchar el evento appinstalled
    window.addEventListener('appinstalled', () => {
      setIsAppInstalled(true);
      console.log('PWA fue instalada');
    });
  }, []);

  // Función para manejar la instalación
  const handleInstallClick = () => {
    if (deferredPrompt) {
      deferredPrompt.prompt();
      deferredPrompt.userChoice.then((choiceResult) => {
        if (choiceResult.outcome === 'accepted') {
          console.log('El usuario aceptó instalar la PWA');
        } else {
          console.log('El usuario rechazó instalar la PWA');
        }
        setDeferredPrompt(null);
      });
    }
  };

  return (
    <div className="App">
      {/* Overlay del sidebar */}
      <div
        className={`sidebar-overlay ${isSidebarOpen ? 'open' : ''}`}
        onClick={closeSidebar}
      ></div>

      {/* Sidebar */}
      <Sidebar isOpen={isSidebarOpen} onClose={closeSidebar} />

      {/* Contenido principal */}
      <div className="content">
        {/* Header con el botón de instalación */}
        <Header onOpenSidebar={openSidebar}>
          {deferredPrompt && !isAppInstalled && (
            <button onClick={handleInstallClick} className="install-button">
              Instalar la aplicación
            </button>
          )}
        </Header>

        {/* Lista de productos y carrito */}
        <ProductList />
        <Cart />
      </div>
    </div>
  );
}

export default App;