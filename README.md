# PlayerRestAPI
## About
A REST API where users can perform CRUD operations on a player object.

## Operations of the RestController
1. Get the details of all the players (GET Request)
```
localhost:8080/players
```

2. Get a player by ID (GET Request)
```
localhost:8080/player/{pId}
```

3. Add a new player (POST Request)
```
localhost:8080/player/add
```

4. Update the details of an existing player by ID (PUT Request)
```
localhost:8080/player/{pId}/update
```

5. Delete a player by ID (DELETE Request)
```
localhost:8080/player/{pId}/delete
```
