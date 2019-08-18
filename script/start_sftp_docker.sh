#!/usr/bin/env bash
container="sftp"
docker rm -f "$sftp"
docker run -p 22:22 --name "$container" -d atmoz/sftp mike:password123:::upload
sleep 3
docker logs "$container"