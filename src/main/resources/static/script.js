function toggleForm(formType) {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');
    const loginToggle = document.getElementById('login-toggle');
    const registerToggle = document.getElementById('register-toggle');

    if (formType === 'login') {
        loginForm.classList.remove('hidden');
        registerForm.classList.add('hidden');
        loginToggle.classList.add('active');
        registerToggle.classList.remove('active');
    } else if (formType === 'register') {
        loginForm.classList.add('hidden');
        registerForm.classList.remove('hidden');
        loginToggle.classList.remove('active');
        registerToggle.classList.add('active');
    }
}

document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('login-email').value;
    const password = document.getElementById('login-password').value;
    // Add your login logic here
    console.log('Login:', email, password);
});

document.getElementById('register-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('register-username').value;
    const email = document.getElementById('register-email').value;
    const password = document.getElementById('register-password').value;
    // Add your registration logic here
    console.log('Register:', username, email, password);
});

