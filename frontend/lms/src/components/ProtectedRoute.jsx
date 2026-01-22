import { Navigate, Outlet, useLocation } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const ProtectedRoute = ({ allowedRoles }) => {
    const { user, loading } = useAuth();
    const location = useLocation();

    if (loading) return <div>Loading...</div>; // Prevent redirect while checking token

    if (!user) {
        // Redirect to login but save the current location to return after login
        return <Navigate to="/login" state={{ from: location }} replace />;
    }

    // Check if the user's role (from your Backend UserResponse) is in allowedRoles
    return allowedRoles.includes(user.role) 
        ? <Outlet /> 
        : <Navigate to="/unauthorized" replace />;
};

export default ProtectedRoute;