#!/bin/bash

export ROOTDIR=$PWD/..

# build image pestakit/users
cd $ROOTDIR/microservice-users
./build-image.sh

# build image pestakit/surveys
cd $ROOTDIR/microservice-survey
./build-image.sh

