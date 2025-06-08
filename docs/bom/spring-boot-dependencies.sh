while IFS="," read -r groupId artifactId version
do
    echo $groupId $artifactId $version
    flatten=`echo $groupId | sed 's/\./\//g'`
    echo $flatten
    echo https://repo1.maven.org/maven2/$flatten/$artifactId/$version/$artifactId-$version.pom
    curl -o $artifactId-$version.pom.xml https://repo1.maven.org/maven2/$flatten/$artifactId/$version/$artifactId-$version.pom

done <  spring-boot-dependencies.csv