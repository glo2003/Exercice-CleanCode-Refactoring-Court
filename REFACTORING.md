# Réusinage

Ce document résume les différentes étapes effectuées pour réusiner le code.

1. Ajout de la méthode abstraite `getPayForTwoWeeks` dans la classe `Employee`
    1. Déplacement du code de `createPendingPaycheck` dans les sous-classes
    2. Permet de retirer les `instanceof` dans `CompanyPayroll`
2. Ajout de la méthode abstraite `giveRaise` dans la classe `Employee`
    1. Similaire au point 1.
3. Supression des méthodes qui ne sont plus utilisées
4. Changer le type de `Employee.role` pour un `enum`
5. Ajouter des exception personalisées
    1. `InvalidRaiseException`
    2. `EmployeeDoesNotWorkHereException`
    3. `NoEmployeeException`
