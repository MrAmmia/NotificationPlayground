# Notification Playground

This project showcases handling various types of notifications, implementing navigation, and deep linking in an Android app. Built with **Jetpack Compose**, it supports devices running Android M (Marshmallow) and below, and utilizes **Dependency Injection** to manage its components.

## Features

- **Notifications**: Demonstrates handling multiple types of notifications (basic, expandable, action buttons, etc.).
- **Navigation**: Implements seamless navigation in response to user interaction with notifications.
- **Deep Linking**: Supports deep linking to different sections of the app directly from notifications.
- **Jetpack Compose**: Built using the modern UI toolkit to design UIs declaratively.
- **Backward Compatibility**: Supports devices running Android M and below while maintaining modern Android standards.
- **Dependency Injection**: Utilizes Dependency Injection to manage objects and their lifecycles.

## Tech Stack

- **Programming Language**: Kotlin
- **UI**: Jetpack Compose
- **Dependency Injection**: Dagger-Hilt
- **Navigation**: Jetpack Navigation Component with support for deep links
- **Notifications**: Custom notification handling for different API levels
- **Retrofit/OkHttp**: For network calls (if applicable)

## Project Structure

- **Jetpack Compose**: The entire UI is built using Jetpack Compose, providing a declarative approach for building user interfaces.
- **Notification Handling**: Demonstrates handling different notification types and their interactions on various Android versions.
- **Deep Linking**: Allows the app to be launched into specific parts of the app when users click notifications or external links.

## Screenshots


## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/MrAmmia/NotificationPlayground.git
   cd NotificationPlayground
2. **Build the project**: Open the project in Android Studio, sync Gradle dependencies, and ensure you have a connected device or emulator set up.
3. **Run the app**: Build and run the project on an Android emulator or a physical device.

## How It Works
- **Notification Handling**: The app demonstrates how to create different types of notifications, including:
    - Basic notifications
    - Notifications with action buttons
    - Expandable notifications
    - Notifications that launch specific parts of the app using deep links
- **Jetpack Compose**: The entire UI is constructed using Jetpack Compose, including notification-related UI elements and deep-linked content.
- **Navigation and Deep Linking**:
    - The app integrates Jetpack Navigation for seamless navigation between screens.
    - Deep linking is implemented to allow users to navigate directly to specific destinations in the app from notifications or external sources.


## Project Highlights
- **Jetpack Compose UI**: A modern declarative UI built using Jetpack Compose.
- **Notification Compatibility**: Caters to devices below Android M, ensuring proper notification handling across a wide range of Android versions.
- **Dependency Injection**: The app uses Dagger-Hilt to inject dependencies efficiently.
- **Deep Linking Support**: Deep links enable the app to handle external requests and navigate users directly to relevant content.

## Contributing
Contributions are welcome! Feel free to fork this repository, open issues, and submit pull requests.
