#!/bin/bash
set -e
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  CREATE DATABASE fabriek;
EOSQL

echo 'Running fabriek.sql'
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname fabriek -f /shared/fabriek.sql
