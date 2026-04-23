import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

function Welcome() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('/')
      .then(response => response.text())
      .then(data => setMessage(data))
      .catch(error => console.error('Error fetching hello:', error));
  }, []);

  return (
    <div>
      <h1>Welcome</h1>
      <p>{message}</p>
      <Link to="/day-of-week">
        <button>Go to Day of Week</button>
      </Link>
    </div>
  );
}

export default Welcome;