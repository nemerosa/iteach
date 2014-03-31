var map_fr = {
    // General
    'language.en': 'English',
    'language.fr': 'Français',
    'yes': "Oui",
    'no': "Non",
    'calendar.dateFormat': 'EEE d MMMM yyyy',
    'dialog.ok': 'OK',
    'dialog.cancel': 'Annuler',
    'dialog.update': "Modifier",
    'dialog.delete': "Supprimer",
    'logout': "Se déconnecter",
    // Home page
    'home.back': "Fermer",
    // Login page
    'login.iteach.message': "iTeach est l'application qui va vous aider à organiser vos lessons et votre planning.",
    'login.signin.google': 'Se connecter avec Google',
    'login.signin.with': 'Se connecter avec',
    'login.signin.form': 'Se connecter avec iTeach',
    'login.signin.form.email': 'Entrez votre adresse mail',
    'login.signin.form.password': 'Entrez votre mot de passe',
    'login.signin.form.submit': 'Se connecter',
    'login.signin.form.register': "S'enregistrer",
    'login.error': "Impossible de se connecter à iTeach. Veuillez vérifier vos données de connexion.",
    'login.error.openid_registration_non_valid': "Impossible de se connecter à iTeach. Votre compte n'a pas encore été vérifié ou a été désactivé.",
    'login.error.openid_failed': "Impossible de se connecter à iTeach. Votre OpenID ne peut pas être vérifié ou accédé.",
    // Register page
    'register.name': 'Votre nom',
    'register.email': 'Votre adresse mail',
    'register.password': 'Votre mot de passe',
    'register.password_confirm': 'Confirmation du mot de passe',
    'register.submit': 'Envoyer',
    'register.cancel': 'Annuler',
    'register.incorrect_password_confirmation': "La confirmation du mot de passe n'est pas correcte.",
    'register.success': "L'enregistrement a été acceptée. Vous allez bientôt recevoir un mail qui contiendra un" +
        " lien. Suivez les instructions contenues dans le mail pour compléter votre enregistrement.",
    'register.result.ko': "L'enregistrement n'a pas pu être complété. Veuillez contacter l'équipe d'iTeach pour plus" +
        " d'information.",
    'register.result.ok': "L'enregistrement est maintenant terminé. Veuillez vous connecter pour commencer à" +
        " utiliser iTeach.",
    'register.result.login': "Continuer avec la connexion",
    // Model
    'teacher.planning': "Mon planning",
    'teacher.schools': "Mes écoles",
    'teacher.newSchool': "Nouvelle école",
    'teacher.students': "Mes étudiants",
    'teacher.newStudent': "Nouvel étudiant",
    'school': 'Ecole',
    'school.name': "Nom",
    'school.name.error': "Le nom de l'école est obligatoire.",
    'school.colour': "Couleur",
    'school.colour.error': "La couleur sélectionnée n'est pas correcte.",
    'school.contact': "Contact",
    'school.hourlyRate': "Taux horaire",
    'school.hourlyRate.help': 'Taux horaire (HTVA). Par exemple, EUR 45.00 ou 45.00 (EUR par défaut)',
    'school.hourlyRate.error.format': "Le format du taux horaire doit être EUR 45.00 ou 45.00.",
    'school.phone': 'Téléphone',
    'school.mobilePhone': 'Portable',
    'school.postalAddress': 'Adresse postale',
    'school.webSite': 'Site internet',
    'school.webSite.error': "L'adresse du site Web n'est pas valide.",
    'school.vat': "Numéro de TVA",
    'school.vat.help': "Numéro de TVA utilisé pour la génération de factures pour cette école.",
    'school.vatRate': "Taux de TVA (%)",
    'school.vatRate.help': "Taux de TVA à appliquer pour cette école (laisser à blanc si la TVA n'est pas applicable)",
    'school.vatRate.error': "Le taux de TVA doit être un nombre décimal valide.",
    'school.email': 'Email',
    'school.email.error': "L'adresse email n'est pas valide.",
    'school.delete.prompt': "Voulez-vous vraiment supprimer cette école ? Les étudiants et leçons associés seront également effacés.",
    'school.students': "Ses étudiants",
    // Student
    'student': "Etudiant",
    'student.school': "Ecole",
    'student.name': "Nom",
    'student.name.error': "Le nom de l'étudiant est obligatoire.",
    'student.subject': "Sujet / Matière",
    'student.phone': 'Téléphone',
    'student.mobilePhone': 'Téléphone mobile',
    'student.postalAddress': 'Adresse postale',
    'student.email': 'Email',
    'student.email.error': "L'adresse email n'est pas valide.",
    'student.disable': "Désactiver",
    'student.disable.message': "Cet étudiant a été désactivé. Vous pouvez le réactiver en cliquant sur le " +
        "bouton 'Activer' ci-dessous",
    'student.enable': "Activer",
    'student.disable.prompt': "Désactiver cet étudiant va l'enlever de la liste des étudiants et du rapport " +
        "mensuel, mais il restera visible dans la liste des étudiants de l'école et dans la liste des lessons. " +
        "L'étudiant pourra être réactivé plus tard.",
    'student.delete.prompt': "Voulez-vous vraiment supprimer cet étudiant ? Les leçons associées seront également effacées.",
    'student.lessons': "Ses leçons",
    // Lesson
    'lesson': "Leçon",
    'lesson.tip': "Créez une nouvelle leçon en fournissant une date, une période, un étudiant et éventuellement un emplacement.",
    'lesson.student': "Etudiant",
    'lesson.school': "Ecole",
    'lesson.student.error': "Un étudiant doit être sélectionné.",
    'lesson.date': "Date",
    'lesson.from': "De",
    'lesson.to': "à",
    'lesson.location': "Emplacement",
    'lesson.schedule': "Planning",
    'lesson.delete.prompt': "Voulez-vous vraiment supprimer cette leçon ? Les commentaires associés seront également supprimés.",
    // Comments
    'comments': "Commentaires",
    'comment.create': "Ajouter un commentaire",
    // Admin
    'admin.page': "Administration",
    'admin.accounts': "Gestion des comptes utilisateurs",
    'admin.account.name': "Nom",
    'admin.account.email': "Email",
    'admin.account.administrator': "Administrateur",
    'admin.account.authenticationMode': "Mode d'authetification",
    'admin.account.authenticationMode.PASSWORD': "Mot de passe",
    'admin.account.authenticationMode.OPEN_ID': "Open ID",
    'admin.account.verified': "Vérifié",
    'admin.account.disabled': "Désactivé",
    'admin.account.delete.prompt': "Voulez-vous vraiment supprimer cet utilisateur ? Les données associées seront également supprimées.",
    'admin.account.import': "Importer",
    'admin.account.import.title': "Importer des données pour {{name}}",
    'admin.account.import.message': "Sélectionnez un fichier JSON préalablement exporté depuis iTeach.",
    'admin.account.import.warning': "Attention ! L'import des données va écraser toutes les données précédentes de {{name}}.",
    'admin.account.import.success': "L'importation des données a réussi.",
    // Profile
    'account.profile': "Profil",
    'account.profile.company': "Entreprise",
    'account.profile.company.logo': "Logo de l'entreprise",
    'account.profile.company.logo.help': "Lien vers le logo de l'entreprise (doit pointer vers une image)",
    'account.profile.postalAddress': "Adresse",
    'account.profile.phone': "Téléphone",
    'account.profile.vat': "Numéro de TVA",
    'account.profile.vat.help': "Numéro de TVA de l'entreprise, utilisé pour la génération des factures.",
    'account.profile.iban': "IBAN",
    'account.profile.bic': "BIC",
    'account.profile.invoiceLastNb': "Dernier numéro de facture",
    'account.profile.invoiceLastNb.help': "Le prochain numéro de facture sera égal à ce numéro, plus un.",
    // Reporting
    'report.total': "Total",
    'report.monthly': "Rapport mensuel",
    'report.hours.total': "Nombre total d'heures",
    'report.hours.period': "Nombre d'heure pour le mois",
    'report.income.total': "Revenu total",
    // Invoicing
    'invoice.generate': "Générer une facture",
    'invoice.month': "Année & Mois",
    'invoice.number': "Numéro de facture",
    'invoice.print': "Imprimer"
};