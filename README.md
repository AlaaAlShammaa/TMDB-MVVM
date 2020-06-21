# TMDB-MVVM

👑 The TMDB-MVVM is based on Kotlin, MVVM architecture, coroutines, kotlin flow, koin, material designs and animations.

## Screeshots
<p align="center">
<img src="/preview/first_screen.png" width="32%"/>
<img src="/preview/second_screen.png" width="32%"/>
</p>

## What Open API Used?
[The Movies Database](https://developers.themoviedb.org/3/getting-started/introduction) (TMDB) is a community built movie and TV database.
Every piece of data has been added by our amazing community dating back to 2008.
TMDb's strong international focus and breadth of data is largely unmatched and something we're incredibly proud of.
Put simply, we live and breathe community and that's precisely what makes us different.

## How to build on your environment
Add your [The Movie DB](https://www.themoviedb.org)'s API key in your `key.properties` file.
if you don't have such file, please create a new file inside the app module and name it `key.properties`
Open the file and paste the following snippet in it (Don't forget to add your api key 😉)
```xml
tmdb_api_key=YOUR_API_KEY
```

## Module structure
The module structure is designed to try several different architectures.

<img src="/preview/arch_x3.png" width="100%"/>

## Entity module
[Entity module](/entity) composed of entity models for persisting in database and response models for fetching data from network requests. 

### Dependencies
- Room Persistence - constructing database (An abstraction layer over SQLite).
- [Gson converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - a converter which uses Gson for serialization to and from JSON.

## Network module
[Network module](/network) composed of abstractions for RESTful requests. 
An Interceptor for requesting every time with a query parameter `api_key`.

### Dependencies
- [Retrofit2](https://github.com/square/retrofit) - constructing the REST API.
- [Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - logs HTTP request and response data.
- [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - constructing a web server for testing HTTP clients.

## App-ui module
[app-ui module](/app-ui) composed of adapters and viewholders for composing recyclerview's item via databinding. And some factories and extensions related to custom views.

### Dependencies
- [Google-Material](https://github.com/material-components/material-components-android) - material Components for Android (MDC-Android) help developers execute Material Design.
- [Glide](https://github.com/bumptech/glide) - loading image.

## App module
[app module](/app) is the implementation of user interfaces on the application. 
Based on mvvm architecture (view-databinding-viewmodel-model), coroutines, kotlin flow with the repository pattern.

- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct database.
- [Koin](https://github.com/InsertKoinIO/koin) - dependency injection
- [Timber](https://github.com/JakeWharton/timber) - this is a logger with a small, extensible API.

## Unit Testing Frameworks
- [Robolectric](https://github.com/robolectric/robolectric) - Robolectric is the industry-standard unit testing framework for Android.
- [Mockito-Kotlin](https://github.com/nhaarman/mockito-kotlin) - a small library that provides helper functions to work with Mockito in Kotlin.

## User Interface Design
Based on `Material` design & animations.

- Google Material Design.
- Shared Element Transition (COMING SOON).

## Find this repository useful? :heart:
Support it by joining __[stargazers](https://github.com/AlaaAlShammaa/TMDB-MVVM/stargazers)__ for this repository. :star: <br>
And __[follow](https://github.com/AlaaAlShammaa)__ me for my next creations! 🤩

# License
```xml
Designed and developed by 2020 alaashammaa (Alaa Alshammaa)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
