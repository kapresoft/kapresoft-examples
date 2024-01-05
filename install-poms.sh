#!/usr/bin/env zsh

_Main() {
  local cmd="./mvnw clean install -N"
  local cmdPoms="./mvnw -pl poms clean install"
  cmd="${cmd} && ${cmdPoms}"
  echo "Executing: ${cmd}"
  eval "${cmd}"
}

_Main
