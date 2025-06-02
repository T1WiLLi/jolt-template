FROM postgres:17

COPY sql/structure.sql /docker-entrypoint-initdb.d/1_structure.sql
COPY sql/mock.sql /docker-entrypoint-initdb.d/2_mock.sql