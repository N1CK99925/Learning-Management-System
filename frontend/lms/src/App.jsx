import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LandingPage from './pages/LandingPage';
import LoginPage from './pages/LoginPage';

import DashboardLayout from './layouts/DashboardLayout';
import StudentDashboard from './pages/StudentDashboard';
import CourseCatalog from './pages/CourseCatalog';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/login" element={<LoginPage />} />

        {/* Student Dashboard Routes */}
        <Route path="/student" element={<DashboardLayout />}>
          <Route path="dashboard" element={<StudentDashboard />} />
          <Route path="courses" element={<CourseCatalog />} />
          <Route path="enrollments" element={<div className="p-4">Enrollments Content (Coming Soon)</div>} />
          <Route path="achievements" element={<div className="p-4">Achievements Content (Coming Soon)</div>} />
          <Route path="settings" element={<div className="p-4">Settings Content (Coming Soon)</div>} />
          <Route path="help" element={<div className="p-4">Help Content (Coming Soon)</div>} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
