#! /bin/bash
mvn dependency:analyze > logs/analyze.log
mvn dependency:analyze-dep-mgt > logs/analyze-dep-mgt.log
mvn dependency:analyze-report  > logs/analyze-report.log
mvn dependency:analyze-duplicate  > logs/analyze-duplicate.log
mvn dependency:list > logs/list.log
mvn dependency:resolve > logs/resolve.log
mvn dependency:resolve-plugins  > logs/resolve-plugins.log
mvn dependency:tree  > logs/tree.log
cat logs/list.log | sort | uniq > logs/list-sort.log
