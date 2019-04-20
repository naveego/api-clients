#!/bin/bash

# Generates All Client Packages for Auth Microservice
autorest ./generator.md

# Compile the Node library with Typescript support
(cd node && npm run compile)

# Build the dotnet core project
(cd csharp && dotnet build)

# Build the java project
(cd java && mvn package)