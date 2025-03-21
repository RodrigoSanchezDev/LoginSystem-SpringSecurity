# API Documentation

## Endpoints

### POST /api/auth/login
- **Description:** Authenticates a user and returns a JWT token (or establishes a session).
- **Request Body:** JSON containing `username` and `password`.
- **Response:** A JSON object with token and user details.

### POST /api/auth/register
- **Description:** Registers a new user.
- **Request Body:** JSON containing user details.
- **Response:** Confirmation of successful registration.

_For further API details, please refer to inline Swagger annotations in the code or the dedicated API documentation tools if integrated._
