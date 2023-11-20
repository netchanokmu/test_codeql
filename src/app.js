// src/app.js
const express = require('express');
const homeController = require('./controllers/homeController');

const app = express();
const port = 3000;

app.get('/', homeController);

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});