import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [orders, setOrders] = useState([]);
  const [payments, setPayments] = useState([]);
  const [deliveries, setDeliveries] = useState([]);
  const [activeTab, setActiveTab] = useState('orders');

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const ordersRes = await axios.get('http://localhost:8081/api/orders');
      const paymentsRes = await axios.get('http://localhost:8082/api/payments');
      const deliveriesRes = await axios.get('http://localhost:8083/api/deliveries');
      
      setOrders(ordersRes.data);
      setPayments(paymentsRes.data);
      setDeliveries(deliveriesRes.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
    <div className="app">
      <header className="header">
        <h1> Online Food Delivery</h1>
        <p>Service-Based Architecture Demo</p>
      </header>

      <nav className="nav">
        <button 
          className={`nav-btn ${activeTab === 'orders' ? 'active' : ''}`}
          onClick={() => setActiveTab('orders')}
        >
           Orders ({orders.length})
        </button>
        <button 
          className={`nav-btn ${activeTab === 'payments' ? 'active' : ''}`}
          onClick={() => setActiveTab('payments')}
        >
           Payments ({payments.length})
        </button>
        <button 
          className={`nav-btn ${activeTab === 'deliveries' ? 'active' : ''}`}
          onClick={() => setActiveTab('deliveries')}
        >
           Deliveries ({deliveries.length})
        </button>
      </nav>

      <main className="main-content">
        {activeTab === 'orders' && (
          <section className="section">
            <h2>Order Service (Port 8081)</h2>
            <div className="cards">
              {orders.map((order) => (
                <div key={order.id} className="card">
                  <h3>{order.restaurantName}</h3>
                  <p><strong>Items:</strong> {order.items}</p>
                  <p><strong>Price:</strong> ${order.totalPrice}</p>
                  <p><strong>Status:</strong> <span className={`status ${order.status.toLowerCase()}`}>{order.status}</span></p>
                  <p><small>{order.createdAt}</small></p>
                </div>
              ))}
            </div>
          </section>
        )}

        {activeTab === 'payments' && (
          <section className="section">
            <h2>Payment Service (Port 8082)</h2>
            <div className="cards">
              {payments.map((payment) => (
                <div key={payment.id} className="card">
                  <h3>Order #{payment.orderId}</h3>
                  <p><strong>Amount:</strong> ${payment.amount}</p>
                  <p><strong>Method:</strong> {payment.paymentMethod}</p>
                  <p><strong>Status:</strong> <span className={`status ${payment.status.toLowerCase()}`}>{payment.status}</span></p>
                  <p><small>TXN: {payment.transactionId}</small></p>
                </div>
              ))}
            </div>
          </section>
        )}

        {activeTab === 'deliveries' && (
          <section className="section">
            <h2>Delivery Service (Port 8083)</h2>
            <div className="cards">
              {deliveries.map((delivery) => (
                <div key={delivery.id} className="card">
                  <h3>Order #{delivery.orderId}</h3>
                  <p><strong>Driver:</strong> {delivery.driverName}</p>
                  <p><strong>Phone:</strong> {delivery.driverPhone}</p>
                  <p><strong>Address:</strong> {delivery.deliveryAddress}</p>
                  <p><strong>Status:</strong> <span className={`status ${delivery.status.toLowerCase()}`}>{delivery.status}</span></p>
                </div>
              ))}
            </div>
          </section>
        )}
      </main>

      <footer className="footer">
        <p>✨ Service-Based Architecture: Order + Payment + Delivery = Complete System</p>
      </footer>
    </div>
  );
}

export default App;
