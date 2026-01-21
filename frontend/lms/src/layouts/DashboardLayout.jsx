import React from 'react';
import { Outlet } from 'react-router-dom';
import Sidebar from '../components/Sidebar';
import TopNavbar from '../components/TopNavbar';

const DashboardLayout = () => {
    return (
        <div className="bg-background-light font-display text-text-main h-screen overflow-hidden flex selection:bg-primary/20 selection:text-primary">
            <Sidebar />
            <main className="flex-1 flex flex-col h-full min-w-0 overflow-hidden relative">
                <TopNavbar />
                <div className="flex-1 overflow-y-auto p-6 md:p-8 lg:px-12">
                    <Outlet />
                </div>
            </main>
        </div>
    );
};

export default DashboardLayout;
