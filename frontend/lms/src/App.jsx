import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext'; // You need to create this
import LandingPage from './pages/LandingPage';
import LoginPage from './pages/LoginPage';
import ProtectedRoute from './components/ProtectedRoute';
import DashboardLayout from './layouts/DashboardLayout';
import StudentDashboard from './pages/StudentDashboard';
import CourseCatalog from './pages/CourseCatalog';

function App() {
  return (
    <AuthProvider>
      <Router>
        <Routes>
          {/* Public Routes */}
          <Route path="/" element={<LandingPage />} />
          <Route path="/login" element={<LoginPage />} />

          {/* Protected Student Routes */}
          {/* We wrap the routes in ProtectedRoute and pass the required role */}
          <Route element={<ProtectedRoute allowedRoles={['STUDENT']} />}>
            <Route path="/student" element={<DashboardLayout />}>
              <Route path="dashboard" element={<StudentDashboard />} />
              <Route path="courses" element={<CourseCatalog />} />
              <Route path="enrollments" element={<div className="p-4">Enrollments (Coming Soon)</div>} />
              <Route path="achievements" element={<div className="p-4">Achievements (Coming Soon)</div>} />
              <Route path="settings" element={<div className="p-4">Settings (Coming Soon)</div>} />
              <Route path="help" element={<div className="p-4">Help (Coming Soon)</div>} />
            </Route>
          </Route>

          {/* Catch-all: Redirect unknown routes to login or landing */}
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;