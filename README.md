# FetchRewards

**Environment**<br>
Android Studio 2020.3.1<br>
SDK: Android 12<br>
Tested with Pixel 3a XL (Android 12)<br>

**Dependencies**<br>
Gradle 7.0.4<br>
Kotlin 1.6.10<br>
Kotlin Dataframe 0.8.0-dev-877<br>
Kotlin Coroutines 1.6.0<br>

**Overview**<br>
* Retrives JSON data from specified URL and stores in a Kotlin DataFrame
* Removes entries with null or missing "name" with DataFrame operations
* Displays data in a scrolable table layout
