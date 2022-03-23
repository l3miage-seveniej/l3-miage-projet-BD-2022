#!/bin/sh

docker run \
    --name myadmin \
    --rm --detach \
    --link mariadb:db \
    -p 3306:3306 \
    phpmyadmin