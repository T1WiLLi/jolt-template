# Projet de départ pour Jolt
Template GitHub pour les projets de démarrage avec le framework Jolt.

---
## Table des matières

- [Environnement de développement](#environnement-de-développement)
- [Premier démarrage](#premier-démarrage)
- [Configuration de l'application](#configuration-de-lapplication)
- [Propriétés de l'application](#propriétés-de-lapplication)
- [Certificats SSL](#certificats-ssl)
- [Variables d'environnement](#variables-denvironnement)
- [Support](#support)

---

## Environnement de développement

### Prérequis

Assurez-vous d'avoir les outils suivants installés et à jour sur votre système :

- **[Moteur Docker](https://www.docker.com/)** - Requis pour l'environnement de développement
- **[Git](https://git-scm.com/)** - Requis pour la gestion de version
- **[JDK-21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)** - Version minimale requise

### Outils recommandés (optionnels)

- **[OpenSSL](https://www.openssl.org/)** - Pour la gestion des certificats SSL/TLS
- **[Extension Freemarker](https://marketplace.visualstudio.com/items?itemName=dcortes92.FreeMarker)** - Si vous utilisez Visual Studio Code
- **[Maven](https://maven.apache.org/)** - Pour la gestion des dépendances (fourni par défaut dans docker-compose)

---

## Premier démarrage

### 1. Créer un nouveau dépôt

Créez un nouveau dépôt sur GitHub en utilisant l'option **"Use this template"** puis sélectionnez **"Create a new repository"**.

### 2. Cloner le dépôt

Une fois le dépôt créé, clonez-le sur votre système local :

```shell
git clone https://github.com/your-username/your-repo-name.git
```

> **Note :** Remplacez `your-username` par votre nom d'utilisateur GitHub et `your-repo-name` par le nom de votre dépôt.

### 3. Lancer l'environnement de développement

Démarrez l'environnement de développement avec la commande suivante :

```shell
docker compose up --watch
```

Cette commande va :

-   Lancer les conteneurs Docker nécessaires
-   Activer le rechargement automatique avec le paramètre `--watch`
-   Rendre l'expérience de développement plus fluide

----------

## Configuration de l'application

### Accès par défaut

L'application est configurée par défaut pour être accessible à l'adresse :

-   **URL :** `https://localhost`
-   **Redirection HTTP → HTTPS :** Activée

### Configuration par défaut

Voici la configuration complète par défaut de l'application :

```properties
# Configuration de base de l'application Jolt
# La plupart des paramètres sont optionnels et servent d'exemple
# Pour la documentation complète : https://jolt-framework.org/

# Propriétés générales de l'application Jolt
server.appName=Jolt-Template
server.port=80

# Configuration générale du serveur
server.directory.listing=false

# Configuration HTTP & HTTPS
server.http.enabled=true
server.http.redirect=true
server.ssl.enabled=true
server.ssl.port={SSL_PORT}
server.ssl.keyStore={SSL_KEYSTORE}
server.ssl.keyStorePassword={SSL_KEYSTORE_PASSWORD}
server.ssl.keyAlias={SSL_KEY_ALIAS}

# Configuration de sécurité
server.security.secret_key={SECRET_KEY}
server.security.pepper={PEPPER}

# Configuration des sessions
session.lifetime=900
session.httponly=true
session.secure=true
session.path=/
session.samesite=Strict

# Configuration de la base de données
db.url={DATABASE_URL}
db.username={DATABASE_USERNAME}
db.password={DATABASE_PASSWORD}

# Configuration des fichiers multipart (valeurs par défaut)
server.multipart.maxFileSize=1048576
server.multipart.maxRequestSize=10485760
server.multipart.fileSizeThreshold=0

# Configuration de la langue
server.defaultLanguage=fr
```
----------
## Propriétés de l'application

### Configuration générale du serveur

| Propriété | Valeur par défaut | Description |
|-----------|-------------------|-------------|
| `server.appName` | "My App" | Définit le nom de l'application |
| `server.port` | 80 | Définit le port HTTP |
| `server.tempDir` | "/tmp" | Définit le répertoire temporaire pour Tomcat |
| `server.directory.listing` | false | Active/désactive la liste des répertoires |
| `server.directory.listing.path` | "/directory" | Définit le chemin pour la liste |
| `server.threads.min` | 10 | Nombre minimum de threads |
| `server.threads.max` | 100 | Nombre maximum de threads |
| `server.daemon` | true | Statut daemon |
| `server.logging.level` | INFO | Niveau de journalisation |
| `server.logging.logfile` | "jolt.log" | Fichier de log (l'active) |

### Configuration des sessions

| Propriété | Valeur par défaut | Description |
|-----------|-------------------|-------------|
| `session.lifetime` | 900 | Durée de vie de la session (secondes) |
| `session.httponly` | true | Session HTTP uniquement |
| `session.secure` | true | Session sécurisée |
| `session.path` | "/" | Chemin de la session |
| `session.samesite` | "strict" | Politique SameSite |
| `session.encrypt` | false | Chiffrement de la session |
| `session.expirationSliding` | false | Expiration glissante |

### Configuration de sécurité

| Propriété | Description |
|-----------|-------------|
| `server.security.secret_key` | Clé secrète globale (valeur base64 aléatoire) |
| `server.security.pepper` | Pepper pour le hachage (valeur base64 aléatoire) |

### Configuration HTTP & HTTPS

| Propriété | Valeur par défaut | Description |
|-----------|-------------------|-------------|
| `server.ssl.enabled` | false | Active SSL |
| `server.ssl.port` | 443 | Port SSL |
| `server.ssl.keyStore` | "keystore.jks" | Keystore |
| `server.ssl.keyStorePassword` | "password" | Mot de passe du keystore |
| `server.ssl.keyAlias` | "alias" | Alias de la clé |
| `server.http.enabled` | true | Active HTTP |
| `server.http.redirect` | true | Redirection HTTP vers HTTPS |

### Configuration de la base de données

| Propriété | Exemple | Description |
|-----------|---------|-------------|
| `db.url` | "jdbc:mysql://localhost:3306/mydb" | URL de la base de données |
| `db.username` | "myuser" | Nom d'utilisateur |
| `db.password` | "mypassword" | Mot de passe |

### Configuration de gestion des fichiers

| Propriété | Valeur par défaut | Description |
|-----------|-------------------|-------------|
| `server.multipart.maxFileSize` | 1048576 | Taille maximale d'un fichier (octets) |
| `server.multipart.maxRequestSize` | 10485760 | Taille maximale d'une requête (octets) |
| `server.multipart.fileSizeThreshold` | 0 | Seuil de taille de fichier |

### Configuration de localisation

| Propriété | Valeur par défaut | Description |
|-----------|-------------------|-------------|
| `server.lang` | "fr" | Langue par défaut (active la localisation) |
----------

## Certificats SSL

### Certificats de développement

Les certificats SSL fournis par défaut sont **uniquement pour le développement** et ne doivent **jamais être utilisés en production**.

### Certificats de production

Pour déployer en production :

1.  Générez des certificats SSL valides
2.  Remplacez les certificats dans le dossier `./certs` de votre projet
3.  Mettez à jour les variables d'environnement correspondantes

### Génération de certificats

Pour générer des certificats auto-signés pour le développement :

```shell
openssl req -x509 -newkey rsa:4096 -keyout key.pem -out cert.pem -days 365 -nodes
```
> **Note :** Les certificats fourni dans le projet par défaut devrait être suffisant pour du développement.

----------

## Variables d'environnement

### Fichier .env

Un fichier `.env` est fourni dans le dossier racine du projet. Ce fichier contient des variables d'environnement **sensibles** qui doivent être configurées avant le déploiement.

### Variables importantes à configurer

```properties
# Security (I'd heavily recommend changing the values to be 'real' secrets !)
SECRET_KEY=k7J9mX2vQ8pL4wR6tN3yH5zA1sF8dG0bV9cE7uI6oP2mK4jL3nM5qR8tY1wX0zA9
PEPPER=9H2XqcBZl3fKJ7tD5vEgRm0pYnT8W4uPQsSNjV6AyOIxLzFhGdUMbC1o

# SSL (You can swap in your own SSL certificates here, Also configure either mac-setup-ssl.sh or win-setup-ssl.bat depending on your OS to generate the SSL certificates)
SSL_PORT=443
SSL_KEYSTORE=/app/tmp/tomcat/certs/keystore.p12
SSL_KEYSTORE_PASSWORD=jolt_keystore
SSL_KEY_ALIAS=jolt-app

# Database (I'd recommand changing this !)
DATABASE_URL=jdbc:postgresql://postgres:5432/jolt_db
DATABASE_USERNAME=admin
DATABASE_PASSWORD=admin
```

### ⚠️ Sécurité importante

-   **Ne jamais** commiter le fichier `.env` avec des valeurs réelles
-   Générez des valeurs aléatoirement pour `SECRET_KEY` et `PEPPER`
-   Utilisez des mots de passe forts pour la base de données et les keystores

> **Note :** Afin d'éviter de commit votre ***.env*** avec des valeurs réelle, vous pouvez exécuter : 
> ````shell
> git rm -rf .env
> ````
> Puis, dans le .gitignore, rajouter ***.env*** comme élément à ignorer.

----------

## Support

### À propos de Jolt

Jolt est un framework de développement web open-source conçu pour simplifier la création d'applications web Java robustes et sécurisées.

### Obtenir de l'aide

-   **Documentation :** [https://jolt-framework.org/](https://jolt-framework.org/)
-   **Issues :** Créez une issue sur ce [dépôt Github](https://github.com/T1WiLLi/Jolt)
-   **Communauté :** Rejoignez notre communauté pour obtenir de l'aide

### Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

-   Signaler des bugs
-   Proposer des améliorations
-   Soumettre des pull requests

----------

## Licence

Ce projet est sous licence [MIT](LICENSE).

----------

**Merci d'utiliser Jolt !** 🚀