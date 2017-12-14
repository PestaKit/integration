#!/bin/bash

# build image pesta/users
../microservice-users/build-image.sh

# build image pesta/survey
../microservice-survey/build-image.sh

# bring topology up
cd docker-topologies
docker-compose up