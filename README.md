# Example of Kotlin + RecyclerView + RESTful service

[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)

## Configuration

This app relies on a back-end for getting data. Check out [this repository](https://github.com/naXa777/dummy-web-app-2) to set it up.

When you get the back-end up and running, change server url in `TheUniversityAPISpiceService#getServerUrl()`

## Dependencies

**Build system**: [Gradle](https://gradle.org/)

* Android SDK 27
* [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/index.html), version 1.2.61
* [Anko](https://github.com/Kotlin/anko)
* [RoboSpice](https://github.com/stephanenicolas/robospice) (deprecated)
* [Retrofit](https://github.com/square/retrofit), version 1.6
* [OkHttp](https://github.com/square/okhttp)
* [Gson](https://github.com/google/gson)

## Permissions:

- internet access
- access information about networks

## Screenshots

![Loading indicator](/screenshots/loading.png)