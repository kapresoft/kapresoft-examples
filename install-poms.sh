#!/usr/bin/env zsh


_Main() {
  local cmd
  local parentPoms
  local childPoms
  parentPoms=("poms/common-dependencies.xml" "poms/common-dependencies-spring.xml" "pom.xml")
  childPoms=("poms/java-app-starter-parent.xml")

  for pom in "${parentPoms[@]}" ; do
      cmd="./mvnw -f $pom clean install -N"
      echo "Executing: $cmd"
      eval "${cmd}" || exit 1
  done
  for pom in "${childPoms[@]}" ; do
      cmd="./mvnw -f $pom clean install -N"
      echo "Executing: $cmd"
      eval "${cmd}" || exit 1
  done
}

_Main
