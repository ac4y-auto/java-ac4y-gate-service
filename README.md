# java-ac4y-gate-service

Gate service module - REST client for the Ac4y authentication gateway.

## Maven Dependency

```xml
<dependency>
    <groupId>ac4y</groupId>
    <artifactId>ac4y-gate-service</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Overview

REST client for the Ac4y Gateway authentication API. Provides:
- **Login** - POST /gate/login
- **User registration** - POST /gate/insertuser
- **List all users** - GET /gate/user

Uses GSON for JSON serialization and `Ac4yRestServiceClient` for HTTP transport.

## Dependencies

- `ac4y:ac4y-gate-domain:1.0.0` (user entity)
- `ac4y:ac4y-service-domain:1.0.0` (service response, REST client)
- `com.google.code.gson:gson:2.6.2` (JSON)

## Usage

```java
Ac4yGateServiceClient client = new Ac4yGateServiceClient("http://gateway:8080");

// Login
GateLoginResponse loginResp = client.login(new GateLoginRequest("user", "pass"));

// Register user
GateInsertUserResponse insertResp = client.insertUser(new GateInsertUserRequest("newuser", "newpass"));

// List users
GateGetAllUsersResponse allUsers = client.getAllUsers();
```

## Package Structure

- `ac4y.gate.service.client` - Ac4yGateServiceClient REST kliens
- `ac4y.gate.service.domain` - Request/Response DTO-k
- `ac4y.gate.service.algebra` - Algebra alap osztályok

## Build

```bash
mvn clean install
mvn test
```

## Origin

Extracted from `IJAc4yGateModule/IJAc4yGateService` module.

---
**Version:** 1.0.0
