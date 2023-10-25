#!/usr/bin/env bash

# Een optie om de data te importeren is om een csv import en daarna een aggregate query uit te voeren

mongosh /shared/dropDb.js
echo "CSV erin"
mongoimport --type=csv --headerline --db=fabriek --collection import_demo /csv/klant.csv
echo "Query demo"
mongosh fabriek /shared/aggregate.js
# Dit is zeker niet de enige manier, maar mocht je deze kant op willen, dan is dit alvast een eerste opzetje
