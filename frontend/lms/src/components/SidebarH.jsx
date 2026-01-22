import React from 'react';
import { NavLink } from 'react-router-dom';

const SidebarH = () => {
    return (
        <aside className="w-64 bg-white border-r border-[#f0ece9] flex-shrink-0 flex-col h-full z-20 hidden md:flex">
            <div className="p-6 pb-2">
                <div className="flex items-center gap-3">
                    <div className="size-8 rounded-lg bg-primary flex items-center justify-center text-white">
                        <span className="material-symbols-outlined">school</span>
                    </div>
                    <h1 className="text-xl font-bold tracking-tight text-[#181411]">LMS Platform</h1>
                </div>
            </div>
            <nav className="flex-1 overflow-y-auto px-4 py-6 flex flex-col gap-1">
                <p className="px-3 text-xs font-semibold text-text-muted uppercase tracking-wider mb-2">Menu</p>
                {/* Active State Logic handled by NavLink (className function) */}
                <NavLink
                    to="/student/dashboard"
                    className={({ isActive }) => `flex items-center gap-3 px-3 py-2.5 rounded-lg transition-all duration-200 ${isActive ? 'bg-primary/10 text-primary' : 'text-text-main hover:bg-[#f5f2f0] group'}`}
                >
                    <span className="material-symbols-outlined icon-filled">dashboard</span>
                    <span className="text-sm font-semibold">Dashboard</span>
                </NavLink>
                <NavLink
                    to="/student/courses"
                    className={({ isActive }) => `flex items-center gap-3 px-3 py-2.5 rounded-lg transition-all duration-200 ${isActive ? 'bg-primary/10 text-primary' : 'text-text-main hover:bg-[#f5f2f0] group'}`}
                >
                    <span className="material-symbols-outlined group-hover:text-primary transition-colors">book_2</span>
                    <span className="text-sm font-medium">Browse Courses</span>
                </NavLink>
                <NavLink
                    to="/student/enrollments"
                    className={({ isActive }) => `flex items-center gap-3 px-3 py-2.5 rounded-lg transition-all duration-200 ${isActive ? 'bg-primary/10 text-primary' : 'text-text-main hover:bg-[#f5f2f0] group'}`}
                >
                    <span className="material-symbols-outlined group-hover:text-primary transition-colors">school</span>
                    <span className="text-sm font-medium">My Enrollments</span>
                </NavLink>
                <NavLink
                    to="/student/achievements"
                    className={({ isActive }) => `flex items-center gap-3 px-3 py-2.5 rounded-lg transition-all duration-200 ${isActive ? 'bg-primary/10 text-primary' : 'text-text-main hover:bg-[#f5f2f0] group'}`}
                >
                    <span className="material-symbols-outlined group-hover:text-primary transition-colors">trophy</span>
                    <span className="text-sm font-medium">Achievements</span>
                </NavLink>
                <hr className="my-4 border-[#f0ece9]" />
                <p className="px-3 text-xs font-semibold text-text-muted uppercase tracking-wider mb-2">Account</p>
                <NavLink
                    to="/student/settings"
                    className={({ isActive }) => `flex items-center gap-3 px-3 py-2.5 rounded-lg transition-all duration-200 ${isActive ? 'bg-primary/10 text-primary' : 'text-text-main hover:bg-[#f5f2f0] group'}`}
                >
                    <span className="material-symbols-outlined group-hover:text-primary transition-colors">settings</span>
                    <span className="text-sm font-medium">Settings</span>
                </NavLink>
                <NavLink
                    to="/student/help"
                    className={({ isActive }) => `flex items-center gap-3 px-3 py-2.5 rounded-lg transition-all duration-200 ${isActive ? 'bg-primary/10 text-primary' : 'text-text-main hover:bg-[#f5f2f0] group'}`}
                >
                    <span className="material-symbols-outlined group-hover:text-primary transition-colors">help</span>
                    <span className="text-sm font-medium">Help Center</span>
                </NavLink>
            </nav>
            <div className="p-4 border-t border-[#f0ece9]">
                <button className="flex w-full items-center justify-center gap-2 rounded-lg py-2.5 px-4 bg-gray-50 hover:bg-gray-100 text-text-main text-sm font-bold border border-[#e6e0db] transition-colors">
                    <span className="material-symbols-outlined text-[18px]">logout</span>
                    Logout
                </button>
            </div>
        </aside>
    );
};

export default SidebarH;
