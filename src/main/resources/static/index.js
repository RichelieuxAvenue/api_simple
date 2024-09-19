// Récupérer les éléments du DOM (Document Object Model) par leur ID
const happyBtn = document.getElementById('happyBtn');
const notHappyBtn = document.getElementById('notHappyBtn');
const formContainer = document.getElementById('formContainer');
const submitBtn = document.getElementById('submitBtn');

// Ajouter un événement de clic au bouton "Je suis content"
happyBtn.addEventListener('click', function() {
    afficherFormulaire("Je suis content 😊");
});

// Ajouter un événement de clic au bouton "Je ne suis pas content"
notHappyBtn.addEventListener('click', function() {
    afficherFormulaire("Je ne suis pas content 😔");
});

// Fonction pour afficher le formulaire lorsque l'utilisateur clique sur un bouton
function afficherFormulaire(message) {
    formContainer.style.display = 'block'; // Affiche le formulaire
}

// Ajouter un événement de clic au bouton d'envoi du formulaire
submitBtn.addEventListener('click', function() {
    // Récupérer les valeurs du formulaire
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

    // Valider les champs avant d'envoyer les données
    if (name === "" || email === "") {
        alert("Veuillez remplir tous les champs.");
        return;
    }

    // Créer un objet utilisateur à envoyer
    const utilisateur = {
        name: name,
        email: email
    };

    // Envoyer l'objet utilisateur vers l'API (ici, on suppose que l'API est à /api/utilisateurs)
    fetch('/api/utilisateurs', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(utilisateur)
    })
        .then(response => response.json())
        .then(data => {
            alert("Merci ! Vos informations ont été enregistrées.");
            // Masquer le formulaire après soumission
            formContainer.style.display = 'none';
        })
        .catch(error => {
            console.error('Erreur lors de l\'envoi des données:', error);
            alert("Une erreur est survenue. Veuillez réessayer.");
        });
});