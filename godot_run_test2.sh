#!/bin/bash
rm -rf test_client && mkdir -p test_client
(cd test_client && java -jar ../modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i https://raw.githubusercontent.com/heroiclabs/nakama/master/apigrpc/apigrpc.swagger.json \
    -l godotcpp)

godot="~/Private/Software/GodotEngine/godot/bin/godot.osx.tools.64"
# $godot -s sayhello.gd
