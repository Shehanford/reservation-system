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
// Function to dynamically add a reservation to the page
function addReservationToList(reservation) {
    const reservationList = document.getElementById('reservationList');
    const div = document.createElement('div');
    div.innerHTML = `
        <h3>Reservation for ${reservation.customerName}</h3>
        <p>Email: ${reservation.customerEmail}</p>
        <p>Party Size: ${reservation.partySize}</p>
        <p>Time: ${new Date(reservation.reservationTime).toLocaleString()}</p>
        <p>Special Requests: ${reservation.specialRequests}</p>
    `;
    reservationList.appendChild(div);
}

// Function to load reservations from the server and display them
function loadReservations() {
    fetch('/reservations/')
        .then(response => response.json())
        .then(reservations => {
            reservations.forEach(reservation => {
                addReservationToList(reservation);
            });
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('Failed to load reservations'); // User feedback on errors
        });
}

// Event listener for handling reservation form submissions
document.getElementById('reservationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const reservation = {
        customerName: document.getElementById('customerName').value,
        customerEmail: document.getElementById('customerEmail').value,
        partySize: parseInt(document.getElementById('partySize').value),
        reservationTime: document.getElementById('reservationTime').value,
        specialRequests: document.getElementById('specialRequests').value
    };
    
    fetch('/reservations/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(reservation)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        addReservationToList(data); // Add the new reservation to the list
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Failed to make reservation'); // User feedback on errors
    });
});

// Initialize the reservation loading on page load
window.onload = function() {
    loadReservations(); // Load existing reservations when the page loads
};
