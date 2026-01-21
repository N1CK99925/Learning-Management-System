import React from 'react';

const StudentDashboard = () => {
    return (
        <div className="max-w-6xl mx-auto space-y-8">
            {/* Page Heading & Welcome */}
            <div className="flex flex-col md:flex-row md:items-end justify-between gap-4">
                <div>
                    <h2 className="text-3xl font-extrabold text-[#181411] tracking-tight">Welcome back, Alex! 👋</h2>
                    <p className="text-text-muted mt-2 text-lg">You've got 3 assignments due this week. Let's keep learning.</p>
                </div>
                <button className="hidden md:flex items-center gap-2 bg-primary hover:bg-primary/90 text-white px-5 py-2.5 rounded-lg font-bold text-sm shadow-lg shadow-primary/20 transition-all active:scale-95">
                    <span className="material-symbols-outlined text-[20px]">play_circle</span>
                    Resume Learning
                </button>
            </div>

            {/* Stats Row */}
            <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
                {/* Stat Card 1 */}
                <div className="bg-white p-6 rounded-2xl border border-[#f0ece9] shadow-soft flex items-center gap-5 hover:border-primary/30 transition-colors group">
                    <div className="size-14 rounded-xl bg-blue-50 text-blue-600 flex items-center justify-center group-hover:scale-110 transition-transform">
                        <span className="material-symbols-outlined icon-filled text-3xl">book_4</span>
                    </div>
                    <div>
                        <p className="text-text-muted text-sm font-medium">Active Courses</p>
                        <p className="text-3xl font-black text-[#181411]">3</p>
                    </div>
                </div>
                {/* Stat Card 2 */}
                <div className="bg-white p-6 rounded-2xl border border-[#f0ece9] shadow-soft flex items-center gap-5 hover:border-green-200 transition-colors group">
                    <div className="size-14 rounded-xl bg-green-50 text-green-600 flex items-center justify-center group-hover:scale-110 transition-transform">
                        <span className="material-symbols-outlined icon-filled text-3xl">check_circle</span>
                    </div>
                    <div>
                        <p className="text-text-muted text-sm font-medium">Completed</p>
                        <p className="text-3xl font-black text-[#181411]">12</p>
                    </div>
                </div>
                {/* Stat Card 3 */}
                <div className="bg-white p-6 rounded-2xl border border-[#f0ece9] shadow-soft flex items-center gap-5 hover:border-primary/30 transition-colors group">
                    <div className="size-14 rounded-xl bg-orange-50 text-primary flex items-center justify-center group-hover:scale-110 transition-transform">
                        <span className="material-symbols-outlined icon-filled text-3xl">trending_up</span>
                    </div>
                    <div>
                        <p className="text-text-muted text-sm font-medium">Average Score</p>
                        <p className="text-3xl font-black text-[#181411]">85%</p>
                    </div>
                </div>
            </div>

            {/* Recent Activity / Featured */}
            <section>
                <div className="flex items-center justify-between mb-5">
                    <h3 className="text-xl font-bold text-[#181411]">Pick up where you left off</h3>
                </div>
                <div className="bg-white rounded-2xl border border-[#f0ece9] shadow-soft overflow-hidden flex flex-col md:flex-row">
                    <div className="md:w-1/3 relative h-48 md:h-auto">
                        <img
                            className="absolute inset-0 w-full h-full object-cover"
                            data-alt="Close up of UI design wireframes on a desk with laptop"
                            src="https://lh3.googleusercontent.com/aida-public/AB6AXuDfQivTEcGbY1GpYf1Z2MkkCgSizigL0OQBaJjeAi5T8SpiErpicCRJDFhf4SdlqItcbdzASrSzKMdXptZia2C4XHrIn7KXR2-u1Jbhr1Y0SXFZlyXS84RkLFJTIKHx7VGKkC3n_DkXn0MYzE4paC2BFbx2rBG7U3iI4_dgnRTtnI1VCMrwUJnjuhX7y2bJ5duRbKaBQDs1GT6kYIAJl-wemPktDUKtEOrdbH8EuctbUcF3mSZwYBZ9jz4NApmHqFVvc3-95og30wS4"
                        />
                        <div className="absolute inset-0 bg-gradient-to-t from-black/60 to-transparent md:bg-gradient-to-r"></div>
                        <span className="absolute top-4 left-4 bg-white/90 backdrop-blur text-xs font-bold px-2 py-1 rounded text-[#181411] shadow-sm">
                            LAST ACCESSED
                        </span>
                    </div>
                    <div className="p-6 md:p-8 flex-1 flex flex-col justify-center">
                        <div className="flex items-start justify-between">
                            <div>
                                <p className="text-primary font-bold text-xs tracking-wider uppercase mb-1">Design</p>
                                <h4 className="text-2xl font-bold text-[#181411] mb-2">Advanced UX Design Principles</h4>
                                <p className="text-text-muted text-sm mb-6 max-w-lg">Master the art of user-centric design with advanced prototyping and research methodologies.</p>
                            </div>
                            <div className="hidden lg:block text-right">
                                <p className="text-xs text-text-muted font-bold">INSTRUCTOR</p>
                                <p className="text-sm font-medium text-[#181411]">Sarah Jenkins</p>
                            </div>
                        </div>
                        <div className="flex flex-col gap-2">
                            <div className="flex justify-between text-xs font-bold text-text-muted">
                                <span>PROGRESS</span>
                                <span className="text-primary">75%</span>
                            </div>
                            <div className="w-full bg-[#f0ece9] rounded-full h-2">
                                <div className="bg-primary h-2 rounded-full relative" style={{ width: '75%' }}>
                                    <div className="absolute right-0 top-1/2 -translate-y-1/2 size-3 bg-white border-2 border-primary rounded-full shadow"></div>
                                </div>
                            </div>
                        </div>
                        <div className="mt-6 flex items-center gap-4">
                            <button className="bg-primary hover:bg-[#d66a06] text-white px-6 py-2.5 rounded-lg font-bold text-sm shadow-md transition-colors">
                                Continue Learning
                            </button>
                            <button className="text-text-muted hover:text-[#181411] font-bold text-sm px-4 py-2 rounded-lg hover:bg-gray-50 transition-colors">
                                View Syllabus
                            </button>
                        </div>
                    </div>
                </div>
            </section>

            {/* Enrolled Courses Grid */}
            <section>
                <div className="flex items-center justify-between mb-5">
                    <h3 className="text-xl font-bold text-[#181411]">Enrolled Courses</h3>
                    <a className="text-primary text-sm font-bold hover:underline" href="#">View All</a>
                </div>
                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
                    {/* Course Card 1 */}
                    <div className="bg-white rounded-xl border border-[#f0ece9] shadow-sm hover:shadow-lg hover:-translate-y-1 transition-all duration-300 flex flex-col group overflow-hidden">
                        <div className="relative h-44 w-full overflow-hidden">
                            <img
                                className="w-full h-full object-cover transition-transform duration-500 group-hover:scale-105"
                                data-alt="Abstract code on a computer screen representing Python programming"
                                src="https://lh3.googleusercontent.com/aida-public/AB6AXuCRGBpZb1B7NkulOYZmgObHRUQ2QcGuHsF4y6KU2PHRx0NNHdxvyJIhRfX08lUIksabiQv-D2M5YUpkBdydMIjL_mE3kGUAxk1JiEC-cFbBKvAypWk4zfr93qCB5KBhPeebCULRNjuj0cYBV0ahMyduXZgjHAA4Cg8NmY65UTIALsjcLxzin94-pv8vkWqC6DmptWviEVaAaGero_EL43gnOobiiCrTwNYZZNOZD7oJeGTD4rw-qpaQl0vKLwMtcSy3Qx2EMLfiGLH" />
                            <div className="absolute top-3 right-3 bg-white/90 backdrop-blur px-2.5 py-1 rounded-md shadow-sm">
                                <span className="text-[10px] font-bold text-teal-600 uppercase tracking-wide">Active</span>
                            </div>
                        </div>
                        <div className="p-5 flex-1 flex flex-col">
                            <div className="flex-1">
                                <p className="text-xs font-bold text-text-muted mb-1">DATA SCIENCE</p>
                                <h4 className="text-lg font-bold text-[#181411] leading-tight mb-2 group-hover:text-primary transition-colors">Python for Data Analysis</h4>
                                <div className="flex items-center gap-2 text-xs text-text-muted mb-4">
                                    <div className="size-6 rounded-full bg-gray-200 overflow-hidden">
                                        <img className="w-full h-full object-cover" data-alt="Instructor portrait" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDjdvTORtAEORVFy0--Lmw92m970vPY67FCvcg3_Lu5FgditTLiNZedEmmdMU647HuhQhTYQxJCKKXUra4QTw_knxuGXWiaKajsC8jKgQ8Rb8pMMqeVmpMIq3VKJXVmnP7cbHTxE5k-Y8qn5cAjky6wYaSuWLdnY88hseIkbSa1LdEINksMBdpLEmvzLWGVKc1QKgGRS7klplZvnNHsqmE0LGtS9L8k6uFZkX216XlJCLY0NfbV0geyEwbn492ha4QFJf965me4c_K2" />
                                    </div>
                                    <span>Dr. Alan Grant</span>
                                </div>
                            </div>
                            <div className="mt-4 pt-4 border-t border-[#f0ece9]">
                                <div className="flex justify-between items-end mb-2">
                                    <span className="text-xs font-semibold text-text-muted">32% Complete</span>
                                </div>
                                <div className="w-full bg-[#f0ece9] rounded-full h-1.5 overflow-hidden">
                                    <div className="bg-primary h-full rounded-full" style={{ width: '32%' }}></div>
                                </div>
                                <button className="w-full mt-4 py-2 border border-[#e6e0db] rounded-lg text-sm font-bold text-[#181411] hover:bg-gray-50 hover:border-gray-300 transition-colors">
                                    Continue
                                </button>
                            </div>
                        </div>
                    </div>

                    {/* Course Card 2 */}
                    <div className="bg-white rounded-xl border border-[#f0ece9] shadow-sm hover:shadow-lg hover:-translate-y-1 transition-all duration-300 flex flex-col group overflow-hidden">
                        <div className="relative h-44 w-full overflow-hidden">
                            <img
                                className="w-full h-full object-cover transition-transform duration-500 group-hover:scale-105"
                                data-alt="Team meeting brainstorming session with colorful sticky notes"
                                src="https://lh3.googleusercontent.com/aida-public/AB6AXuCdRMisqHNa2ZByQlFLeGoChATJivdUvzWw6q3IYeuywzhJV7z_Rbe0WDgWpCDzrt3oMucA-zY3dXOxKjrds6cA6Vk3XYfUCZ-kvHx-Qh9_qWCjbPdPoCxHg_qm9BylIGkjrVuoEaVYDSilkC7fJBgBCW-yhEjbyM2EduSeFkPDCBZpgAkYv3dYk2oqK1JuC5CV6Z_v7G8JQROOVqBThHoizaDMKFktU88x1Xbc__v1GUAzK8Ww2-LyVhzNkZeNCYAcwPuHeTiH83O2"
                            />
                            <div className="absolute top-3 right-3 bg-green-50 px-2.5 py-1 rounded-md shadow-sm border border-green-100">
                                <span className="text-[10px] font-bold text-green-700 uppercase tracking-wide flex items-center gap-1">
                                    <span className="material-symbols-outlined text-[10px]">check</span> Completed
                                </span>
                            </div>
                        </div>
                        <div className="p-5 flex-1 flex flex-col">
                            <div className="flex-1">
                                <p className="text-xs font-bold text-text-muted mb-1">BUSINESS</p>
                                <h4 className="text-lg font-bold text-[#181411] leading-tight mb-2 group-hover:text-primary transition-colors">Project Management Essentials</h4>
                                <div className="flex items-center gap-2 text-xs text-text-muted mb-4">
                                    <div className="size-6 rounded-full bg-gray-200 overflow-hidden">
                                        <img className="w-full h-full object-cover" data-alt="Instructor portrait" src="https://lh3.googleusercontent.com/aida-public/AB6AXuAfmfqt1qFpHs5ABJz61rrcvUeCL88Wy15KDArS1TiBwDtbJ-kdEhEI2I8r508uCAjukyn_REDq4N7cuR2drsm_1znkx5t-BCZtiaK2yJWXrchditdhrQ6fntaSvYfLiY5jyOb4mD0fOSKnvraVwV53oUCrY-HYeatlyJswZA60YIi51TXGlSwDHdTwEWzy-LGEi5AzXeWPDAHOVKZh1yObikAFBWnlBGve9MaCpftAJb_TZjMkUHE0yLuvuNCxrmqYO-dVgGi_AgVt" />
                                    </div>
                                    <span>Elena Fisher</span>
                                </div>
                            </div>
                            <div className="mt-4 pt-4 border-t border-[#f0ece9]">
                                <div className="flex justify-between items-end mb-2">
                                    <span className="text-xs font-semibold text-green-600">Grade: 94%</span>
                                </div>
                                <div className="w-full bg-[#f0ece9] rounded-full h-1.5 overflow-hidden">
                                    <div className="bg-green-500 h-full rounded-full" style={{ width: '100%' }}></div>
                                </div>
                                <button className="w-full mt-4 py-2 border border-[#e6e0db] rounded-lg text-sm font-bold text-primary hover:bg-primary/5 hover:border-primary/20 transition-colors">
                                    View Certificate
                                </button>
                            </div>
                        </div>
                    </div>

                    {/* Course Card 3 */}
                    <div className="bg-white rounded-xl border border-[#f0ece9] shadow-sm hover:shadow-lg hover:-translate-y-1 transition-all duration-300 flex flex-col group overflow-hidden">
                        <div className="relative h-44 w-full overflow-hidden">
                            <img
                                className="w-full h-full object-cover transition-transform duration-500 group-hover:scale-105"
                                data-alt="Close up of financial charts and graphs on a laptop screen"
                                src="https://lh3.googleusercontent.com/aida-public/AB6AXuCMZpcQuhbE0GFiyZyo-aKPi2PUamqemTh4cSDCgbcpnOeOPIK7C9q8aZdEjTJ4VGBTT5J3OWc1MafJug7IfboJ5Zt09ywrGwmrSooZQqvqFZRfX7khDuRCzjcbibjM76Lgyfd8F2IBaszV4RnTaA1UwRa95i3-pmULSFb0Yqbi9NygILVhGZOgtzXo7StU7YPouPeC3o4pfltPRuE0YDZhS-PI-DfrgU0c1ttfz9tthF--JeML5vQgRZz9AUsjYacnhoDOtzxf9N-0"
                            />
                            <div className="absolute top-3 right-3 bg-white/90 backdrop-blur px-2.5 py-1 rounded-md shadow-sm">
                                <span className="text-[10px] font-bold text-teal-600 uppercase tracking-wide">Active</span>
                            </div>
                        </div>
                        <div className="p-5 flex-1 flex flex-col">
                            <div className="flex-1">
                                <p className="text-xs font-bold text-text-muted mb-1">MARKETING</p>
                                <h4 className="text-lg font-bold text-[#181411] leading-tight mb-2 group-hover:text-primary transition-colors">Digital Marketing 101</h4>
                                <div className="flex items-center gap-2 text-xs text-text-muted mb-4">
                                    <div className="size-6 rounded-full bg-gray-200 overflow-hidden">
                                        <img className="w-full h-full object-cover" data-alt="Instructor portrait" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDJEZ66xmFT2fDA6e9aO32Tp1guKi-I7nZT2WAPgzcofR11-9qqVCb8hSwDgrZzjlCEg_hXiniXX3LV_mLnSE92acl0ewsQvtb3wcK2XirEXnEiwwM_4Y9Erv8PTKvWzASMUeSWrRo2TUtylriS1UdCTinRNrqu8Xvb_-X4RdnzpBTZAHqCUXgLpuqp83teCBj_29FHFq0qCx6mbE33wJJScBL45RQlR4awz9fzg9nMHUJ9Ct8VzpTqbTASVAZt7ht5eMySl7N9N9ba" />
                                    </div>
                                    <span>Marcus Chen</span>
                                </div>
                            </div>
                            <div className="mt-4 pt-4 border-t border-[#f0ece9]">
                                <div className="flex justify-between items-end mb-2">
                                    <span className="text-xs font-semibold text-text-muted">10% Complete</span>
                                </div>
                                <div className="w-full bg-[#f0ece9] rounded-full h-1.5 overflow-hidden">
                                    <div className="bg-primary h-full rounded-full" style={{ width: '10%' }}></div>
                                </div>
                                <button className="w-full mt-4 py-2 border border-[#e6e0db] rounded-lg text-sm font-bold text-[#181411] hover:bg-gray-50 hover:border-gray-300 transition-colors">
                                    Start
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <footer className="py-8 text-center text-xs text-text-muted">
                <p>© 2023 LMS Platform. All rights reserved.</p>
            </footer>
        </div>
    );
};

export default StudentDashboard;
