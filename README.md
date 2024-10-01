Vault path:
```text
http://localhost:8200/ui/vault/secrets/microservices/kv/truth-or-dare-tg-bot-questions-service%2Fdev%2Fdb/details?version=3
```
Vault config:
```json
{
  "db.data-source.driver-class-name": "org.h2.Driver",
  "db.data-source.jdbc-url": "jdbc:h2:mem:${db.data-source.port}/${db.data-source.name}",
  "db.data-source.name": "testdb",
  "db.data-source.password": "sa",
  "db.data-source.port": 9006,
  "db.data-source.username": "sa"
}
```