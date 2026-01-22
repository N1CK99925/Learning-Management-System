// src/context/AuthContext.jsx
import { createContext, useContext, useState, useEffect } from 'react';
import api from '../api/axios';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  // Validate session on refresh
  useEffect(() => {
    const checkAuth = async () => {
      const token = localStorage.getItem('token');
      if (token) {
        try {
          const res = await api.get('/auth/me'); // Using your /me endpoint
          setUser(res.data);
        } catch (err) {
          localStorage.removeItem('token');
          return err;
        }
      }
      setLoading(false);
    };
    checkAuth();
  }, []);

  const login = async (email, password) => {
    const res = await api.post('/auth/login', { email, password });
    localStorage.setItem('token', res.data.token);
    setUser(res.data.user); // Store the UserResponse object (id, email, username, role)
    return res.data.user;
  };

  const logout = () => {
    localStorage.removeItem('token');
    setUser(null);
  };

  // In your AuthContext
  const register = async (username, email, password) => {
    try {
      const res = await api.post('/auth/register', { 
        username, 
        email, 
        password 
      });
      
      // The backend returns a UserResponse object
      // You can optionally auto-login after registration
      // or just return the data and redirect to login
      return res.data;
    } catch (error) {
      // Handle backend validation errors
      if (error.response?.data) {
        // Backend returns field-specific errors for validation
        const errorData = error.response.data;
        
        // If it's a validation error with multiple fields
          if (typeof errorData === 'object') {
    if (errorData.errors) {
      const errorMessage = Object.values(errorData.errors).join(', ');
      throw new Error(errorMessage);
    }

    if (errorData.message) {
      throw new Error(errorData.message);
    }
  }

        
        // If it's a single error message
        throw new Error(errorData.error || 'Registration failed');
      }
      
      throw new Error(error.message || 'Registration failed');
    }
  };


  return (
    <AuthContext.Provider value={{ user, login, logout,register, loading }}>
      {!loading && children}
    </AuthContext.Provider>
  );
};

// eslint-disable-next-line react-refresh/only-export-components
export const useAuth = () => useContext(AuthContext);