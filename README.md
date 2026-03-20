# VelocityOdds
VelocityOdds is a mission-critical data pipeline designed to solve the 'Last Mile' problem in sports betting: ensuring live odds reach the user's screen before the market moves. It showcases an optimised stack using Java 25's Virtual Threads to achieve massive I/O throughput on a lean infrastructure.

---

## 🏗️ The "FanDuel-Grade" Architecture

To handle the "Super Bowl Scale," this project moves away from traditional blocking I/O and embraces a modern, reactive-style infrastructure:

* **Execution Model:** Powered by **Java 25 Virtual Threads**. This allows the engine to handle thousands of concurrent data streams and user connections with a fraction of the RAM required by standard threads.
* **Real-Time Transport:** Uses **STOMP-over-WebSockets** to push updates. No polling, no wasted HTTP overhead.
* **State Management:** * **Redis (Hot Layer):** Acts as the primary "Source of Truth" for live prices and the message broker for scaling.
    * **PostgreSQL (Cold Layer):** Stores transactional history for auditability and "Value Bet" analysis.
* **Observability:** Built-in **Prometheus** and **Actuator** endpoints to monitor system health and P99 latency.

---

## 🛠️ Tech Stack

| Component | Technology |
| :--- | :--- |
| **Language** | Java 25 (LTS) |
| **Framework** | Spring Boot 4.0.4 |
| **Messaging** | Spring WebSocket + STOMP |
| **In-Memory** | Redis 7.4 (Pub/Sub & Cache) |
| **Database** | PostgreSQL 17 |
| **Frontend** | React + TypeScript + Tailwind CSS |
| **Environment** | Docker & Docker Compose |

---

## 🚀 Execution Roadmap

### ✅ Phase 1: Infrastructure & Foundation
- [x] Project initialization with Spring Boot 4.0 & Java 25.
- [x] Dockerized environment for Postgres and Redis.
- [x] Virtual Thread performance tuning.
- [x] WebSocket handshake configuration.

### 🔄 Phase 2: Ingestion & Logic (Current)
- [ ] Implement High-Frequency Mock Ingestion Service.
- [ ] Redis Pub/Sub integration for internal event broadcasting.
- [ ] Odds volatility calculation logic.

### 📅 Upcoming Phases
- [ ] **Phase 3:** React Dashboard with "Price Flash" (Red/Green) animations.
- [ ] **Phase 4:** End-to-End Cloud Deployment (AWS/Vercel).
- [ ] **Phase 5:** Load testing and P99 Latency documentation.

---

## 💻 Local Setup

1. **Clone & Infrastructure**
   ```bash
   docker-compose up -d

2. **Backend Configuration
Ensure your application.properties points to localhost:5432 (Postgres) and localhost:6379 (Redis).

3. **Run the Engine
./mvnw spring-boot:run
