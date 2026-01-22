import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from "../context/AuthContext";

const RegisterPage = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [error, setError] = useState(null);
    const [validationErrors, setValidationErrors] = useState({});
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);

    const { register } = useAuth();
    const navigate = useNavigate();

    const validateForm = () => {
        const errors = {};
        
        if (!username.trim()) {
            errors.username = "Username is required";
        }
        
        if (!email.trim()) {
            errors.email = "Email is required";
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            errors.email = "Invalid email format";
        }
        
        if (!password) {
            errors.password = "Password is required";
        } else if (password.length < 6) {
            errors.password = "Password must be at least 6 characters";
        }
        
        if (!confirmPassword) {
            errors.confirmPassword = "Please confirm your password";
        } else if (password !== confirmPassword) {
            errors.confirmPassword = "Passwords do not match";
        }
        
        setValidationErrors(errors);
        return Object.keys(errors).length === 0;
    };

    const handleRegister = async () => {
        setError(null);
        setValidationErrors({});
        
        if (!validateForm()) {
            return;
        }

        console.log("Attempting registration with:", { username, email });
        
        try {
            await register(username, email, password);
            // After successful registration, redirect to login or dashboard
            navigate("/login");
        } catch (err) {
            setError(err.message || "Registration failed. Please try again.");
        }
    };

    return (
        <div className="bg-[#f9fafa] min-h-screen flex flex-col justify-center items-center p-4 relative overflow-hidden font-sans text-text-main">
            {/* Subtle Abstract Background Pattern */}
            <div className="absolute inset-0 opacity-[0.4] pointer-events-none overflow-hidden z-0">
                <div className="absolute -top-[20%] -right-[10%] w-[600px] h-[600px] bg-gradient-to-br from-orange-100/40 to-transparent rounded-full blur-3xl"></div>
                <div className="absolute top-[40%] -left-[10%] w-[500px] h-[500px] bg-gradient-to-tr from-gray-200/50 to-transparent rounded-full blur-3xl"></div>
            </div>

            {/* Main Card Container */}
            <div className="relative w-full max-w-[440px] bg-white rounded-xl shadow-soft z-10 flex flex-col overflow-hidden transition-all duration-300 hover:shadow-[0_8px_30px_rgba(0,0,0,0.06)]">
                {/* Header Section */}
                <div className="px-8 pt-10 pb-2 text-center">
                    {/* Logo Placeholder */}
                    <div className="flex justify-center mb-6">
                        <Link to="/" className="w-12 h-12 bg-primary/10 rounded-lg flex items-center justify-center text-primary cursor-pointer hover:bg-primary/20 transition-colors">
                            <span className="material-symbols-outlined text-3xl">school</span>
                        </Link>
                    </div>
                    <h1 className="text-text-main text-[28px] font-extrabold tracking-tight leading-tight mb-2">Create your account</h1>
                    <p className="text-text-secondary text-sm font-medium leading-relaxed">
                        Join our learning community and start your educational journey today.
                    </p>
                </div>

                {/* Form Section */}
                <div className="px-8 py-6 flex flex-col gap-5">
                    {/* Username Field */}
                    <div className="flex flex-col gap-1.5 group">
                        <label className="text-text-main text-sm font-semibold ml-0.5" htmlFor="username">Username</label>
                        <div className="relative flex items-center">
                            <span className="absolute left-3.5 text-gray-400 material-symbols-outlined text-[20px] pointer-events-none group-focus-within:text-primary transition-colors">person</span>
                            <input
                                className={`form-input block w-full rounded-lg border-gray-200 bg-gray-50/30 text-text-main text-sm pl-10 pr-4 py-3 focus:border-primary focus:ring focus:ring-primary/20 focus:bg-white transition-all duration-200 placeholder:text-gray-400 ${validationErrors.username ? 'border-red-300 focus:border-red-500 focus:ring-red-200' : ''}`}
                                id="username"
                                value={username}
                                placeholder="Enter your username"
                                type="text"
                                onChange={(e) => setUsername(e.target.value)}
                            />
                        </div>
                        {validationErrors.username && <p className="text-red-500 text-xs ml-0.5">{validationErrors.username}</p>}
                    </div>

                    {/* Email Field */}
                    <div className="flex flex-col gap-1.5 group">
                        <label className="text-text-main text-sm font-semibold ml-0.5" htmlFor="email">Email</label>
                        <div className="relative flex items-center">
                            <span className="absolute left-3.5 text-gray-400 material-symbols-outlined text-[20px] pointer-events-none group-focus-within:text-primary transition-colors">mail</span>
                            <input
                                className={`form-input block w-full rounded-lg border-gray-200 bg-gray-50/30 text-text-main text-sm pl-10 pr-4 py-3 focus:border-primary focus:ring focus:ring-primary/20 focus:bg-white transition-all duration-200 placeholder:text-gray-400 ${validationErrors.email ? 'border-red-300 focus:border-red-500 focus:ring-red-200' : ''}`}
                                id="email"
                                value={email}
                                placeholder="name@company.com"
                                type="email"
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </div>
                        {validationErrors.email && <p className="text-red-500 text-xs ml-0.5">{validationErrors.email}</p>}
                    </div>

                    {/* Password Field */}
                    <div className="flex flex-col gap-1.5 group">
                        <label className="text-text-main text-sm font-semibold ml-0.5" htmlFor="password">Password</label>
                        <div className="relative flex items-center">
                            <span className="absolute left-3.5 text-gray-400 material-symbols-outlined text-[20px] pointer-events-none group-focus-within:text-primary transition-colors">lock</span>
                            <input
                                className={`form-input block w-full rounded-lg border-gray-200 bg-gray-50/30 text-text-main text-sm pl-10 pr-10 py-3 focus:border-primary focus:ring focus:ring-primary/20 focus:bg-white transition-all duration-200 placeholder:text-gray-400 ${validationErrors.password ? 'border-red-300 focus:border-red-500 focus:ring-red-200' : ''}`}
                                id="password"
                                placeholder="••••••••"
                                type={showPassword ? "text" : "password"}
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                            <button 
                                className="absolute right-3.5 text-gray-400 hover:text-gray-600 focus:outline-none flex items-center justify-center transition-colors" 
                                type="button"
                                onClick={() => setShowPassword(!showPassword)}
                            >
                                <span className="material-symbols-outlined text-[20px]">
                                    {showPassword ? 'visibility_off' : 'visibility'}
                                </span>
                            </button>
                        </div>
                        {validationErrors.password && <p className="text-red-500 text-xs ml-0.5">{validationErrors.password}</p>}
                    </div>

                    {/* Confirm Password Field */}
                    <div className="flex flex-col gap-1.5 group">
                        <label className="text-text-main text-sm font-semibold ml-0.5" htmlFor="confirmPassword">Confirm Password</label>
                        <div className="relative flex items-center">
                            <span className="absolute left-3.5 text-gray-400 material-symbols-outlined text-[20px] pointer-events-none group-focus-within:text-primary transition-colors">lock</span>
                            <input
                                className={`form-input block w-full rounded-lg border-gray-200 bg-gray-50/30 text-text-main text-sm pl-10 pr-10 py-3 focus:border-primary focus:ring focus:ring-primary/20 focus:bg-white transition-all duration-200 placeholder:text-gray-400 ${validationErrors.confirmPassword ? 'border-red-300 focus:border-red-500 focus:ring-red-200' : ''}`}
                                id="confirmPassword"
                                placeholder="••••••••"
                                type={showConfirmPassword ? "text" : "password"}
                                value={confirmPassword}
                                onChange={(e) => setConfirmPassword(e.target.value)}
                            />
                            <button 
                                className="absolute right-3.5 text-gray-400 hover:text-gray-600 focus:outline-none flex items-center justify-center transition-colors" 
                                type="button"
                                onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                            >
                                <span className="material-symbols-outlined text-[20px]">
                                    {showConfirmPassword ? 'visibility_off' : 'visibility'}
                                </span>
                            </button>
                        </div>
                        {validationErrors.confirmPassword && <p className="text-red-500 text-xs ml-0.5">{validationErrors.confirmPassword}</p>}
                    </div>

                    {error && (
                        <div className="bg-red-50 border border-red-200 text-red-700 px-4 py-3 rounded-lg text-sm">
                            {error}
                        </div>
                    )}

                    {/* Register Button */}
                    <button
                        onClick={handleRegister}
                        className="w-full bg-primary hover:bg-primary-hover text-white font-bold text-sm py-3.5 rounded-lg shadow-[0_2px_10px_rgba(234,119,11,0.2)] hover:shadow-[0_4px_12px_rgba(234,119,11,0.3)] active:scale-[0.99] transition-all duration-200 flex justify-center items-center gap-2 mt-2"
                    >
                        <span>Create Account</span>
                        <span className="material-symbols-outlined text-[18px]">arrow_forward</span>
                    </button>

                    {/* Divider */}
                    <div className="relative flex py-2 items-center">
                        <div className="flex-grow border-t border-gray-100"></div>
                        <span className="flex-shrink-0 mx-4 text-gray-400 text-xs font-medium uppercase tracking-wider">Or continue with</span>
                        <div className="flex-grow border-t border-gray-100"></div>
                    </div>

                    {/* Social Login / SSO */}
                    <div className="grid grid-cols-2 gap-3">
                        <button className="flex items-center justify-center gap-2 w-full bg-white border border-gray-200 hover:border-gray-300 hover:bg-gray-50 text-text-main font-semibold text-sm py-2.5 rounded-lg transition-all duration-200">
                            <svg className="w-5 h-5" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z" fill="#4285F4"></path>
                                <path d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z" fill="#34A853"></path>
                                <path d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z" fill="#FBBC05"></path>
                                <path d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z" fill="#EA4335"></path>
                            </svg>
                            <span>Google</span>
                        </button>
                        <button className="flex items-center justify-center gap-2 w-full bg-white border border-gray-200 hover:border-gray-300 hover:bg-gray-50 text-text-main font-semibold text-sm py-2.5 rounded-lg transition-all duration-200">
                            <span className="material-symbols-outlined text-[20px] text-gray-600">domain</span>
                            <span>SSO</span>
                        </button>
                    </div>

                    {/* Terms and Privacy */}
                    <p className="text-xs text-gray-500 text-center mt-2">
                        By creating an account, you agree to our{' '}
                        <a href="#" className="text-primary hover:underline">Terms of Service</a>
                        {' '}and{' '}
                        <a href="#" className="text-primary hover:underline">Privacy Policy</a>
                    </p>
                </div>

                {/* Footer Section */}
                <div className="bg-gray-50/50 px-8 py-5 border-t border-gray-100 flex justify-center items-center">
                    <p className="text-text-secondary text-sm">
                        Already have an account?
                        <Link to="/login" className="text-primary font-bold ml-1 hover:underline decoration-2 underline-offset-2">
                            Sign in
                        </Link>
                    </p>
                </div>
            </div>

            {/* Footer Links / Legal */}
            <div className="absolute bottom-4 left-0 right-0 flex justify-center gap-6 text-xs text-gray-400">
                <a className="hover:text-gray-600 transition-colors" href="#">Privacy Policy</a>
                <a className="hover:text-gray-600 transition-colors" href="#">Terms of Service</a>
                <a className="hover:text-gray-600 transition-colors" href="#">Help Center</a>
            </div>
        </div>
    );
};

export default RegisterPage;