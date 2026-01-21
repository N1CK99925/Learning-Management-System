/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  darkMode: "class",
  theme: {
    extend: {
      colors: {
        "primary": "#ea770b",
        "primary-dark": "#c26309",
        "background-light": "#ffffff",
        "background-dark": "#f9fafa",
        "text-main": "#333333",
        "text-secondary": "#666666",
        "surface": "#ffffff",
      },
      fontFamily: {
        "display": ["Manrope", "sans-serif"],
        "sans": ["Manrope", "sans-serif"],
      },
      borderRadius: {
        "DEFAULT": "0.25rem",
        "lg": "0.5rem",
        "xl": "0.75rem",
        "2xl": "1rem",
        "full": "9999px"
      },
      boxShadow: {
        'whisper': '0px 4px 12px rgba(0, 0, 0, 0.05)',
        'whisper-hover': '0px 8px 24px rgba(0, 0, 0, 0.08)',
        'soft': '0 4px 20px -2px rgba(0, 0, 0, 0.05), 0 2px 4px -2px rgba(0, 0, 0, 0.02)',
      }
    },
  },
  plugins: [],
}
