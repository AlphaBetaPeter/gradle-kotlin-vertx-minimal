# gradle-kotlin-vertx-minimal
minimal project stub with gradle, kotlin and vertx


#using the gradle daemon
Create a file named gradle.properties in the following directory:

`/home/<username>/.gradle/` (Linux)

`/Users/<username>/.gradle/` (Mac)

`C:\Users\<username>\.gradle` (Windows)

Add this line to the file:
`org.gradle.daemon=true`
After this, the message won't appear. Subsequent builds will be noticeably faster.