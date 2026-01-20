import React from 'react';

const CourseCatalog = () => {
    return (
        <div className="w-full max-w-[1240px] mx-auto">
            {/* Header Section */}
            <div className="flex flex-col gap-2 mb-10 animate-fade-in-up">
                <h1 className="text-text-main text-4xl md:text-5xl font-black tracking-tighter">Explore Courses</h1>
                <p className="text-text-secondary text-lg font-medium max-w-2xl">Expand your skills with our curated curriculum designed for modern professionals.</p>
            </div>

            {/* Search & Filter Controls */}
            <div className="bg-white p-4 rounded-xl shadow-sm border border-gray-100 flex flex-col md:flex-row gap-4 mb-10 items-stretch md:items-center justify-between sticky top-20 z-40 transition-shadow hover:shadow-md">
                {/* Search */}
                <div className="relative flex-grow max-w-2xl">
                    <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                        <span className="material-symbols-outlined text-gray-400">search</span>
                    </div>
                    <input
                        className="block w-full pl-10 pr-3 py-3 border border-gray-200 rounded-lg leading-5 bg-background-dark placeholder-gray-400 focus:outline-none focus:bg-white focus:ring-2 focus:ring-primary focus:border-primary sm:text-sm transition-all duration-200"
                        placeholder="Search for courses (e.g., Python, Design)..."
                        type="text"
                    />
                </div>
                {/* Filter Dropdown */}
                <div className="min-w-[200px]">
                    <div className="relative">
                        <select className="block w-full pl-3 pr-10 py-3 text-base border-gray-200 focus:outline-none focus:ring-2 focus:ring-primary focus:border-primary sm:text-sm rounded-lg bg-white shadow-sm cursor-pointer appearance-none text-text-main">
                            <option>All Categories</option>
                            <option>Development</option>
                            <option>Design</option>
                            <option>Business</option>
                            <option>Marketing</option>
                            <option>Photography</option>
                        </select>
                        <div className="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-500">
                            <span className="material-symbols-outlined">expand_more</span>
                        </div>
                    </div>
                </div>
            </div>

            {/* Course Grid */}
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6 mb-12">
                {/* Card 1: Active */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Abstract UI design interface mockup with colorful gradients"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuA3Qnoha2hr-3vZeoL16ddsgkgZHMjWYTnAUx6Z1uzxtK1diaDsGHNb2eMRofYV3TCUMZ0z08CjZHY6tfgIBxaBejuAgqrI6NQMflgYF-q9Ke6gTVztsKXSTb7ndKylp4ogpDBQ0Ykc3HJ1e5jmIUY-zpcao3-RH3F1OcuSaR6G1Ke4aNLJQ7a_0VG4NYlL37WbpssWMN29E_QhJLZPWqLKV-Nrcel97x6ssALpzCDgSh3Iv7bTYXKyvy4rOCx0VGMRdWJdi4dU7ePH")' }}
                        ></div>
                        <div className="absolute top-3 left-3 bg-white/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-gray-800 shadow-sm">
                            Design
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Advanced UI/UX Principles</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Master the fundamentals of user interface and experience design with real-world projects and case studies.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-lg font-bold text-text-main">$49.99</span>
                                <div className="flex items-center text-xs text-yellow-500 gap-0.5">
                                    <span class="material-symbols-outlined text-[14px] fill-current">star</span>
                                    <span className="text-gray-500 font-medium ml-1">4.8 (1.2k)</span>
                                </div>
                            </div>
                            <button className="bg-primary hover:bg-orange-600 text-white text-sm font-bold py-2 px-4 rounded-lg shadow-sm hover:shadow transition-all active:scale-95">
                                Enroll
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 2: Enrolled */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Code on a computer screen displaying python scripts"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuDuAffuUCXHv0zNAwidGq6zKUMn8eTFjeBVIhlwmeHQQbd_1gmVFvp4cINuS3gTtdiFSfDvKEYTrbaoqRArFVuTCzeXz-e7SKhNIU1THTzCOu01_APn69QBYarh2OUA8EyPsuEm8ECvlYAaPv8L2k9ga69GXNQhxIZe1h89engHNe-KXRSulrxeIQaUt8O8-RbiiCx3LlAuE22TgsNouGErrILjyDSvlOw5G9KMQhxY2oOqetlkOiXkvCYk2DN_lDFFnGgoKKKQmSOI")' }}
                        ></div>
                        <div className="absolute inset-0 bg-black/40 flex items-center justify-center opacity-0 group-hover:opacity-100 transition-opacity duration-300">
                            <span className="bg-white text-black text-xs font-bold py-1.5 px-3 rounded-full">Continue Learning</span>
                        </div>
                        <div className="absolute top-3 left-3 bg-blue-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-blue-800 shadow-sm">
                            Development
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow relative">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2">Python for Data Science</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Learn Python from scratch and apply it to data analysis, visualization, and machine learning basics.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-sm font-medium text-green-600 flex items-center gap-1">
                                    <span className="material-symbols-outlined text-[16px]">check_circle</span>
                                    Enrolled
                                </span>
                                <div className="w-20 h-1.5 bg-gray-200 rounded-full mt-1.5 overflow-hidden">
                                    <div className="bg-green-500 h-full w-2/3 rounded-full"></div>
                                </div>
                            </div>
                            <button className="bg-gray-100 text-gray-400 cursor-not-allowed text-sm font-bold py-2 px-4 rounded-lg border border-gray-200">
                                Enrolled
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 3: New */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Person working on marketing strategy with graphs and charts"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuDx24Egu2IyHHHlAMUORa2pXamUxwU-gV4GqCJjQRIIab1TxNhZMfwzK12LyH2Mt2h8zyfFlap_WDLxkZH8QA_IFtZVNYvhGsj9FEEiyFcE_KzO_nf2h3YcEk-7H-TCP5ieuxwVgOWh4DKS2DslpS_haJi5zJY1gifFRto0Pb5wTgilvxq1wPOoMqf7pBpRyOJkkjZ40Lz1cwV3QDKb0UJlwE7ZOVYxdvpYXe4b3xfS2cet4hTDAzzqoGvz8z0LwiBNerNzqSc0KdB3")' }}
                        ></div>
                        <div className="absolute top-3 right-3 bg-red-500 text-white text-[10px] font-bold px-2 py-0.5 rounded shadow-sm">NEW</div>
                        <div className="absolute top-3 left-3 bg-purple-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-purple-800 shadow-sm">
                            Business
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Digital Marketing 101</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">A comprehensive guide to SEO, social media marketing, and content strategy for businesses.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-lg font-bold text-text-main">$29.99</span>
                                <div className="flex items-center text-xs text-yellow-500 gap-0.5">
                                    <span className="material-symbols-outlined text-[14px] fill-current">star</span>
                                    <span className="text-gray-500 font-medium ml-1">4.5 (850)</span>
                                </div>
                            </div>
                            <button className="bg-primary hover:bg-orange-600 text-white text-sm font-bold py-2 px-4 rounded-lg shadow-sm hover:shadow transition-all active:scale-95">
                                Enroll
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 4 */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Team meeting discussing agile project management"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuDeOu5P3jF9cHjGTTQ2iuaHAwnuoJa6W3KUs-p2j2uEYbjQVGU1yfiYsqAULFqXOStXEIDpWEdXVygi4lxCRXPbCPVb1WWqmctvfzFQrLAJU2xrvA-8O56wIisx6AWykaO7uKubnP4RNqiIl1ZSERvwkYp3ZZsohtlfySsOaReVKOAhoPqIx-21pH_bhb2NYAU1Oq-OXIZaI6YPaXYlrhhlX2LRAFZ2tPtIt3Xgx-xoh5-o36gvlVFChNecpBgXtypE2Lec2KDZ-9nx")' }}
                        ></div>
                        <div className="absolute top-3 left-3 bg-purple-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-purple-800 shadow-sm">
                            Business
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">PMP Certification Prep</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Prepare for the Project Management Professional exam with this intensive preparatory course.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-lg font-bold text-text-main">$89.99</span>
                                <div className="flex items-center text-xs text-yellow-500 gap-0.5">
                                    <span className="material-symbols-outlined text-[14px] fill-current">star</span>
                                    <span className="text-gray-500 font-medium ml-1">4.9 (2.1k)</span>
                                </div>
                            </div>
                            <button className="bg-primary hover:bg-orange-600 text-white text-sm font-bold py-2 px-4 rounded-lg shadow-sm hover:shadow transition-all active:scale-95">
                                Enroll
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 5 */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Smartphone showing mobile app development code"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuA41UN5HaxEDW1XGbQ0aULf8-MwJoig41gRMUT7VxaHqzfL6ZneSbJKwT8SYDsagmRpczVgpeOkXrEwo4sNINYVGrWMMs5nk0Pc7TCjaBrucYkDnYCYgrAAOWy1t_VAJPRhzWVPo9HnE3ZhyXKWgyRgYuNWgmzUvzYqZ0dvBueSCeKlc8he65I7zWRATZba2fKucBw8gyFeR4gX9GjewqI5mO-GTIfuhr0UVLcfVbXPzNLwqlvsXsstW5UcF1TurIj5Bj8MubOo1TB3")' }}
                        ></div>
                        <div className="absolute top-3 left-3 bg-blue-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-blue-800 shadow-sm">
                            Development
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">React Native Masterclass</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Build native mobile apps for iOS and Android using React. Covers Hooks, Navigation, and more.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-lg font-bold text-text-main">$59.99</span>
                                <div className="flex items-center text-xs text-yellow-500 gap-0.5">
                                    <span className="material-symbols-outlined text-[14px] fill-current">star</span>
                                    <span className="text-gray-500 font-medium ml-1">4.7 (940)</span>
                                </div>
                            </div>
                            <button className="bg-primary hover:bg-orange-600 text-white text-sm font-bold py-2 px-4 rounded-lg shadow-sm hover:shadow transition-all active:scale-95">
                                Enroll
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 6: Free Course */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Notebook and pen for creative writing"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuBH3-dxwQLQwnIkUN1GIe-maOGdl_DDH8LQvbaThUvQM_XqOb0KKF342WWM7_NBPvU-bHyU3QIae-Siqq2gh57OGrDblR82k_K7ycCvuD4DSauL4fj_-otGHvCAnnhvkGwF1T2e6MHC3ZG0qaiimsyXvbi7sxNEE-ADeZizXQ7GovI473GdjBsaBwVvj0ris5SGGBWqYI9L-m5nd8XshyyngGBVZ36iOFESVcGb6IB37e30KXaP1saS6HkyRJES-qrhhGGUSEOZr4yF")' }}
                        ></div>
                        <div className="absolute top-3 left-3 bg-pink-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-pink-800 shadow-sm">
                            Arts
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Creative Writing Workshop</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Unlock your creativity with daily writing prompts and peer review sessions.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-lg font-bold text-green-600">Free</span>
                                <div className="flex items-center text-xs text-yellow-500 gap-0.5">
                                    <span className="material-symbols-outlined text-[14px] fill-current">star</span>
                                    <span className="text-gray-500 font-medium ml-1">4.6 (3.5k)</span>
                                </div>
                            </div>
                            <button className="bg-primary hover:bg-orange-600 text-white text-sm font-bold py-2 px-4 rounded-lg shadow-sm hover:shadow transition-all active:scale-95">
                                Enroll
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 7 */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Camera lens close up for photography course"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuBiA9LdPgdoL5zH1z9SNNmN5bZJx6K0hPlCH_tSZB0AD0Ialmypc1GAR_praP0iMKgsIIRGjmVhvoK2fA1cFYYRbXf_0HicVP_2Z6L7gnBzeIGA18dhmeVlEwP_Yst86k75fgeUfmvUxfmXlCqUrA8bLF6drZmxHpC8QEKDTISq4EJJltcQ2gk1L9snz2Pl0M8yw8yhkngERe_py_tHX47vLjGZ7lKOFQcLSnVG42Jl_GXC1lNx3c7ZLhdrF8Sj1H_I-9MWH_baXtLi")' }}
                        ></div>
                        <div className="absolute top-3 left-3 bg-teal-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-teal-800 shadow-sm">
                            Photography
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Mastering Composition</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Learn the rules of composition to take stunning photos with any camera.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-lg font-bold text-text-main">$34.99</span>
                                <div className="flex items-center text-xs text-yellow-500 gap-0.5">
                                    <span className="material-symbols-outlined text-[14px] fill-current">star</span>
                                    <span className="text-gray-500 font-medium ml-1">4.4 (520)</span>
                                </div>
                            </div>
                            <button className="bg-primary hover:bg-orange-600 text-white text-sm font-bold py-2 px-4 rounded-lg shadow-sm hover:shadow transition-all active:scale-95">
                                Enroll
                            </button>
                        </div>
                    </div>
                </article>

                {/* Card 8: Enrolled */}
                <article className="flex flex-col bg-background-light rounded-xl shadow-card hover:shadow-card-hover hover:-translate-y-1 transition-all duration-300 overflow-hidden group h-full border border-gray-100/50">
                    <div className="relative h-48 overflow-hidden">
                        <div
                            className="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105"
                            data-alt="Modern abstract architecture representing system design"
                            style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuCuv1uWSs9r90mwtnpqAjyZLSnXGSCD3m8bGajO2BxsdZdxYriyvsDRz3ooCsfHsNeh-bmsKV6upiCiQ564o15uw6JoH5SeHhD4pyVEhc1cb_cxDuMYfiuXMIqlV-SwSIlzbPYFNLJg5kjOoEi_xqxsXs3S-s6eIAS88FjF-HwKZgMijDyOTRf3W1xVLzK6M2TQN8dUTh8gMmnKRMs77rJBekcQAuZbzqUWX9PFTKexwb38eZm12ejZZt6WukkCpm4YEfHg_w1hHP5J")' }}
                        ></div>
                        <div className="absolute inset-0 bg-black/40 flex items-center justify-center opacity-0 group-hover:opacity-100 transition-opacity duration-300">
                            <span className="bg-white text-black text-xs font-bold py-1.5 px-3 rounded-full">Continue Learning</span>
                        </div>
                        <div className="absolute top-3 left-3 bg-blue-50/90 backdrop-blur-sm px-2.5 py-1 rounded-md text-xs font-bold text-blue-800 shadow-sm">
                            Development
                        </div>
                    </div>
                    <div className="p-5 flex flex-col flex-grow relative">
                        <h3 className="text-text-main text-lg font-bold leading-tight mb-2">System Design Interviews</h3>
                        <p className="text-text-secondary text-sm mb-4 line-clamp-2">Ace your system design interview with scalable architecture patterns.</p>
                        <div className="mt-auto pt-4 border-t border-gray-50 flex items-center justify-between">
                            <div className="flex flex-col">
                                <span className="text-sm font-medium text-green-600 flex items-center gap-1">
                                    <span className="material-symbols-outlined text-[16px]">check_circle</span>
                                    Enrolled
                                </span>
                                <div className="w-20 h-1.5 bg-gray-200 rounded-full mt-1.5 overflow-hidden">
                                    <div className="bg-green-500 h-full w-1/4 rounded-full"></div>
                                </div>
                            </div>
                            <button className="bg-gray-100 text-gray-400 cursor-not-allowed text-sm font-bold py-2 px-4 rounded-lg border border-gray-200">
                                Enrolled
                            </button>
                        </div>
                    </div>
                </article>
            </div>

            {/* Pagination / Load More */}
            <div className="flex justify-center pb-8">
                <button className="flex items-center gap-2 px-6 py-3 bg-white border border-gray-200 rounded-lg text-text-main font-bold hover:bg-gray-50 hover:border-gray-300 transition-colors shadow-sm">
                    <span>Load More Courses</span>
                    <span className="material-symbols-outlined text-[20px]">arrow_downward</span>
                </button>
            </div>

            <footer className="py-8 text-center text-xs text-text-muted">
                <p>© 2023 LMS Platform. All rights reserved.</p>
            </footer>
        </div>
    );
};

export default CourseCatalog;
