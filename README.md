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

## Project Structure

- **Jetpack Compose**: The entire UI is built using Jetpack Compose, providing a declarative approach for building user interfaces.
- **Notification Handling**: Demonstrates handling different notification types and their interactions on various Android versions.
- **Deep Linking**: Allows the app to be launched into specific parts of the app when users click notifications or external links.

## Screenshots

![notifi_6](https://github.com/user-attachments/assets/e03c1908-3a2d-427b-b5c6-c9a3ccf1d77c)
![Notifi_1](https://github.com/user-attachments/assets/c12d2f48-cd38-401c-baf3-b79351c504b7)
![notifi_2](https://github.com/user-attachments/assets/27c86cd2-a0a2-42be-99f8-a57d41709e5f)
![notifi_3](https://github.com/user-attachments/assets/97a233f9-a118-45a1-8b0b-ae27f1c24f16)
![notifi_4](https://github.com/user-attachments/assets/ba8f6fd2-7c2f-4646-bb92-fa60f76f5b82)
![notifi_5](https://github.com/user-attachments/assets/a37bd7e2-d8c5-4137-aaf9-72d7bd374228)


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
