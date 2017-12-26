#!/bin/sh
#
# This script is for use by tools such as NetBeans.
# You are not supposed to call it directly.
#
# We computed bundle root path up to the ".app" included.
APPLICATION=`echo $0 | sed -e 's#^\(.*\)/Contents.*#\1#'`

open -a "$APPLICATION" "$@"

