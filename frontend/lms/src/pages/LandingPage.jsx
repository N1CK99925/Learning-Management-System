import { Link } from 'react-router-dom';

const LandingPage = () => {
    return (
        <div className="relative flex min-h-screen w-full flex-col group/design-root font-sans">
            {/* Navigation */}
            <header className="sticky top-0 z-50 bg-background-light shadow-whisper border-b border-gray-100">
                <div className="layout-container flex justify-center w-full">
                    <div className="flex items-center justify-between w-full max-w-[1200px] px-6 py-4 md:px-10">
                        {/* Logo */}
                        <div className="flex items-center gap-3 text-text-main cursor-pointer">
                            <div className="size-8 text-primary">
                                <svg fill="none" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M24 4C14.0589 4 6 12.0589 6 22V36C6 38.2091 7.79086 40 10 40H38C40.2091 40 42 38.2091 42 36V22C42 12.0589 33.9411 4 24 4Z" fill="currentColor" fillOpacity="0.1"></path>
                                    <path d="M24 10C26.2091 10 28 11.7909 28 14V18H32C34.2091 18 36 19.7909 36 22C36 24.2091 34.2091 26 32 26H28V34C28 36.2091 26.2091 38 24 38C21.7909 38 20 36.2091 20 34V26H16C13.7909 26 12 24.2091 12 22C12 19.7909 13.7909 18 16 18H20V14C20 11.7909 21.7909 10 24 10Z" fill="currentColor"></path>
                                </svg>
                            </div>
                            <h2 className="text-xl font-extrabold tracking-tight">LMS<span className="text-primary">.</span></h2>
                        </div>
                        {/* Desktop Nav Links */}
                        <nav className="hidden md:flex flex-1 justify-center">
                            <a className="text-text-main text-sm font-semibold hover:text-primary transition-colors px-4 py-2" href="#">Courses</a>
                            <a className="text-text-main text-sm font-semibold hover:text-primary transition-colors px-4 py-2" href="#">Instructors</a>
                            <a className="text-text-main text-sm font-semibold hover:text-primary transition-colors px-4 py-2" href="#">Enterprise</a>
                        </nav>
                        {/* Auth Buttons */}
                        <div className="flex items-center gap-3">
                            <Link to="/login" className="hidden md:flex cursor-pointer items-center justify-center rounded-lg h-10 px-6 text-text-main text-sm font-bold hover:bg-gray-50 transition-colors">
                                Log in
                            </Link>
                            <Link to="/register" className="flex cursor-pointer items-center justify-center rounded-lg h-10 px-6 bg-primary text-white text-sm font-bold shadow-md hover:bg-primary-dark transition-colors">
                                Register
                            </Link>
                        </div>
                    </div>
                </div>
            </header>

            {/* Main Content */}
            <main className="flex-grow flex flex-col items-center w-full">
                {/* Hero Section */}
                <section className="w-full max-w-[1200px] px-6 md:px-10 py-16 lg:py-24">
                    <div className="@container">
                        <div className="flex flex-col-reverse gap-12 lg:flex-row lg:items-center lg:gap-20">
                            {/* Left Content */}
                            <div className="flex flex-col gap-6 flex-1 lg:max-w-[540px]">
                                <div className="flex flex-col gap-4 text-left">
                                    <span className="text-primary font-bold text-sm tracking-wider uppercase">Future of Learning</span>
                                    <h1 className="text-text-main text-5xl sm:text-6xl font-black leading-[1.1] tracking-tight">
                                        Learn. Build. <br />
                                        <span className="text-primary">Advance.</span>
                                    </h1>
                                    <p className="text-text-secondary text-lg leading-relaxed max-w-lg">
                                        Master new skills with our expert-led courses designed for your career growth. From coding to design, learn from the best.
                                    </p>
                                </div>
                                <div className="flex gap-4 pt-4">
                                    <button className="flex cursor-pointer items-center justify-center rounded-lg h-12 px-8 bg-primary text-white text-base font-bold shadow-lg hover:bg-primary-dark hover:-translate-y-0.5 transition-all duration-200">
                                        Explore Courses
                                    </button>
                                    <button className="flex cursor-pointer items-center justify-center rounded-lg h-12 px-8 bg-white border border-gray-200 text-text-main text-base font-bold shadow-sm hover:border-gray-300 hover:bg-gray-50 transition-all duration-200">
                                        View Path
                                    </button>
                                </div>
                                <div className="flex items-center gap-4 pt-4">
                                    <div className="flex -space-x-3">
                                        <img alt="Student avatar 1" className="w-10 h-10 rounded-full border-2 border-white object-cover" data-alt="Portrait of a smiling young student" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDKplbIjlPSWQB3GfUfas9AWJWC-3L6HyjIfblyFKsY64oAKcptmqcbFfzgig3B8tD6SUz-dqLKSx6UFT8d9DyBi6QCRs3LGBFwg9m7mLY3BQpfS1fPEyf9GKxRVgglJAlNgtFS9UHzYsvEK40almZq3NVf3Q5i2HY4uQjfNicu4rCnl5SyzeMRakNQYZxSmacdmkpevRFMlvZcqcPj2RRQeIhEJh6YJDAkkYXg421wzkofI28-DLPIEx8TDLSIiizdw_s-lI7JEZgH" />
                                        <img alt="Student avatar 2" className="w-10 h-10 rounded-full border-2 border-white object-cover" data-alt="Portrait of a male student" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDh02ZITBIu2c2GrUmaQxeZFmsfYGs7wK-jte-xqqbtd7gswaiFftBut9V7T58fQ5NjRn9aHoRoKqNe20sgqdspOQ-gx6FXhT-pOBK3osDmj6JnyN9J9gCTTGYXGX73riYTpcY95ECbKYtTbe_Vucg32JyGU1eJ-sxaCASvVwbAJKtHkiw8UZbE-9h6y1tSpKDmDRwxHcgFTi_Vo46cs5bqa4ErSikriTJXxPYKLO0C8SnkbzEviW15Iium8Y9KEmEmCdvezS3TnN8C" />
                                        <img alt="Student avatar 3" className="w-10 h-10 rounded-full border-2 border-white object-cover" data-alt="Portrait of a female student with glasses" src="https://lh3.googleusercontent.com/aida-public/AB6AXuB0-m0_RNqHnSPoOaanEBcZp8AidUs1Efw1sW5ZHZvsVhpIkiZeUTdTFhWUMn7c7bj7FaGpJoq3dCnAEZlIDz142tT4aeCM1Q8ZoCQIp2Q5kvBkYZZMBaU9Rn2GxiGFtWVy1PXHmtUUxE89DMCi0S-7gv1Kf0HJJWA3lAn5sakSse6N-viOknriGjd9M3vbtPwHdGgKrB6KxPMjVfSN4fDNclrM-jWd6WjOUAJWFzYQYe4J4hOg4tFBxV0_qbHqfBgZbfpznFug5b_u" />
                                        <div className="w-10 h-10 rounded-full border-2 border-white bg-gray-100 flex items-center justify-center text-xs font-bold text-text-secondary">
                                            +2k
                                        </div>
                                    </div>
                                    <p className="text-sm text-text-secondary font-medium">Trusted by 2,000+ students</p>
                                </div>
                            </div>
                            {/* Right Image */}
                            <div className="flex-1 w-full relative">
                                {/* Abstract decorative elements */}
                                <div className="absolute -z-10 top-10 -right-10 w-64 h-64 bg-primary/10 rounded-full blur-3xl"></div>
                                <div className="absolute -z-10 bottom-10 left-10 w-48 h-48 bg-blue-500/10 rounded-full blur-3xl"></div>
                                <div className="relative w-full aspect-[4/3] rounded-2xl overflow-hidden shadow-2xl border border-white/50">
                                    <div className="w-full h-full bg-center bg-cover" data-alt="Group of students working together on laptops in a modern library" style={{ backgroundImage: "url('https://lh3.googleusercontent.com/aida-public/AB6AXuC5GxSJZDX5qeRTybhRX0rf9-fJCoDMXScv3ABf_ZM-U10NMeZDpSFihZc7GL5x7PUYWFixS7wz66j0f7hhsMjmTvWlA6gIhrSucpPRxH98krXVGMuTrfMXoHsjVNZbhuzzwzWymv8XRBNlLl66-YGt-7-nrBHAb6-oxLB1Hv_Mima4JRErdVOQ5613GoJ4fkG7lU2bCxbUJBk89Wqa2oavED0E6e5qDlbCiGab08aplH8fvL-xSu0e2NR1TYcTeWeUjDyTdfDRhHxM')" }}>
                                    </div>
                                    {/* Floating UI Card overlay */}
                                    <div className="absolute bottom-6 left-6 bg-white/95 backdrop-blur-sm p-4 rounded-xl shadow-lg border border-gray-100 max-w-[200px]">
                                        <div className="flex items-center gap-3 mb-2">
                                            <div className="bg-green-100 text-green-700 p-1.5 rounded-full">
                                                <span className="material-symbols-outlined text-sm">check_circle</span>
                                            </div>
                                            <span className="text-xs font-bold text-text-main">Course Completed</span>
                                        </div>
                                        <div className="h-2 w-full bg-gray-100 rounded-full overflow-hidden">
                                            <div className="h-full bg-green-500 w-full rounded-full"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                {/* Value Props Section */}
                <section className="w-full bg-white py-16 border-y border-gray-100">
                    <div className="flex justify-center w-full">
                        <div className="flex flex-col max-w-[1200px] px-6 md:px-10 w-full gap-10">
                            <div className="flex flex-col md:flex-row justify-between items-end gap-4">
                                <h2 className="text-text-main text-3xl font-bold leading-tight md:text-4xl max-w-[600px]">
                                    Why learn with us
                                </h2>
                                <a className="text-primary font-bold hover:underline flex items-center gap-1 group" href="#">
                                    Read our mission
                                    <span className="material-symbols-outlined text-lg group-hover:translate-x-1 transition-transform">arrow_forward</span>
                                </a>
                            </div>
                            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
                                {/* Feature 1 */}
                                <div className="flex flex-col gap-4 p-6 rounded-2xl border border-gray-100 bg-background-dark hover:bg-white hover:shadow-whisper transition-all duration-300">
                                    <div className="w-12 h-12 rounded-lg bg-orange-50 flex items-center justify-center text-primary mb-2">
                                        <span className="material-symbols-outlined">school</span>
                                    </div>
                                    <div>
                                        <h3 className="text-text-main text-lg font-bold mb-2">Expert Instructors</h3>
                                        <p className="text-text-secondary text-sm leading-relaxed">Learn directly from industry veterans and top-tier professionals who have built systems at scale.</p>
                                    </div>
                                </div>
                                {/* Feature 2 */}
                                <div className="flex flex-col gap-4 p-6 rounded-2xl border border-gray-100 bg-background-dark hover:bg-white hover:shadow-whisper transition-all duration-300">
                                    <div className="w-12 h-12 rounded-lg bg-blue-50 flex items-center justify-center text-blue-600 mb-2">
                                        <span className="material-symbols-outlined">all_inclusive</span>
                                    </div>
                                    <div>
                                        <h3 className="text-text-main text-lg font-bold mb-2">Lifetime Access</h3>
                                        <p className="text-text-secondary text-sm leading-relaxed">Pay once, own forever. Revisit lectures, access updated materials, and learn at your own pace anytime.</p>
                                    </div>
                                </div>
                                {/* Feature 3 */}
                                <div className="flex flex-col gap-4 p-6 rounded-2xl border border-gray-100 bg-background-dark hover:bg-white hover:shadow-whisper transition-all duration-300">
                                    <div className="w-12 h-12 rounded-lg bg-purple-50 flex items-center justify-center text-purple-600 mb-2">
                                        <span className="material-symbols-outlined">schedule</span>
                                    </div>
                                    <div>
                                        <h3 className="text-text-main text-lg font-bold mb-2">Self-Paced Learning</h3>
                                        <p className="text-text-secondary text-sm leading-relaxed">No deadlines, no pressure. Structure your own curriculum to fit your busy lifestyle and career goals.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                {/* Featured Courses Section */}
                <section className="w-full max-w-[1200px] px-6 md:px-10 py-16 lg:py-24">
                    <div className="flex flex-col gap-10">
                        <div className="flex flex-col md:flex-row justify-between items-center gap-4">
                            <h2 className="text-text-main text-3xl font-bold leading-tight tracking-tight">Featured Courses</h2>
                            {/* Categories Filter (Visual only for design) */}
                            <div className="flex gap-2 overflow-x-auto pb-2 max-w-full no-scrollbar">
                                <button className="whitespace-nowrap px-4 py-2 rounded-full bg-text-main text-white text-sm font-bold">All</button>
                                <button className="whitespace-nowrap px-4 py-2 rounded-full bg-white border border-gray-200 text-text-secondary hover:text-text-main text-sm font-bold transition-colors">Development</button>
                                <button className="whitespace-nowrap px-4 py-2 rounded-full bg-white border border-gray-200 text-text-secondary hover:text-text-main text-sm font-bold transition-colors">Design</button>
                                <button className="whitespace-nowrap px-4 py-2 rounded-full bg-white border border-gray-200 text-text-secondary hover:text-text-main text-sm font-bold transition-colors">Business</button>
                            </div>
                        </div>
                        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
                            {/* Course Card 1 */}
                            <div className="group flex flex-col bg-background-light rounded-2xl overflow-hidden shadow-whisper hover:shadow-whisper-hover hover:-translate-y-1 transition-all duration-300 border border-gray-100 h-full">
                                <div className="relative aspect-video w-full overflow-hidden">
                                    <div className="w-full h-full bg-cover bg-center transition-transform duration-500 group-hover:scale-105" data-alt="Computer screen displaying Python code" style={{ backgroundImage: "url('https://lh3.googleusercontent.com/aida-public/AB6AXuBWywRrgAu0hZcVgDSgvBPXIH85YKLVEpgzuaRTtA7Nac5NCznJcdzj-WlkrQTiq43UcJ6tkXr52Y2JRLiRHzLscfeVR-2dmT8dcR0P6l7sEvO_-IdgisvOhdHW-31-d5HaLc_XykXl4BHDtRLKiMZssVqOSPaVRHSKobI5QhASQ0MyY-reaHkq-9WNqoLCDR9nUFPZ1G8ZTtvZg2H6Z6CBsU83fU6ZTD-PCLb4ItMMBAfvYJzxNX7PiRuKfUrn4sAFqjMt8ziCKS7v')" }}>
                                    </div>
                                    <div className="absolute top-3 left-3 bg-white/90 backdrop-blur-md px-2.5 py-1 rounded-md text-xs font-bold text-text-main uppercase tracking-wide border border-gray-200 shadow-sm">
                                        Development
                                    </div>
                                </div>
                                <div className="flex flex-col flex-1 p-5 gap-3">
                                    <div className="flex items-center gap-1 text-yellow-500 text-sm font-bold">
                                        <span className="material-symbols-outlined text-base fill-current">star</span>
                                        <span>4.8</span>
                                        <span className="text-gray-400 font-normal ml-1">(1.2k)</span>
                                    </div>
                                    <h3 className="text-text-main text-lg font-bold leading-tight group-hover:text-primary transition-colors">
                                        Complete Python Bootcamp 2024
                                    </h3>
                                    <p className="text-text-secondary text-sm">By Dr. Angela Yu</p>
                                    <div className="mt-auto pt-4 flex items-center justify-between border-t border-gray-50">
                                        <span className="text-text-main font-black text-lg">$12.99</span>
                                        <button className="text-primary text-sm font-bold hover:bg-orange-50 px-3 py-1.5 rounded-lg transition-colors">
                                            Enroll Now
                                        </button>
                                    </div>
                                </div>
                            </div>
                            {/* Course Card 2 */}
                            <div className="group flex flex-col bg-background-light rounded-2xl overflow-hidden shadow-whisper hover:shadow-whisper-hover hover:-translate-y-1 transition-all duration-300 border border-gray-100 h-full">
                                <div className="relative aspect-video w-full overflow-hidden">
                                    <div className="w-full h-full bg-cover bg-center transition-transform duration-500 group-hover:scale-105" data-alt="Designer working on colorful UI sketches" style={{ backgroundImage: "url('https://lh3.googleusercontent.com/aida-public/AB6AXuB-AdMKJpbWVyUuU9dyInKxq42SscWW-bxoEknDvonenvPbzxdcPKsUhgrTdEb34mrReJw66WHNQ0eFlHBbOQd-wDjNFJcSHWnnqLjldq6clD406FXI3A6mDJSoVgTZEhgaJqlV0yT6C_KFgkd8ft7NBNXf9Fy_EGZFXWpd4aw3gQBW3zhrUxruLVW6Zf6oP5bJLJFh_ZARb1nDwgGUDQ2rawfI6ISzEG0u9t4YZMvpyAeescyjRBzo5o-LbGUT2VxgAckI4FdzNELE')" }}>
                                    </div>
                                    <div className="absolute top-3 left-3 bg-white/90 backdrop-blur-md px-2.5 py-1 rounded-md text-xs font-bold text-text-main uppercase tracking-wide border border-gray-200 shadow-sm">
                                        Design
                                    </div>
                                </div>
                                <div className="flex flex-col flex-1 p-5 gap-3">
                                    <div className="flex items-center gap-1 text-yellow-500 text-sm font-bold">
                                        <span className="material-symbols-outlined text-base fill-current">star</span>
                                        <span>4.9</span>
                                        <span className="text-gray-400 font-normal ml-1">(850)</span>
                                    </div>
                                    <h3 className="text-text-main text-lg font-bold leading-tight group-hover:text-primary transition-colors">
                                        UX Design Masterclass
                                    </h3>
                                    <p className="text-text-secondary text-sm">By Joe Natoli</p>
                                    <div className="mt-auto pt-4 flex items-center justify-between border-t border-gray-50">
                                        <span className="text-text-main font-black text-lg">$14.99</span>
                                        <button className="text-primary text-sm font-bold hover:bg-orange-50 px-3 py-1.5 rounded-lg transition-colors">
                                            Enroll Now
                                        </button>
                                    </div>
                                </div>
                            </div>
                            {/* Course Card 3 */}
                            <div className="group flex flex-col bg-background-light rounded-2xl overflow-hidden shadow-whisper hover:shadow-whisper-hover hover:-translate-y-1 transition-all duration-300 border border-gray-100 h-full">
                                <div className="relative aspect-video w-full overflow-hidden">
                                    <div className="w-full h-full bg-cover bg-center transition-transform duration-500 group-hover:scale-105" data-alt="Marketing analytics dashboard on a laptop screen" style={{ backgroundImage: "url('https://lh3.googleusercontent.com/aida-public/AB6AXuBywVI9gfD0C5NfHHcrgxM1St3icbuHGQ0YMYOmtwA_6dpSEsWw5BOerwvWzIRSE_-AKzEFlavIeuIKFbIIlegS794WE4X9540fymj4psfYaqcQzND8AbBxzTLpIZXJhuVAhMjnRJrf6-RRiPfGFZnVILHK9JDmnLqckWXCWPMfOMDfQglTc75oq9G9PsFixw5HrHhbzirQGZUqrgCvk0asEjnbmUvQeNXBFvPTcj3yg1KhgNSeNJpC63qVjCAJTw0YKwdgH1X1HWSD')" }}>
                                    </div>
                                    <div className="absolute top-3 left-3 bg-white/90 backdrop-blur-md px-2.5 py-1 rounded-md text-xs font-bold text-text-main uppercase tracking-wide border border-gray-200 shadow-sm">
                                        Marketing
                                    </div>
                                </div>
                                <div className="flex flex-col flex-1 p-5 gap-3">
                                    <div className="flex items-center gap-1 text-yellow-500 text-sm font-bold">
                                        <span className="material-symbols-outlined text-base fill-current">star</span>
                                        <span>4.7</span>
                                        <span className="text-gray-400 font-normal ml-1">(2.1k)</span>
                                    </div>
                                    <h3 className="text-text-main text-lg font-bold leading-tight group-hover:text-primary transition-colors">
                                        Digital Marketing 101
                                    </h3>
                                    <p className="text-text-secondary text-sm">By Seth Godin</p>
                                    <div className="mt-auto pt-4 flex items-center justify-between border-t border-gray-50">
                                        <span className="text-text-main font-black text-lg">$11.99</span>
                                        <button className="text-primary text-sm font-bold hover:bg-orange-50 px-3 py-1.5 rounded-lg transition-colors">
                                            Enroll Now
                                        </button>
                                    </div>
                                </div>
                            </div>
                            {/* Course Card 4 */}
                            <div className="group flex flex-col bg-background-light rounded-2xl overflow-hidden shadow-whisper hover:shadow-whisper-hover hover:-translate-y-1 transition-all duration-300 border border-gray-100 h-full">
                                <div className="relative aspect-video w-full overflow-hidden">
                                    <div className="w-full h-full bg-cover bg-center transition-transform duration-500 group-hover:scale-105" data-alt="Financial data graphs and charts" style={{ backgroundImage: "url('https://lh3.googleusercontent.com/aida-public/AB6AXuA5MWNo5dg23dRVKEiWTFQYz_8GxDtLGgCvBoEAWOu1KBY3KiI_QEjR3v3uQydSJJDNHOW1rs0e4jGhgVDie2VLMVTpNSwVLQ_i-ajIinXlZXr8Ne8TrFT-xXs0IEAXQ7wn2CEB3hpBOL6jAece6fIEBAOkdxVsZnjXxBjAsZzx39C7qzVhfKExU-sWOCUg7M0lWRAY4lIqcYqIRUzYaflxOXkoQFtUP7-DdhTKXrr4F42N3Ic6w93CHc9JfcOSBthrj9hhR1vgsBWs')" }}>
                                    </div>
                                    <div className="absolute top-3 left-3 bg-white/90 backdrop-blur-md px-2.5 py-1 rounded-md text-xs font-bold text-text-main uppercase tracking-wide border border-gray-200 shadow-sm">
                                        Finance
                                    </div>
                                </div>
                                <div className="flex flex-col flex-1 p-5 gap-3">
                                    <div className="flex items-center gap-1 text-yellow-500 text-sm font-bold">
                                        <span className="material-symbols-outlined text-base fill-current">star</span>
                                        <span>4.9</span>
                                        <span className="text-gray-400 font-normal ml-1">(540)</span>
                                    </div>
                                    <h3 className="text-text-main text-lg font-bold leading-tight group-hover:text-primary transition-colors">
                                        Financial Analysis Master
                                    </h3>
                                    <p className="text-text-secondary text-sm">By 365 Careers</p>
                                    <div className="mt-auto pt-4 flex items-center justify-between border-t border-gray-50">
                                        <span className="text-text-main font-black text-lg">$19.99</span>
                                        <button className="text-primary text-sm font-bold hover:bg-orange-50 px-3 py-1.5 rounded-lg transition-colors">
                                            Enroll Now
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="flex justify-center pt-8">
                            <button className="px-8 py-3 rounded-lg border border-gray-200 bg-white text-text-main font-bold shadow-sm hover:border-primary hover:text-primary transition-colors">
                                View All Courses
                            </button>
                        </div>
                    </div>
                </section>
            </main>
            {/* Footer */}
            <footer className="bg-white border-t border-gray-100 pt-16 pb-8">
                <div className="layout-container flex justify-center w-full">
                    <div className="w-full max-w-[1200px] px-6 md:px-10">
                        <div className="grid grid-cols-1 md:grid-cols-4 gap-12 mb-12">
                            {/* Brand Column */}
                            <div className="col-span-1 md:col-span-1 flex flex-col gap-4">
                                <div className="flex items-center gap-2 text-text-main">
                                    <div className="size-6 text-primary">
                                        <svg fill="none" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M24 4C14.0589 4 6 12.0589 6 22V36C6 38.2091 7.79086 40 10 40H38C40.2091 40 42 38.2091 42 36V22C42 12.0589 33.9411 4 24 4Z" fill="currentColor" fillOpacity="0.1"></path>
                                            <path d="M24 10C26.2091 10 28 11.7909 28 14V18H32C34.2091 18 36 19.7909 36 22C36 24.2091 34.2091 26 32 26H28V34C28 36.2091 26.2091 38 24 38C21.7909 38 20 36.2091 20 34V26H16C13.7909 26 12 24.2091 12 22C12 19.7909 13.7909 18 16 18H20V14C20 11.7909 21.7909 10 24 10Z" fill="currentColor"></path>
                                        </svg>
                                    </div>
                                    <span className="text-lg font-bold">LMS.</span>
                                </div>
                                <p className="text-text-secondary text-sm leading-relaxed">
                                    Empowering learners worldwide with accessible, high-quality education.
                                </p>
                            </div>
                            {/* Links Columns */}
                            <div className="flex flex-col gap-3">
                                <h4 className="text-text-main font-bold mb-1">Company</h4>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">About Us</a>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Careers</a>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Press</a>
                            </div>
                            <div className="flex flex-col gap-3">
                                <h4 className="text-text-main font-bold mb-1">Resources</h4>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Blog</a>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Help Center</a>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Teaching Center</a>
                            </div>
                            <div className="flex flex-col gap-3">
                                <h4 className="text-text-main font-bold mb-1">Legal</h4>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Terms</a>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Privacy Policy</a>
                                <a className="text-text-secondary hover:text-primary text-sm transition-colors" href="#">Cookie Settings</a>
                            </div>
                        </div>
                        <div className="border-t border-gray-100 pt-8 flex flex-col md:flex-row justify-between items-center gap-4">
                            <p className="text-text-secondary text-xs">© 2024 LMS Inc. All rights reserved.</p>
                            <div className="flex gap-4">
                                <a className="text-text-secondary hover:text-primary transition-colors" href="#">
                                    <span className="sr-only">Twitter</span>
                                    <svg aria-hidden="true" className="h-5 w-5" fill="currentColor" viewBox="0 0 24 24"><path d="M8.29 20.251c7.547 0 11.675-6.253 11.675-11.675 0-.178 0-.355-.012-.53A8.348 8.348 0 0022 5.92a8.19 8.19 0 01-2.357.646 4.118 4.118 0 001.804-2.27 8.224 8.224 0 01-2.605.996 4.107 4.107 0 00-6.993 3.743 11.65 11.65 0 01-8.457-4.287 4.106 4.106 0 001.27 5.477A4.072 4.072 0 012.8 9.713v.052a4.105 4.105 0 003.292 4.022 4.095 4.095 0 01-1.853.07 4.108 4.108 0 003.834 2.85A8.233 8.233 0 012 18.407a11.616 11.616 0 006.29 1.84"></path></svg>
                                </a>
                                <a className="text-text-secondary hover:text-primary transition-colors" href="#">
                                    <span className="sr-only">LinkedIn</span>
                                    <svg aria-hidden="true" className="h-5 w-5" fill="currentColor" viewBox="0 0 24 24"><path clipRule="evenodd" d="M19 0h-14c-2.761 0-5 2.239-5 5v14c0 2.761 2.239 5 5 5h14c2.762 0 5-2.239 5-5v-14c0-2.761-2.238-5-5-5zm-11 19h-3v-11h3v11zm-1.5-12.268c-.966 0-1.75-.79-1.75-1.764s.784-1.764 1.75-1.764 1.75.79 1.75 1.764-.783 1.764-1.75 1.764zm13.5 12.268h-3v-5.604c0-3.368-4-3.113-4 0v5.604h-3v-11h3v1.765c1.396-2.586 7-2.777 7 2.476v6.759z" fillRule="evenodd"></path></svg>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    );
};

export default LandingPage;
