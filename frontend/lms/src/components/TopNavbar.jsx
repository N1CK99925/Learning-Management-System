import React from 'react';

const TopNavbar = () => {
    return (
        <header className="bg-white/80 backdrop-blur-md sticky top-0 z-10 border-b border-[#f0ece9] px-6 py-3 flex items-center justify-between gap-4">
            {/* Mobile Toggle */}
            <button className="md:hidden p-2 text-text-main">
                <span className="material-symbols-outlined">menu</span>
            </button>
            {/* Search */}
            <div className="flex-1 max-w-xl">
                <div className="relative group">
                    <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                        <span className="material-symbols-outlined text-text-muted group-focus-within:text-primary transition-colors">search</span>
                    </div>
                    <input
                        className="block w-full pl-10 pr-3 py-2.5 border-none rounded-xl bg-[#f5f2f0] text-text-main placeholder-text-muted focus:outline-none focus:ring-2 focus:ring-primary/20 focus:bg-white transition-all text-sm"
                        placeholder="Search for courses, skills, or mentors..."
                        type="text"
                    />
                </div>
            </div>
            {/* Actions */}
            <div className="flex items-center gap-4">
                <button className="relative p-2 text-text-main hover:bg-gray-50 rounded-full transition-colors">
                    <span className="material-symbols-outlined">notifications</span>
                    <span className="absolute top-2 right-2 size-2 bg-red-500 rounded-full border border-white"></span>
                </button>
                <div className="h-8 w-[1px] bg-[#f0ece9]"></div>
                <button className="flex items-center gap-3 pl-1 pr-2 py-1 rounded-full hover:bg-gray-50 border border-transparent hover:border-[#f0ece9] transition-all">
                    <div
                        className="size-8 rounded-full bg-cover bg-center ring-2 ring-white shadow-sm"
                        data-alt="Portrait of a young male student named Alex"
                        style={{ backgroundImage: 'url("https://lh3.googleusercontent.com/aida-public/AB6AXuBfoEoh_tL5AkhCtS4D5IO7k6qgUuLgBLkp5mv8Hu3keIl7pvPIowO4iaJ4a_SdCR7YrDzC5hWuHzrhw2lqAzH2ZNAf5za9tsmZnzpLDjZjQj8MXk6chvQh8DSP7K7gvucEAvHWT9VAPgMVYXg6G41nxTGlEGPz3wR5gzliKgxXPtNCHWH7KYbItTj3on3gWnRDnghhmCIKXewSo_kiEGsA7OzLhgWrMC6UXgXr4hxk_ikThXDFwrgk6B-QNwQxvjVYU__lBWQyEfa-")' }}
                    ></div>
                    <div className="hidden sm:block text-left">
                        <p className="text-sm font-bold text-text-main leading-none">Alex M.</p>
                        <p className="text-xs text-text-muted leading-tight mt-0.5">Student</p>
                    </div>
                    <span className="material-symbols-outlined text-text-muted text-[18px]">expand_more</span>
                </button>
            </div>
        </header>
    );
};

export default TopNavbar;
