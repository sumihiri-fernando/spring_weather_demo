FROM ubuntu:latest
LABEL authors="sumih"

ENTRYPOINT ["top", "-b"]