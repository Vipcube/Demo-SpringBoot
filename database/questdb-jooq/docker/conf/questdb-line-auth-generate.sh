jose jwk gen -i '{"alg":"ES256", "kid": "test-user"}' -o ./questdb-line-auth.json

KID=$(cat ./questdb-line-auth.json | jq -r '.kid')
X=$(cat ./questdb-line-auth.json | jq -r '.x')
Y=$(cat ./questdb-line-auth.json | jq -r '.y')

echo "$KID ec-p-256-sha256 $X $Y" | tee ./questdb-line-auth.conf
