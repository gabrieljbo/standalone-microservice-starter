#!/bin/bash

export SERVER_SERVLET_CONTEXT_PATH=/project
export H2_DATABASE_URL=jdbc:h2:mem:database
export WEATHERREPORT_S3_BUCKET=test-bucket
export ELASTICSEARCH_CLUSTER=elastisearch-cluster
export ELASTICSEARCH_HOST=999.999.999.999
export ELASTICSEARCH_PORT=9200

mvn spring-boot:run
