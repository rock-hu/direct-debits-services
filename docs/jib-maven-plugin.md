# jib-maven-plugin

```xml
<plugin>
  <groupId>com.google.cloud.tools</groupId>
  <artifactId>jib-maven-plugin</artifactId>
</plugin>
```

```bash
mvn compile jib:build
mvn -X -Djib.serialize=true compile jib:build
```

```bash
sudo docker login registry.gitlab.com
```

```bash
sudo docker build -t registry.gitlab.com/internal-developer-platform/openbanking-payments .
```

```bash
sudo docker push registry.gitlab.com/internal-developer-platform/openbanking-payments
```

