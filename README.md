# Spring Boot and Vault

Execute a docker-compose.yml file inside the infra folder.

Access Vault GUI through the host http://127.0.0.1:8200

Vault initial configuration needs the creation of ***key shares*** and ***key threshold***

- Key shares are the keys that will be generated to unsealed Vault and key threshold is the number of minimum keys to unseal it.

For generate key shares you can generate a hash sha256 and convert to base64.

The result of key generation will create a json

```
{
  "keys": [
    "569f87772c01413d36d685fc8392f2a4aadaff997daad50",
    "8ec460f2491eb44bd75c73fd007d1c077e226400bfae9b2",
    "f339ef03dc2a770829fa0567804eb541e1993b7032f0c1e"
  ],
  "keys_base64": [
    "Vp+HdywBQT021oX8g5LypKra/5l9qtUPUTeN",
    "jsRg8kketEvXXHP9AH0cB34iZAC/rpsk1f4Z",
    "8znvA9wqdwgp+gVngE61QeGZO3Ay8MHrvnoR"
  ],
  "root_token": "hvs.E25PQZ9E32babVuJubY"
}
```

ps: save this json file when generated.

-------------------------------------

Access secret menu through the host http://127.0.0.1:8200

Create a KV secret repository named "features" with KV version 1

Create a KV secret repository named "features2" with KV version 2

Execute the api and test with endpoints **/status/v1** and **/status/v2**

The result will be a json

```
{
  "enabled": true
}
```

ps: maybe the VAULT_DEV_ROOT_TOKEN_ID doesn't work, if that happens you can set de token at application.yml to your generated root token when you configured the Vault
