import React from 'react';
import { Link } from 'react-router-dom';

const LoginPage = () => {
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
                    <h1 className="text-text-main text-[28px] font-extrabold tracking-tight leading-tight mb-2">Welcome back</h1>
                    <p className="text-text-secondary text-sm font-medium leading-relaxed">
                        Enter your credentials to access your personal learning dashboard.
                    </p>
                </div>

                {/* Form Section */}
                <div className="px-8 py-6 flex flex-col gap-5">
                    {/* Email Field */}
                    <div className="flex flex-col gap-1.5 group">
                        <label className="text-text-main text-sm font-semibold ml-0.5" htmlFor="email">Email</label>
                        <div className="relative flex items-center">
                            <span className="absolute left-3.5 text-gray-400 material-symbols-outlined text-[20px] pointer-events-none group-focus-within:text-primary transition-colors">mail</span>
                            <input
                                className="form-input block w-full rounded-lg border-gray-200 bg-gray-50/30 text-text-main text-sm pl-10 pr-4 py-3 focus:border-primary focus:ring focus:ring-primary/20 focus:bg-white transition-all duration-200 placeholder:text-gray-400"
                                id="email"
                                placeholder="name@company.com"
                                type="email"
                            />
                        </div>
                    </div>

                    {/* Password Field */}
                    <div className="flex flex-col gap-1.5 group">
                        <div className="flex justify-between items-center ml-0.5">
                            <label className="text-text-main text-sm font-semibold" htmlFor="password">Password</label>
                            <a className="text-xs font-semibold text-primary hover:text-primary-hover transition-colors" href="#">Forgot password?</a>
                        </div>
                        <div className="relative flex items-center">
                            <span className="absolute left-3.5 text-gray-400 material-symbols-outlined text-[20px] pointer-events-none group-focus-within:text-primary transition-colors">lock</span>
                            <input
                                className="form-input block w-full rounded-lg border-gray-200 bg-gray-50/30 text-text-main text-sm pl-10 pr-10 py-3 focus:border-primary focus:ring focus:ring-primary/20 focus:bg-white transition-all duration-200 placeholder:text-gray-400"
                                id="password"
                                placeholder="••••••••"
                                type="password"
                            />
                            <button className="absolute right-3.5 text-gray-400 hover:text-gray-600 focus:outline-none flex items-center justify-center transition-colors" type="button">
                                <span className="material-symbols-outlined text-[20px]">visibility</span>
                            </button>
                        </div>
                    </div>

                    {/* Login Button */}
                    <Link to="/student/dashboard" className="w-full bg-primary hover:bg-primary-hover text-white font-bold text-sm py-3.5 rounded-lg shadow-[0_2px_10px_rgba(234,119,11,0.2)] hover:shadow-[0_4px_12px_rgba(234,119,11,0.3)] active:scale-[0.99] transition-all duration-200 flex justify-center items-center gap-2 mt-2">
                        <span>Log In</span>
                        <span className="material-symbols-outlined text-[18px]">arrow_forward</span>
                    </Link>

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
                </div>

                {/* Footer Section */}
                <div className="bg-gray-50/50 px-8 py-5 border-t border-gray-100 flex justify-center items-center">
                    <p className="text-text-secondary text-sm">
                        Don't have an account?
                        <a className="text-primary font-bold ml-1 hover:underline decoration-2 underline-offset-2" href="#">Sign up for free</a>
                    </p>
                </div>
            </div>

            {/* Footer Links / Legal (Optional context specific) */}
            <div className="absolute bottom-4 left-0 right-0 flex justify-center gap-6 text-xs text-gray-400">
                <a className="hover:text-gray-600 transition-colors" href="#">Privacy Policy</a>
                <a className="hover:text-gray-600 transition-colors" href="#">Terms of Service</a>
                <a className="hover:text-gray-600 transition-colors" href="#">Help Center</a>
            </div>
        </div>
    );
};

export default LoginPage;
