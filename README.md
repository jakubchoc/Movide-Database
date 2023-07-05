# MovieDatabase

Movie database is API which represent database for management movies, directors and actors.
Is possible to create users with USER and ADMIN role for rights.

## Getting started

API is possible to clone in to your computer and launch on localhost. Is necessary to change your
database credentials and possibly create some basic data.

## Authentication and Security

API has authentication for user. Every user needs to be registered and sign in. Basic user 
without admin role can use all GET endpoints and create movies or users.

## Documentation

User Controller:
 - GET /api/user - return user credentials 
 - POST /api/register - user registration, return user credentials
 - POST /spi/login - user login
 - DELETE /api/logout - user logout

Movie Controller:
 - GET /api/genres - return movie genres
 - GET /api/movies - return all movies. Is possible to use movie filter by from year, to year, genre, actor or director
 - GET /api/movie{movieId} - return specific movie by id
 - POST /api/movie - create movie record
 - PUT /api/movie/{movieId} - movie edit
 - DELETE /api/movie{movieId} - delete movie

Person Controller
 - GET /api/people/{personId} - return specific person
 - GET /api/directors - return all directors
 - GET /api/actors - return all actors
 - POST /api/people - create actor or director
 - PUT /api/people - person edit

## Error Handling

API use own exceptions and return necessary status codes

## Example

API calls is possible to try by swagger:

- [ ] [swagger](http://localhost:8080/swagger-ui/index.html#/) 


