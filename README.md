App Game — mini-suite de microservices pour gérer des quiz/jeux :
ms-user (auth & profils), ms-quizz (quiz/questions/scores), ms-front (UI).
Stack : Java 17 / Spring Boot 3, REST, (option Docker Compose), tests JUnit.

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
