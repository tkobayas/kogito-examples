### POST /warnings

Returns warning level alerts caused by incoming events:

```sh
curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"eventData":[{"type":"temperature","value":25}, {"type":"temperature","value":35}]}' http://localhost:8080/warnings
```

Example response:

```json
[{"severity":"warning","message":"Event [type=temperature, value=40]"}]
```
