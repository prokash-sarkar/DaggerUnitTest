# Dagger Unit Test Sample

### Specs

[![API](https://img.shields.io/badge/API-16%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=16)

### Overview

If you have Dagger in your project but never used it for testing, it’s high time to give it a try. Dagger makes your code so much easier to test. Once the test setup is complete, all you have to do is plug and play with the dependencies. Also, dependency injection is a crucial concept in testing, and you should use it whenever possible.

### Article Link

To read the full article, please check [here](https://prokash-sarkar.medium.com/unit-testing-with-dagger-2-brewing-a-potion-with-fakes-mocks-and-custom-rules-in-android-7f0ab7b22cb).

### Architecture

The App uses MVVM design pattern along with a Data Repository.

### Project Details

The sample app has only one screen that searches through **Github** repo by a keyword. The app fetches the API response through a Data Repository and outputs the result inside a ```ViewModel```. Finally, an Activity watches for ```LiveData``` changes and sets the output inside a ```TextView```.

### 3rd Party Libraries

The app uses the following 3rd party libraries:

  - [Android Jetpack Components](https://developer.android.com/jetpack) (ViewModel, LiveData)
  - [Dagger 2](https://github.com/google/dagger)
  - [Retrofit](https://square.github.io/retrofit/)
  - [jUnit4](https://junit.org/junit4/)
  - [Mockk](https://mockk.io/)