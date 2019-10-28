#!/bin/bash
rm -rf test_client && mkdir -p test_client
(cd test_client && java -jar ../modules/openapi-generator-cli/target/openapi-generator-cli.jar generate \
    -i https://raw.githubusercontent.com/googleforgames/agones/d64bf53ee98fae6135128eb9e9c47897b09cea28/sdk.swagger.json \
    -g c)

godot="~/Private/Software/GodotEngine/godot/bin/godot.osx.tools.64"
# $godot -s sayhello.gd
