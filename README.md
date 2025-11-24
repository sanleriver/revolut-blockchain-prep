# Revolut Blockchain Prep – 8-Week Plan

**Goal:** Be 100 % ready to apply and nail the Backend Software Engineer (Java/Kotlin & Blockchain) position at Revolut.

## Roadmap (GitHub Issues)
| Week | Topic | Status | Deliverable |
|------|-------|--------|-------------|
| 0 | Repo scaffold | ✅ | This README |
| 1 | Java reactive micro-service | 🚧 | `fiat-reactive-service` |
| 2 | Kotlin + coroutines port | ⏳ | `kotlin-port` |
| 3 | Solidity 101 | ⏳ | Local ERC-20 deploy |
| 4-5 | Blockchain connector | ⏳ | Spring-Boot + web3j |
| 6 | Infra & CI/CD | ⏳ | AWS/GCP live demo |
| 7 | Security & load-test | ⏳ | Slither + Gatling report |
| 8 | Portfolio polish | ⏳ | CV, LinkedIn, story |

## How to navigate
- Each week lives in its own folder.
- `docs/` contains ADRs, C4 diagrams, security reports.
- Every merge to `main` triggers CI (Docker build + tests).

## Quick start
```bash
# Week 1 (example)
cd week-01-java-reactive
./mvnw test