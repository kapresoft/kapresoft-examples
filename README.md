# kapresoft-examples
A repository for demonstrating examples for articles.

## Building

> Use the maven wrappers for simplicity

Supported JDK:  17+

### Build the POMS first

By running the script:
```shell
./install-poms.sh
```

Or by maven:
```shell
./mvnw clean install -N && ./mvnw -pl poms clean install
```

The poms should be in your m2 cache after successfully building.


### To build All
> Run at the parent directory

```shell
./mvnw install
```

OR

```shell
./mvnw clean install
```

### Compile individual modules

Example:
```shell
cd spring-boot-app
./mvnw install
```
