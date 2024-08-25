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

function addUserToList(user) {
    const userList = document.getElementById('userList');
    const li = document.createElement('li');
    li.textContent = `${user.name} - ${user.email} - ${user.role}`;
    userList.appendChild(li);
}

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

// Load users when the page loads
window.onload = loadUsers;
