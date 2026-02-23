# SecureCart API (Spring Boot + PostgreSQL)

Interview-friendly JWT-secured e-commerce backend with role-based access (`ADMIN`, `CUSTOMER`) for **SecureCart API**.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Maven

## Package
`com.example.ecommerce`

## Database
`ecommercedb`

## Features
### Authentication
- Register (`CUSTOMER` only)
- Login
- JWT token generation

### ADMIN
- Add product
- Update product
- Delete product
- View all orders
- View analytics (`totalRevenue`, `totalOrders`, `topProduct`)

### CUSTOMER
- View products
- Place order
- View own orders

## Default Admin
Created on startup if not present:
- Username: `admin`
- Password: `admin123`

## Configuration
Set in `src/main/resources/application.properties`:
- `spring.datasource.url=jdbc:postgresql://localhost:5432/ecommercedb`
- `spring.datasource.username=postgres`
- `spring.datasource.password=postgres`
- `app.jwt.secret=...`
- `app.jwt.expiration-ms=86400000`

## Run
```bash
mvn clean spring-boot:run
```

## Main Endpoints
### Auth
- `POST /api/auth/register`
- `POST /api/auth/login`

### Products
- `GET /api/products` (ADMIN/CUSTOMER)
- `POST /api/products` (ADMIN)
- `PUT /api/products/{id}` (ADMIN)
- `DELETE /api/products/{id}` (ADMIN)

### Orders
- `POST /api/orders` (ADMIN/CUSTOMER)
- `GET /api/orders/me` (ADMIN/CUSTOMER)

### Admin
- `GET /api/admin/orders` (ADMIN)
- `GET /api/admin/analytics` (ADMIN)

## Sample Login Response
```json
{
  "token": "<JWT_TOKEN>"
}
```

Use header:
`Authorization: Bearer <JWT_TOKEN>`
