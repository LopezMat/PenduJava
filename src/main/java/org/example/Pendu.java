package com.example;

import java.util.Scanner;  // Import de la classe Scanner pour lire les entrées utilisateur

public class Pendu {
    public static void main(String[] args) {
        // Liste des mots possibles à deviner
        String[] mots = {
                "chat", "robotique", "pomme", "joueur", "éléphant", "gâteau",
                "programmation", "veste", "jardin", "tigre", "chocolat", "école",
                "rugbyman", "fourmi", "salade", "développeur", "maillot", "ciel",
                "carotte", "surfer", "mouton", "bois", "interface", "tortue",
                "étoile", "régime", "jupe", "basketball", "cerise", "golf", "brocoli",
                "surf", "robot", "tacos", "chaussures", "lune", "sushi", "plage",
                "orange", "manteau", "jaune", "pêche", "pompier", "rivières", "pingouin",
                "magasin", "chapeau", "algorithme", "vent", "scie", "souris", "dauphin",
                "lavande", "hôpital", "musicien", "beige", "manteau", "coq", "nuage",
                "lait", "coiffeur", "cheval", "fleur", "ananas", "athlétisme",
                "t-shirt", "villager", "mer", "bicyclette", "devis", "volleyball",
                "hockey", "chocolat", "robot", "développeur", "jalousie", "plage", "pizza",
                "kiwi", "maison", "neige", "médicament", "plante", "tortue", "horizon",
                "campagne", "banane", "avocat", "crocodile", "montagne", "données", "robot",
                "sourire", "sac", "mangeoire", "froid", "indigo", "serpent", "tigre",
                "désert", "zèbre", "fouette", "nettoyage", "coeur", "cuisine", "horizontale",
                "carrière", "travail", "nappe", "éléphant", "fleur", "élan", "salon",
                "chantier", "difficulté", "journaliste", "infirmier", "éclair", "tentation"
        };

        // Choisir un mot aléatoire dans le tableau "mots"
        String motADeviner = mots[(int) (Math.random() * mots.length)];

        // Tableau pour stocker les lettres trouvées (initialement toutes cachées par des underscores '_')
        char[] motCache = new char[motADeviner.length()];
        for (int i = 0; i < motCache.length; i++) {
            motCache[i] = '_';  // Initialisation du tableau avec des '_', symbolisant les lettres à deviner
        }

        // Nombre de tentatives que l'utilisateur peut effectuer avant de perdre
        int tentativesRestantes = 8;
        // Variable pour savoir si le mot a été deviné ou non
        boolean motDevine = false;

        // Création d'un objet Scanner pour lire les lettres saisies par l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Boucle principale du jeu
        while (tentativesRestantes > 0 && !motDevine) {
            // Afficher l'état actuel du mot (avec les lettres devinées ou cachées par des '_')
            System.out.println("Mot à deviner : " + new String(motCache));
            System.out.println("Tentatives restantes : " + tentativesRestantes);
            System.out.print("Devinez une lettre : ");

            // Lecture de la lettre saisie par l'utilisateur
            char lettre = scanner.nextLine().charAt(0);

            // Variable pour savoir si la lettre devinée est dans le mot
            boolean lettreTrouvee = false;

            // Boucle pour parcourir le mot à deviner et vérifier si la lettre est présente
            for (int i = 0; i < motADeviner.length(); i++) {
                // Si la lettre est trouvée à une position donnée, elle est dévoilée dans le mot caché
                if (motADeviner.charAt(i) == lettre) {
                    motCache[i] = lettre;
                    lettreTrouvee = true;
                }
            }

            // Si la lettre n'a pas été trouvée, on décrémente le nombre de tentatives restantes
            if (!lettreTrouvee) {
                tentativesRestantes--;
                System.out.println("Lettre incorrecte !");
            } else {
                // Si la lettre est correcte, on informe l'utilisateur
                System.out.println("Bonne lettre !");
            }

            // Vérification si le mot est entièrement deviné
            motDevine = true;  // On suppose que le mot est deviné
            for (char c : motCache) {
                // Si une lettre est encore cachée (représentée par '_'), cela signifie que le mot n'est pas encore deviné
                if (c == '_') {
                    motDevine = false;  // Le mot n'est pas encore complètement deviné
                    break;
                }
            }
        }

        // Si le mot a été deviné
        if (motDevine) {
            System.out.println("Félicitations, vous avez deviné le mot : " + motADeviner);
        } else {
            // Si toutes les tentatives ont été utilisées
            System.out.println("Désolé, vous avez perdu. Le mot était : " + motADeviner);
        }

        // Fermeture du scanner pour éviter les fuites de ressources
        scanner.close();
    }
}
