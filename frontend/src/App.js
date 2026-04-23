import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Welcome from './Welcome';
import DayOfWeek from './DayOfWeek';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Welcome />} />
          <Route path="/day-of-week" element={<DayOfWeek />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
