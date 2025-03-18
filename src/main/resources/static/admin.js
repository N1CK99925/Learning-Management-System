async function loadAdminDashboard() {

    try {
        let response = await fetch ("http://localhost:8080/api/admin");
        let text  = await response.text();
        document.getElementById("admin-content").innerHTML = text;
    } catch (error) {
        console.error("Error Fetching Admin Details", error);

    }
    
    
}
 
window.onload = loadAdminDashboard;