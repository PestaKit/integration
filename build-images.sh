#!/bin/bash

# build image pestakit/users
cd ../microservice-users
./build-image.sh

# build image pestakit/surveys
cd ../microservice-survey
./build-image.sh

