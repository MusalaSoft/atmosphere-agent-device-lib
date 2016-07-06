# atmosphere-agent-device-lib
The agent-device libraries of the ATMOSPHERE mobile testing framework

## Project setup
> This project depends on the [atmosphere-commons](https://github.com/MusalaSoft/atmosphere-commons) libraries, so make sure you publish `atmosphere-commons` to your local Maven repository first.


### Build the project
You can build the project using the included Gradle wrapper by running:
* `./gradlew build` on Linux/macOS
* `gradlew build` on Windows

### Publish to Maven Local
If the build is successful, also run:
* `./gradlew publishToMavenLocal` on Linux/macOS
* `gradlew publishToMavenLocal` on Windows

to publish the jar to the local Maven repository, so other projects that depend on it can use it.
