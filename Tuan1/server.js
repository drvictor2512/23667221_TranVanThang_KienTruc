const express = require('express');
const jwt = require('jsonwebtoken');
const app = express();

app.use(express.json());

//JWT
const SECRET = 'SECRET_KEY';
const users = [];
app.post('/register', (req, res) => {
    const { username, password } = req.body;
    users.push({ username, password });
    res.json({ message: 'User registered successfully' })
})
app.post('/login', (req, res) => {
    const { username, password } = req.body;
    const user = users.find(u => u.username === username && u.password === password);
    if (!user) {
        return res.status(401).json({ message: 'Invalid credentials' });
    }
    const token = jwt.sign({ username }, SECRET, { expiresIn: '1h' });
    res.json({ token });
})
const verifyToken = (req, res, next) => {
    const header = req.headers['authorization']
    if (!header) {
        return res.status(401).json({ message: 'No token provided' });
    }
    const token = header.split(' ')[1];
    jwt.verify(token, SECRET), (err, data) => {
        if (err) return res.status(401).json({ message: 'Invalid token' });
        req.user = data;
        next();
    }
}
app.get('/protected', verifyToken, (req, res) => {
    res.json({
        message: 'This is a protected route',
        user: req.user
    })
})

app.listen(3000, () => {
    console.log('Server is running on port 3000');
})
