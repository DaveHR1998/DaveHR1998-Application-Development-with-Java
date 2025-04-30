# Android Application Development with Java

This Android application demonstrates various UI components and Android functionalities, focusing on different types of ListViews and Dialogs.

## Project Overview

The Full Application is an educational project that showcases:

1. Different ListView implementations
2. Various Dialog types
3. ProgressBar usage

## Main Components

### Activities

1. [MainActivity](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/MainActivity.java:15:0-54:1): The entry point of the application, containing buttons to navigate to other activities.
2. [SimpleListViewActivity](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/SimpleListViewActivity.java:8:0-22:1): Demonstrates a basic ListView with a simple array of items.
3. [ArrayAdapterActivity](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/ArrayAdapterActivity.java:8:0-22:1): Shows the use of ArrayAdapter with a ListView.
4. [CustomListViewActivity](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/CustomListViewActivity.java:7:0-22:1): Illustrates a custom ListView with images and text.
5. [BaseAdapterListViewActivity](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/BaseAdapterListViewActivity.java:7:0-21:1): Exemplifies the use of a custom BaseAdapter.
6. `DialogActivity`: Showcases different types of dialogs.
7. [ProgressBarActivity](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/ProgressBarActivity.java:11:0-59:1): Demonstrates the use of indeterminate and determinate progress bars.

### Adapters

1. [CustomAdapter](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/CustomAdapter.java:12:0-39:1): A custom ArrayAdapter for the CustomListView.
2. [MyBaseAdapter](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/MyBaseAdapter.java:10:0-50:1): A custom BaseAdapter implementation.

### Fragments

1. [DatePickerDialogFragment](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/DatePickerDialogFragment.java:10:0-25:1): A fragment for date selection dialog.
2. [TimePickerDialogFragment](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication/TimePickerDialogFragment.java:10:0-24:1): A fragment for time selection dialog.

## Project Structure

The project follows the standard Android project structure:

- [app/src/main/java/com/smu/fullapplication/](cci:7://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/java/com/smu/fullapplication:0:0-0:0): Contains all Java source files
- [app/src/main/res/](cci:7://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/main/res:0:0-0:0): Contains resource files (layouts, drawables, etc.)
- [app/build.gradle](cci:7://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/build.gradle:0:0-0:0): App-level build configuration
- `build.gradle`: Project-level build configuration

## Setup and Running

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application on an emulator or physical device

## Dependencies

The project uses the following main dependencies:

- AndroidX AppCompat
- Material Components
- ConstraintLayout

For a full list of dependencies, refer to the [app/build.gradle](cci:7://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/build.gradle:0:0-0:0) file.

## Compatibility

- Minimum SDK: 24
- Target SDK: 35
- Compile SDK: 35

## Testing

The project includes basic instrumented and unit tests:

- [ExampleInstrumentedTest](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/androidTest/java/com/smu/fullapplication/ExampleInstrumentedTest.java:17:0-25:1): An instrumented test to verify the application context.
- [ExampleUnitTest](cci:2://file:///C:/Users/daveH/AndroidStudioProjects/Application%20Development%20with%20Java/app/src/test/java/com/smu/fullapplication/ExampleUnitTest.java:11:0-16:1): A simple unit test example.

## Contributing

This project is for educational purposes. Feel free to fork and expand upon it for your own learning.
