#!/bin/bash
rm -rf test_client && mkdir -p test_client
(cd test_client && java -jar ../modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i https://raw.githubusercontent.com/heroiclabs/nakama/master/apigrpc/apigrpc.swagger.json \
    -p -l gdscript)

java -cp modules/swagger-codegen-cli/target/swagger-codegen-cli.jar io.swagger.codegen.jcpp.Main -S -P \
	-I ./test_client \
	< ./test_client/NakamaApi.gd > ./test_client/NakamaApiClient.gd

sed -i '' 's/__String__//g' ./test_client/NakamaApiClient.gd
sed -i '' 's/{ dict }/{ }, body/g' ./test_client/NakamaApiClient.gd

godot="~/Private/Software/GodotEngine/godot/bin/godot.osx.tools.64"
# $godot -s sayhello.gd
