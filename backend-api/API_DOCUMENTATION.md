# DreamBuild API Documentation

## Builder API Endpoints

### Create Builder
```http
POST /api/builder
Content-Type: application/json

{
    "name": "Hu Tao",
    "email": "genshinimpact@email.com",
    "password": "1234567",
    "address": "0014 Wangsheng Funeral Parlor, Harbor, Liyue, 12345",
    "parts": [],
    "builds": []
  }
```

### Update Builder
```http
POST /api/builder/{id}
Content-Type: application/json

{
    "name": "Snow Laiden Hu Tao",
    "email": "updategenshinimpact@email.com",
    "password": "1234567",
    "address": "0053 Wangsheng Funeral Parlor, Harbor, Liyue, 12345",
    "parts": [],
    "builds": []
  }
```

### Get Builders
```http
GET /api/builder
```

### Get Builders by ID
```http
GET /api/builder/{id}
```

### Get Builders by Email
```http
GET /api/builder/email?email={search term}
```

### Delete Builder 
```http
DELETE /api/builder/{id}
```

## Computer API Endpoints
### Create Computer
```http
POST /api/computer
Content-Type: application/json

{
    "description": "Tu's Linux Workstation",
    "createdAt": "2025-10-28T00:00:00",
    "price": 999.99,
    "quantity": 1,
    "cpu": {
      "id": 2,
      "name": "AMD Ryzen 7 5700X3D",
      "description": "AM4 CPU with 8 cores and 16 threads",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "CPU",
      "price": 179.99,
      "quantity": 10
    },
    "gpu": {
      "id": 3,
      "name": "AMD Radeon 9070",
      "description": "A GPU that is good for 1440p gaming",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "GPU",
      "price": 549.99,
      "quantity": 10
    },
    "mobo": {
      "id": 7,
      "name": "GIGABYE AORUS B550",
      "description": "AM4 Motherboard",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "MOBO",
      "price": 149.99,
      "quantity": 10
    },
    "pcCase": {
      "id": 4,
      "name": "Cooler Master NR200P",
      "description": "Compact mini ITX case",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "CASE",
      "price": 89.99,
      "quantity": 10
    },
    "fan": {
      "id": 6,
      "name": "Noctua Fan",
      "description": "Brown fans that are very quiet",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "FANS",
      "price": 24.99,
      "quantity": 10
    },
    "prebuilt": true
  }
```

### Update Computer
```http
PUT /api/computer/{id}
Content-Type: application/json

{
    "description": "Tu's Updated Linux Workstation",
    "createdAt": "2025-10-28T00:00:00",
    "price": 999.99,
    "quantity": 1,
    "cpu": {
      "id": 2,
      "name": "AMD Ryzen 7 5700X3D",
      "description": "AM4 CPU with 8 cores and 16 threads",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "CPU",
      "price": 179.99,
      "quantity": 10
    },
    "gpu": {
      "id": 3,
      "name": "AMD Radeon 9070",
      "description": "A GPU that is good for 1440p gaming",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "GPU",
      "price": 549.99,
      "quantity": 10
    },
    "mobo": {
      "id": 7,
      "name": "GIGABYE AORUS B550",
      "description": "AM4 Motherboard",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "MOBO",
      "price": 149.99,
      "quantity": 10
    },
    "pcCase": {
      "id": 4,
      "name": "Cooler Master NR200P",
      "description": "Compact mini ITX case",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "CASE",
      "price": 89.99,
      "quantity": 10
    },
    "fan": {
      "id": 6,
      "name": "Noctua Fan",
      "description": "Brown fans that are very quiet",
      "createdAt": "2025-10-27T00:00:00",
      "partType": "FANS",
      "price": 24.99,
      "quantity": 10
    },
    "prebuilt": true
  }
```

### Get Computers
```http
GET /api/computer
```

### Get Computer by ID
```http
GET /api/computer/{id}
```

### Get Computer by Builder ID
```http
GET /api/computer/builder/{id}
```

### Delete Computer
```http
DELETE /api/comptuer/{id}
```

## PC Part API Endpoints
### Create PC Part
```http
POST /api/pcpart
Content-Type: application/json

{
    ""name": "AMD Ryzen 7 5700X3D",
    "description": "AM4 CPU with 8 cores and 16 threads",
    "createdAt": "2025-10-27T00:00:00",
    "partType": "CPU",
    "price": 179.99,
    "quantity": 10
  }
```

### Update PC Part
```http
PUT /api/pcpart/{id}
Content-Type: application/json

{
    ""name": "AMD Ryzen 7 5800X3D",
    "description": "AM4 CPU with 8 cores and 16 threads",
    "createdAt": "2025-10-27T00:00:00",
    "partType": "CPU",
    "price": 209.99,
    "quantity": 10
  }
```

### Get PC Parts
```http
GET /api/pcpart
```

### Get PC Parts by Builder ID
```http
GET /api/pcpart/builder/{id}
```

### Get PC Part by Type
```http
GET /api/pcpart/type?type={search term}
```

### Delete PC Part 
```http
DELETE /api/pcpart/{id}
```