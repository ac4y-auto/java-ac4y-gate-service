# java-ac4y-gate-service - Architektúra Dokumentáció

## Áttekintés

Gate service modul - REST kliens az Ac4y hitelesítési átjáróhoz.

**Verzió:** 1.0.0
**Java verzió:** 1.8
**Szervezet:** ac4y-auto

## Fő Komponensek

### 1. Ac4yGateServiceClient

**Csomag:** `ac4y.gate.service.client`

REST kliens a gateway API-hoz.

**Konstruktor:** `Ac4yGateServiceClient(String host)` - gateway URL

**Metódusok:**
- `getAllUsers()` → `GateGetAllUsersResponse` - GET /gate/user
- `login(GateLoginRequest)` → `GateLoginResponse` - POST /gate/login
- `insertUser(GateInsertUserRequest)` → `GateInsertUserResponse` - POST /gate/insertuser

**Hibakezelés:** IOException esetén error response-t ad vissza (nem dob kivételt).

### 2. Request/Response DTO-k

| Osztály | Típus | Leírás |
|---------|-------|--------|
| GateLoginRequest | Request | user + password |
| GateLoginResponse | Response | Ac4yServiceResponse |
| GateInsertUserRequest | Request | user + password |
| GateInsertUserResponse | Response | Ac4yServiceResponse |
| GateGetAllUsersResponse | Response | List<Ac4yUser> |

### 3. Algebra osztályok

- `GateUserAndPasswordRequestAlgebra` - user + password mezők
- `GateLoginRequestAlgebra` extends ↑
- `GateInsertUserRequestAlgebra` extends ↑
- `GateGetAllUsersResponseAlgebra` - List<Ac4yUser> + Ac4yServiceResponse

## Függőségek

- `ac4y-gate-domain` - Ac4yUser entitás
- `ac4y-service-domain` - Ac4yServiceResponse, Ac4yRestServiceClient
- `gson` - JSON szerializáció

## AI Agent Használati Útmutató

### Gyors Döntési Fa

1. **Bejelentkezés kell?** → `client.login(new GateLoginRequest(user, pass))`
2. **Regisztráció kell?** → `client.insertUser(new GateInsertUserRequest(user, pass))`
3. **Összes user kell?** → `client.getAllUsers()`

### API Végpontok

| Művelet | HTTP | Végpont | Request | Response |
|---------|------|---------|---------|----------|
| Login | POST | /gate/login | GateLoginRequest | GateLoginResponse |
| Insert User | POST | /gate/insertuser | GateInsertUserRequest | GateInsertUserResponse |
| Get All Users | GET | /gate/user | - | GateGetAllUsersResponse |

## Eredetileg

`IJAc4yGateModule/IJAc4yGateService` modulból kiemelve.

---
**Utolsó frissítés:** 2026-02-06
