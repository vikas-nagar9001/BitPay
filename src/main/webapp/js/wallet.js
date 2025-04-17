
// Add Money Button functionality (Toggle Form Visibility)
document.getElementById('add-money-btn').addEventListener('click', function() {
    const fundsForm = document.getElementById('funds-form');
    
    // Toggle form visibility
    if (fundsForm.style.display === "none" || fundsForm.style.display === "") {
        fundsForm.style.display = "block";
    } else {
        fundsForm.style.display = "none";
    }
});

// Close button functionality
document.getElementById('add-money-close-btn').addEventListener('click', function() {
    const fundsForm = document.getElementById('funds-form');
    fundsForm.style.display = "none"; // Hide the form
});

