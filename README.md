# ProjetInfo-Clans

**Auteurs:**
Maxime Morin,
Johanne Calcoen,
Hugo Paris,
Louise Villette

(IMT Lille-Douai: Projet Informatique)

**Descriptif:**
  Dans le cadre de l'UV Projet Informatique, nous devons travailler sur le code déjà existant du jeu "Clans". Ce code n'est pas complet. Nous devons l'agrémenter de condtructeurs et de méthodes diverses pour rendre le jeu possible.
  Dans un deuxième temps, nous devons créer une IA contre laquelle un joueur humain peut jouer.

**Journal de Bord :**


séance 0 (lundi 30 mars) : choix du projet et constitution du groupe + attribution des exos 1 à 4


séance 1 (mardi 31 mars) : correction et test des exos 1 à 4 + explication de la partie 2 : stratégie d'IA.


séance 2 (lundi 20 avril) : création d'une stratégie et découpage en petites tâches


séance 3 (mardi 21 avril) : encodage de la stratégie en Java


séance 4 (lundi 27 avril): création, test et amélioration strat46 + commencer présentation pour 6 mai


séance 5 (mardi 28 avril): mise en commun de toutes les données recueillies + commencer préparation pour présentation orale + finir améliorations et rdaction du code & annexes



**Organisation générale du travail:**
- répartition par tâches (du code à écrire pour tout le monde)
- travail un max en peer to peer (Maxime & Hugo surtout)
- Johanne code les méthodes un peu indépendantes
- mettre toutes les petits bouts de codes ensemble pour créer la strat complète par Maxime et Louise
- rédaction du README et project monitoring par Louise
- test et révisions du code par tout le monde
- jouer contre autre IA ou contre notre IA par Hugo et Maxime, puis Johanne en fin de projet

**Indications pour utiliser notre IA:**


- Pour faire un combat simple entre 2 stratégies : aller dans le main de 'TournoisClans' et lancer 'combatSimple(stratégieA,stratégieB'). Pour simuler N parties il faut lancer 'combatMultiples(stratégieA,stratégieB,N)'.


- Pour simuler un tournoi : on utilise le tableau' int strategies[] = {0,1,2,3,4,5,6,7,8,9,46}', et on lance 'lanceTournoi(strategies,N)'.


- Pour jouer contre notre IA : on lance 'testStrat(46)'

