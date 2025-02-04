# Exercice de Clean Code et de réusinage

**GLO-2003: Processus du génie logiciel**

---

## 1. Consignes

Le but de cet exercice est de mettre en pratique le Clean Code et le réusinage de code (refactoring). Pour ce faire, 
nous vous fournissons un code de base à nettoyer et réusiner. Le code de base viole volontairement les principes de 
Clean Code de Robert C. Martin [1] et présente de mauvaises pratiques de programmation. Vous devez nettoyer le code 
et le réusiner afin de faciliter l’ajout d’une fonctionnalité. Vous devez aussi noter les grandes lignes des 
modifications que vous avez réalisées pour un retour en classe.

Cet exercice peut être réalisé seul ou en équipe de 2 à 3 personnes. Nous vous conseillons de réaliser l’exercice en 
Pair Programming. Nous vous recommandons aussi de créer un repository GitHub pour partager le code entre les membres 
de l’équipe et de faire un commit par étape. Une solution sera proposée en Java sur le repository de l’exercice.

L'exercice est disponible en deux versions : 
- [Version courte](https://github.com/glo2003/Exercice-CleanCode-Refactoring-Court)
- [Version longue](https://github.com/glo2003/Exercice-CleanCode-Refactoring)

---

## 2. Contexte

Vous venez d’être engagé en tant que consultant dans une start-up offrant des outils de gestion de personnel. Suite 
à une croissance rapide accompagnée de nombreux changements à la base de code, ils se retrouvent maintenant avec une 
productivité abyssale à cause de la pauvre qualité du code.

Votre mandat est de coacher les employés afin de leur donner les connaissances nécessaires pour améliorer la qualité 
de leur code tout en continuant de livrer de nouvelles fonctionnalités.

En guise d’exemple, vous vous attaquez au module de paie `payroll` qui présente plusieurs **code smells** et mauvais 
designs. Les employés de la start-up vous expliquent que le module de paie permet de gérer les employés, la création 
de chèques de paie, la gestion des vacances (seulement pour la version longue) et quelques statistiques sur la paie.

---

## 3. Tâche

On désire ajouter un nouveau type d’employé au module de paie : un employé à contrat qui n’est payé qu’à la fin de 
certains milestones du projet. Les employés à contrat ne peuvent pas prendre de jours de vacances 
(seulement pour la version longue).

Toutefois, étant donné la pauvre qualité du code, cet ajout se révèle être tout un défi. Le code viole les principes 
de Clean Code et présente de mauvais designs. Vous relevez notamment que le code est exceptionnellement impropre et 
que la classe `CompanyPayroll` ressemble à une **god class** avec toute la logique centralisée dans cette classe.

Vous procédez en trois étapes pour ajouter la nouvelle fonctionnalité :

1. **Clean Code** : Nettoyage du code pour qu’il respecte davantage les principes du Clean Code.
2. **Refactoring** : Réusinage du code pour faciliter l’ajout de la nouvelle fonctionnalité.
3. **Ajout de fonctionnalité** : Implémentation du nouveau type d’employé.

Vous pouvez modifier le code à votre guise, tant que vous réparez les tests pour qu’il compile après chaque étape.

### 3.1 Clean Code

Profitez de cette phase pour vous familiariser avec la base de code en le nettoyant. Nous vous recommandons aussi 
de vous familiariser avec les outils de réusinage présents dans tout bon environnement de développement.

### 3.2 Refactoring

Maintenant que vous avez pris vos marques dans la base de code, il est temps de le réusiner afin de faciliter 
l’ajout du nouveau type d’employé à contrat.

### 3.3 Ajout de fonctionnalité

Une fois le code propre, il devrait être facile d’ajouter le nouveau type d’employé. L’employé à contrat est 
payé uniquement lors de la complétion de certains **milestones** du projet.

- Un **milestone** est complété à chaque paie.
- Lorsqu’on crée un employé avec une liste de montants `[100, 200, 300]`, l’employé sera payé 100\$ à la première paie, 
200\$ à la suivante, puis 300\$ à la dernière.
- Après la fin du contrat, l’employé ne peut plus recevoir de paie.
- Ces employés peuvent recevoir des augmentations de salaire qui sont ajoutées au montant du **milestone** courant.
- Une augmentation n’est plus possible après la fin du contrat.
- Les employés à contrat ne peuvent pas prendre de journées de vacances (seulement pour la version longue).

---

## 4. Solution

La solution de cet exercice se trouve dans ce dépot sur différentes branches. 

Il y a une branche par étape de la solution :

- `clean` : après le nettoyage du code.
- `refactoring` : après le réusinage.
- `new-feature` : après l’ajout de la nouvelle fonctionnalité.

Les fichiers `CLEAN.md` et `REFACTORING.md` résument les changements apportés lors des différentes phases.

---

## Références

[1] Robert C. Martin. *Clean Code: A Handbook of Agile Software Craftsmanship*. Prentice Hall PTR, USA, 1ère édition, 2008. ISBN 0132350882.
