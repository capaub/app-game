# App Game

Mini-système de **quiz/jeux** en microservices :
- **ms-user** : authentification, profils joueurs.
- **ms-quizz** : gestion des quiz, questions, réponses, scores.
- **ms-front** : interface web.

## Stack
Java 17, Spring Boot 3.x, Maven, REST API, (Docker Compose en option), JUnit 5, JaCoCo.

## Architecture
```mermaid
flowchart LR
  Front[ms-front] -->|HTTP| Quizz[ms-quizz]
  Front -->|HTTP| User[ms-user]
