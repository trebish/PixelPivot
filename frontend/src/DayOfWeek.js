import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function DayOfWeek() {
  const [date, setDate] = useState('');
  const [day, setDay] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!date) {
      setError('Please enter a date');
      return;
    }
    fetch(`/day-of-week?date=${date}`)
      .then(response => response.text())
      .then(data => {
        setDay(data);
        setError('');
      })
      .catch(error => {
        console.error('Error fetching day:', error);
        setError('Error fetching day');
      });
  };

  return (
    <div>
      <h1>Day of the Week</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Enter date (YYYY-MM-DD):
          <input
            type="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
          />
        </label>
        <button type="submit">Get Day</button>
      </form>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {day && <p>The day is: {day}</p>}
      <Link to="/">
        <button>Back to Welcome</button>
      </Link>
    </div>
  );
}

export default DayOfWeek;