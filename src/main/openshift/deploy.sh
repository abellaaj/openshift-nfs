#!/usr/bin/env bash

typeset SCRIPT_DIR=$(dirname "${BASH_SOURCE[0]}")

#images
oc import-image @project.artifactId@:@project.version@ --from=@docker.image.name@ --confirm --insecure=true

oc apply -f @project.build.directory@/openshift/configMap.yml
oc apply -f @project.build.directory@/openshift/service.yml
oc apply -f @project.build.directory@/openshift/deploymentConfig.yml
oc apply -f @project.build.directory@/openshift/route.yml
