// Existing functionality: Managing Users

// Function to add a user to the list dynamically
function addUserToList(user) {
    const userList = document.getElementById('userList');
    const li = document.createElement('li');
    li.textContent = `${user.name} - ${user.email} - ${user.role}`;
    userList.appendChild(li);
}

// Load users when the page loads
function loadUsers() {
    fetch('/users/')
        .then(response => response.json())
        .then(users => {
            const userList = document.getElementById('userList');
            users.forEach(user => {
                addUserToList(user);
            });
        });
}

// Event listener for adding a new user
document.getElementById('addUserForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const user = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        role: document.getElementById('role').value
    };
    
    fetch('/users/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        addUserToList(data); // Function to add user to the list dynamically
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Failed to add user'); // User feedback
    });
});

// New functionality: Managing Restaurants

// Function to add a restaurant to the list dynamically
function addRestaurantToList(restaurant) {
    const restaurantList = document.getElementById('restaurantList');
    const div = document.createElement('div');
    div.innerHTML = `
        <h2>${restaurant.name}</h2>
        <p>${restaurant.address}</p>
        <p>${restaurant.description}</p>
        <p>Facilities: ${restaurant.facilities}</p>
    `;
    restaurantList.appendChild(div);
}

// Load restaurants when the page loads
function loadRestaurants() {
    fetch('/restaurants/')
        .then(response => response.json())
        .then(restaurants => {
            const restaurantList = document.getElementById('restaurantList');
            restaurants.forEach(restaurant => {
                addRestaurantToList(restaurant);
            });
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Failed to load restaurants'); // User feedback
        });
}

// Initialize both users and restaurants loading when the page loads
window.onload = function() {
    loadUsers();       // Load users on user management page
    loadRestaurants(); // Load restaurants on restaurant overview page
};
