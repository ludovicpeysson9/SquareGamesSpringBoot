# Les dependances du projet

<br>

>## Le game engine
> Coeur du projet 

<br>

>## spring-boot-starter-web
> Utilisé pour build une application web compatible REST, avec une architecture MVC en utilisant un conteneur TomCat (serveur local).

<br>

>## spring-boot-configuration-processor
> Processeur de configuration. Collecte les données des annotations @ConfigurationProperties dans le classpath et génère un JSON avec des metadonnées.
Les IDE peuvent utiliser ce fichier pour suggérer de l'autocomplétion

<br>

>## spring-boot-starter-test
> Contient la majorité des éléments pour effectuer des tests. 

<br>

>## spring-boot-starter-data-jpa
> Permet de faciliter les persistances des données, autant avec des BDD relationnelles que NoSQL

<br>

>## h2
> H2 DB concerne la mémoire locale. Cela permet d'éviter une configuration + lourde d'une BDD en vue d'effectuer des tests préliminaires. 

<br>

>## spring-boot-starter
> Contient de l'autoconfiguration, logging et YAML

<br>

>## jjwt-api
> Permet de mettre en place le systeme JSON Web Token qui permet d'échanger les données en vérifiant leur intégrité grâce à des jetons (et donc d'identifier leur provenance).

<br>

>## spring-security-core
>Framework de controle d'accès/autorisations hautement configurable. Permet de se protéger contre les attaques de type cross site forgery, clickjacking, session fixation par exemple.

<br>

>## lombok
> Librairie sous licence MIT qui permet de générer du code lors de la compilation grâce à des annotations écrites en amont d'une classe.

<br>

>## spring-boot-starter-security
> Spring Security est un Framework de sécurité léger qui fournit une authentification et un support d’autorisation afin de sécuriser les applications Spring. Il est livré avec des implémentations d’algorithmes de sécurité populaires.

<br>

>## mysql-connector-j
> Driver JDBC Type 4. Implémentation en java pur du protocole MySQL. Ne s'ppuie pas sur les librairies du client MySQL