# App Game

[![CI](https://github.com/capaub/app-game/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/capaub/app-game/actions/workflows/ci.yml)
![Java](https://img.shields.io/badge/Java-17-informational)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-informational)
![Front](https://img.shields.io/badge/Front-Angular-informational)

**App Game** — mini-suite microservices pour quiz/jeux :
- `msUser` : comptes / authentification
- `msQuizz` : quiz, questions, réponses, scores
- `msFront` : interface web (Angular)

Stack : **Java 17 · Spring Boot 3 · REST · Angular** (Docker Compose en option)

---

## Architecture
```mermaid
flowchart LR
  Front[msFront (Angular)] -->|HTTP| Quizz[msQuizz (REST)]
  Front -->|HTTP| User[msUser (REST)]
