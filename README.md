# FetchRewards

**Environment**<br>
Android Studio 2020.3.1
SDK: Android 12
Tested with Pixel 3a XL (Android 12)

**Dependencies**
Gradle 7.0.4
Kotlin 1.6.10
Kotlin Dataframe 0.8.0-dev-877
Kotlin Coroutines 1.6.0

**Overview**<br>
* Retrives JSON data from specified URL and stores in a Kotlin DataFrame
* Removes entries with null or missing "name" with DataFrame operations
* Displays data in a scrolable table layout
