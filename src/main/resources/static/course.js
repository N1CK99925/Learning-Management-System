// Sample course data
const courses = [
    { name: "JavaScript Basics", price: "$49.99" },
    { name: "Advanced CSS", price: "$39.99" },
    { name: "React for Beginners", price: "$59.99" },
    { name: "Node.js Fundamentals", price: "$69.99" },
  ];
  
  // Function to display courses
  function displayCourses() {
    const courseList = document.getElementById("courseList");
    courseList.innerHTML = ""; // Clear existing content
  
    courses.forEach(course => {
      const courseDiv = document.createElement("div");
      courseDiv.className = "course";
      courseDiv.innerHTML = `
        <h3>${course.name}</h3>
        <p>Price: ${course.price}</p>
      `;
      courseList.appendChild(courseDiv);
    });
  }
  
  // Function to handle login/logout
  let isLoggedIn = false;
  
  function toggleAuthButtons() {
    const loginButton = document.getElementById("loginButton");
    const profileButton = document.getElementById("profileButton");
  
    if (isLoggedIn) {
      loginButton.style.display = "none";
      profileButton.style.display = "block";
    } else {
      loginButton.style.display = "block";
      profileButton.style.display = "none";
    }
  }
  
  // Event listeners
  document.getElementById("homeButton").addEventListener("click", () => {
    alert("Returning to Home...");
    // Add logic to redirect to home page
  });
  
  document.getElementById("loginButton").addEventListener("click", () => {
    isLoggedIn = true;
    toggleAuthButtons();
    alert("Logged in successfully!");
  });
  
  document.getElementById("profileButton").addEventListener("click", () => {
    alert("Redirecting to Profile...");
    // Add logic to redirect to profile page
  });
  
  // Initialize the page
  displayCourses();
  toggleAuthButtons();