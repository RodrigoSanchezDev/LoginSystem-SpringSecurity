# Example Usage

Below is an example of how to interact with the Login System API.

## Login Example (cURL)
```bash
curl -X POST http://localhost:8080/api/auth/login \
     -H "Content-Type: application/json" \
     -d '{"username": "testuser", "password": "password123"}'
