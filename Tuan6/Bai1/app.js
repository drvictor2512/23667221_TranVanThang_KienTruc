const express = require('express');
const app = express();
const PORT = 5000;

app.get('/', (req, res) => {
  res.send('<h1>Demo App - Image Optimization Lab</h1><p>Node.js Container running successfully!</p>');
});

app.listen(PORT, '0.0.0.0', () => {
  console.log(`Server running on port ${PORT}`);
});
