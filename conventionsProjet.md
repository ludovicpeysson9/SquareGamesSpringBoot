## Les conventions de nommage :

- ### Packages
    - Un package doit être écrit en minuscule utiliser seulement [a-z], [0-9], pas de tiret ni underscore, pas d'espace ou caractères spéciaux.  
<br>
    - Tout package doit avoir comme root un des packages suivant : com, edu, gov, mil, net, org ou les deux lettres identifiants un pays (ISO Standard 3166, 1981).

- ### Classes
    - La première lettre d'une classe doit être en majuscule
    <br>
    - Donner des noms simples et descriptifs
    <br>
    - Mélanger de minuscules et majuscules avec la première lettre de chaque nouveau mot
    <br>
    - Eviter les acronymes hormis ceux communs

- ### Interfaces
    Similaire aux classes, on peut cependant spécifier dans le nom de la classe que c'est une interface à la fin, exemple : *MenuInterface*

- ### Variables
    - La première lettre d'une variable doit être en minuscule
    <br>
    - Donner des noms simples et descriptifs
    <br>
    - Mélanger de minuscules et majuscules avec la première lettre de chaque nouveau mot
    <br>
    - Ne pas commencer les noms de variables avec $ ou _
    <br>
    - Réserver les variables d'une seule lettre pour les usages locaux :
        - **int :** i, j, k, m, n
        - **char :** c, d, e
        - **boolean :** b

- ### Constantes
    - TOUT EN MAJUSCULE    
    <br>
    - Séparer les mots par des _underscores
    <br>
    - Donner des noms simples et descriptifs
    <br>
    - N'utiliser que [A-Z], [0-9] et '_', pas d'autres caractères spéciaux!
    <br>
    - En java le mot clé définissant une constante est final

- ### Méthodes
    - Les méthodes contiennent la majeure partie du temps un verbe d'action
    <br>
    - elles s'écrivent en camelCase (avec une minuscule en première lettre du premier mot)
    <br>
    - Les classes contiennent très très souvent des getter et setter de variables, donc getVariable(), setVariable(). On retrouve aussi souvent des méthodes type : addTruc(), removeChose().

---

- ### Commentaires

    > Pas de commentaires

- ### Indentation 

    > Utiliser la tabulation entre chaque niveau