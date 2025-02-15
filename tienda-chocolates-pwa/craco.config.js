// craco.config.js
const { GenerateSW } = require('workbox-webpack-plugin');

module.exports = {
  webpack: {
    plugins: [
      new GenerateSW({
        swDest: 'service-worker.js', // Nombre del archivo generado
      }),
    ],
  },
};